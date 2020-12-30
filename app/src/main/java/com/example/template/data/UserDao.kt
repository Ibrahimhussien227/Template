package com.example.template.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: User)


    @Update
    suspend fun update(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
     fun getUsers():LiveData<List<User>>

    @Delete
    suspend fun deleteSubscriber(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()
}