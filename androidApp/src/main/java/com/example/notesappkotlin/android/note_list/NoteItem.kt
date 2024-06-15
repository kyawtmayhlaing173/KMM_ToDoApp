package com.example.notesappkotlin.android.note_list

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesappkotlin.domain.note.Note
import com.example.notesappkotlin.domain.time.DateTimeUtil
import com.example.notesappkotlin.presentation.RedOrangeHex
import com.example.notesappkotlin.presentation.RedPinkHex
import kotlinx.datetime.LocalDateTime

@Composable
fun NoteItem(
    note: Note,
    backgroundColor: Color,
    onNoteClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val formattedDate = remember(note.created) {
        DateTimeUtil.formatNoteDate(note.created)
    }

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(backgroundColor)
            .clickable { onNoteClick() }
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = note.title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close Button")
            
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(note.content, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(16.dp))
        Text(formattedDate, color = Color.DarkGray, modifier = Modifier.align(Alignment.End))
    }
}

@Preview
@Composable
fun NoteItemPreview() {
    NoteItem(
        note = Note(
            id = 1,
            title = "Some random Title",
            content = "Some random Content",
            colorHex = RedOrangeHex,
            created = LocalDateTime.parse("2021-08-01T12:00:00"
            )
        ),
        backgroundColor = Color(RedOrangeHex),
        onNoteClick = { /*TODO*/ },
        onDeleteClick = { /*TODO*/ },)
}