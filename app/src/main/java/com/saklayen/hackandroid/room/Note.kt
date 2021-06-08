package com.saklayen.hackandroid.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String?,
    var description: String?
){
    override fun toString(): String {
        return "id = $id title = $title des = $description"
    }
}