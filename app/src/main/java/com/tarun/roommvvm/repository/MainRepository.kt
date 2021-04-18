package com.tarun.roommvvm.repository

import com.tarun.roommvvm.db.AppDatabase
import com.tarun.roommvvm.db.UserEntity


class MainRepository {

    val getAllUserList = AppDatabase.instance.userDao().fetchAllData()

    fun storeData(entity: UserEntity) {
        Thread {
            AppDatabase.instance.userDao().insert(entity)
        }.start()
    }

    fun delete() {
        Thread {
            AppDatabase.instance.userDao().delete(1)
        }.start()
    }

}