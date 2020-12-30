package com.example.template.data

import androidx.lifecycle.LiveData
import com.example.template.model.User

class UserRepository(private val userDao: UserDao) {

    val getUsers: LiveData<List<User>> = userDao.getUsers()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
    suspend fun update(user: User){
        userDao.update(user)
    }
    suspend fun delete(user: User){
        userDao.deleteUser(user)
    }
    suspend fun deleteAll(){
        userDao.deleteAll()
    }
}