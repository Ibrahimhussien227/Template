package com.example.template.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.template.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)


    @Update
    suspend fun update(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
     fun getUsers():LiveData<List<User>>

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()
}