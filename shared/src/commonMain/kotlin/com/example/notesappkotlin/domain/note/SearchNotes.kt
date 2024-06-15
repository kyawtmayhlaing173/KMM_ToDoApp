package com.example.notesappkotlin.domain.note

import com.example.notesappkotlin.domain.time.DateTimeUtil

class SearchNotes {
    fun execute(notes: List<Note>, query: String): List<Note> {
        return notes.filter {
            it.title.trim().lowercase().contains(query.lowercase()) || it.content.trim().lowercase().contains(query, ignoreCase = true)
        }.sortedBy {
            DateTimeUtil.toEpochMillis(it.created)
        }
    }
}