package com.saklayen.hackandroid.room.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.saklayen.hackandroid.room.Database
import com.saklayen.hackandroid.room.Note
import com.saklayen.hackandroid.room.NoteDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RoomRepository @Inject constructor(val noteDao: NoteDao){

    fun addNote(note: Note){
        Log.e("NOTE ","note--> ${note.title} ${note.description}")
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.addNotes(note)
        }
    }

    fun getAllNotes(): LiveData<List<Note>>{
        Log.e("Repository", "Getting all notes")
        return noteDao.getAllNotes()
    }
}
