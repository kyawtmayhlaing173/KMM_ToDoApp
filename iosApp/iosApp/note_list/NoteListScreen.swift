//
//  NoteListScreen.swift
//  iosApp
//
//  Created by Kyawt May Hlaing on 9/6/2567 BE.
//  Copyright © 2567 BE orgName. All rights reserved.
//

import SwiftUI
import shared

struct NoteListScreen: View {
    private var noteDataSource: NoteDataSource
    @StateObject var viewModel = NoteListViewModel(noteDataSource: nil)
    
    @State private var isNoteSelected = false
    @State private var selectedNoteId: Int64? = nil
    
    init(noteDataSource: NoteDataSource) {
        self.noteDataSource = noteDataSource
    }
    @State private var path: [String] = []
    
    var body: some View {
        NavigationStack(path: $path) {
            VStack {
                ZStack {
                    HideableSearchTextField<NoteDetailScreen>(
                        onSearchToggled: {
                            viewModel.toggleSearchActive()
                        },
                        destinationProvider: {
                            NoteDetailScreen(noteDataSource: noteDataSource, noteId: selectedNoteId)
                        },
                        isSearchActive: viewModel.isSearchActive,
                        searchText: $viewModel.searchText
                    )
                    .frame(maxWidth: .infinity, minHeight: 40)
                    .padding()
                    
                    if !viewModel.isSearchActive {
                        Text("All notes")
                            .font(.title2)
                    }
                }
                
                List {
                    ForEach(viewModel.filteredNotes, id: \.self.id) { note in

                        Button(action: {
                            isNoteSelected = true
                            selectedNoteId = note.id?.int64Value
                            path.append(String(note.id?.int64Value ?? 0))
                        }) {
                            NoteItem(note: note, onDeleteClick: {
                                viewModel.deleteNoteById(id: note.id?.int64Value)
                            })
                        }
                    }
                }
                .navigationDestination(for: String.self, destination: { id in
                    NoteDetailScreen(noteDataSource: noteDataSource, noteId: Int64(id))
                })
                .onAppear {
                    viewModel.loadNotes()
                }
                .listRowSeparator(.hidden)
                .listStyle(.plain)
            }
            .onAppear {
                viewModel.setNoteDataSource(noteDataSource: noteDataSource)
            }
        }
    }
}

#Preview {
    EmptyView()
}
