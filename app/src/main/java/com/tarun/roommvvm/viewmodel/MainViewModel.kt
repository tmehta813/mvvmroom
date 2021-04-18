package com.tarun.roommvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.tarun.roommvvm.db.UserEntity
import com.tarun.roommvvm.repository.MainRepository

class MainViewModel : ViewModel() {

    private val repository = MainRepository()

    fun observeUserData()  = repository.getAllUserList

    fun storeData(entity: UserEntity) {
        repository.storeData(entity)
    }

    fun delete() {
        repository.delete()
    }
}