package com.example.template.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    var firstName: String,

    @ColumnInfo
    var email: String,

    @ColumnInfo
    val age: Int
)