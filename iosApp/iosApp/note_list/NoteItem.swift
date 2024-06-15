//
//  NoteItem.swift
//  iosApp
//
//  Created by Kyawt May Hlaing on 13/6/2567 BE.
//  Copyright © 2567 BE orgName. All rights reserved.
//

import SwiftUI
import shared

struct NoteItem: View {
    var note: Note
    var onDeleteClick: () -> Void
    
    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                Text(note.title)
                    .font(.title3)
                    .fontWeight(.semibold)
                Spacer()
                Button(action: onDeleteClick, label: {
                    Image(systemName: "xmark").foregroundColor(.black)
                })
            }.padding(.bottom, 3)
            
            Text(note.content)
                .fontWeight(.light)
                .padding(.bottom, 3)
            
            HStack {
                Spacer()
                Text(DateTimeUtil().formatNoteDate(dateTime: note.created))
                    .font(.footnote)
                    .fontWeight(.light)
            }
        }
        .padding()
        .background(Color(hex: note.colorHex))
        .clipShape(RoundedRectangle(cornerRadius: 5.0))
    }
}

#Preview {
    NoteItem(
               note: Note(id: nil, title: "My note", content: "Note content", colorHex: 0xFF2341, created: DateTimeUtil().now()),
               onDeleteClick: {}
           )
}
