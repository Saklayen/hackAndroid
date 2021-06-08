package com.saklayen.hackandroid.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNotes(note: Note)

    @Update
    fun updateNote(note: Note)

    @Query("select * from notes")
    fun getAllNotes(): LiveData<List<Note>>
}