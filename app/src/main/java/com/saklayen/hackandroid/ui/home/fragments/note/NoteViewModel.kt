package com.saklayen.hackandroid.ui.home.fragments.note

import androidx.lifecycle.ViewModel
import com.saklayen.hackandroid.room.Note
import com.saklayen.hackandroid.room.repository.RoomRepository
import javax.inject.Inject

class NoteViewModel @Inject constructor(val noteRepository: RoomRepository): ViewModel() {
    fun saveNote(note: Note){
        noteRepository.addNote(note)
    }
}