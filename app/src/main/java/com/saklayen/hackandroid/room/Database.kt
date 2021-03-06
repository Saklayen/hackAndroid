package com.saklayen.hackandroid.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun getNoteDao(): NoteDao
}