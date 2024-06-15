package com.example.notesappkotlin.data.local.di

import com.example.notesappkotlin.NoteDatabase
import com.example.notesappkotlin.data.local.DatabaseDriverFactory
import com.example.notesappkotlin.data.note.SqlDelightNoteDataSource
import com.example.notesappkotlin.domain.note.NoteDataSource

class DatabaseModule {
    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}