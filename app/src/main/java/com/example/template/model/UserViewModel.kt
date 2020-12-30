package com.example.template.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.template.data.UserDatabase
import com.example.template.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val getUsers: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        getUsers = repository.getUsers
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    fun update(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(user)
        }
    }
    fun delete(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(user)
        }
    }
    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}