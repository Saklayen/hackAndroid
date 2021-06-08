package com.saklayen.hackandroid.room

import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNotes(note: Note)

    @Update
    fun updateNote(note: Note)
    @Query("select * from notes")
    fun getAllNotes(): List<Note>
}