package com.example.notesappkotlin.domain.note

import com.example.notesappkotlin.presentation.*
import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime,
) {
    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, BabyBlueHex, VioletHex, LightGreenHex);
        fun generateRandomColor() = colors.random()
    }
}