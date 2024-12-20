package com.example.notesappkotlin.data.note

import com.example.notesappkotlin.domain.note.Note
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntity.toNote() = Note(
    id = id,
    title = title,
    content = content,
    colorHex = colorHex,
    created = Instant.fromEpochMilliseconds(created).toLocalDateTime(TimeZone.currentSystemDefault())
)