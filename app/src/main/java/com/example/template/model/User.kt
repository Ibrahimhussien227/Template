package com.example.template.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
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
): Parcelable