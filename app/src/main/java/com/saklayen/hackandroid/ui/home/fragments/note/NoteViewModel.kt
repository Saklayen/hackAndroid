package com.saklayen.hackandroid.ui.home.fragments.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saklayen.hackandroid.room.Note
import com.saklayen.hackandroid.room.repository.RoomRepository
import com.saklayen.hackandroid.util.Event
import javax.inject.Inject

class NoteViewModel @Inject constructor(val noteRepository: RoomRepository): ViewModel() {

    lateinit var allNotes :LiveData<List<Note>>
    fun saveNote(note: Note){
        noteRepository.addNote(note)
    }

    fun getAllNotes(){
        allNotes = noteRepository.getAllNotes()
    }
}
