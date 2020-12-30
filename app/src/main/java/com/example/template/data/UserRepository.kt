package com.example.template.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val getUsers: LiveData<List<User>> = userDao.getUsers()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
    suspend fun update(user: User){
        userDao.update(user)
    }
    suspend fun delete(user: User){
        userDao.deleteSubscriber(user)
    }
    suspend fun deleteAll(){
        userDao.deleteAll()
    }
}