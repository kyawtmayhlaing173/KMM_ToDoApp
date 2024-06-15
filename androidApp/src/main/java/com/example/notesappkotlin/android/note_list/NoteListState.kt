package com.example.notesappkotlin.android.note_list

import com.example.notesappkotlin.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)
