package com.tarun.roommvvm.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tarun.roommvvm.MyApplication

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    private object Holder {
        val INSTANCE = Room.databaseBuilder(
            MyApplication.getContext(),
            AppDatabase::class.java,
            "user.db"
        )
            .build()
    }

    companion object {
        val instance: AppDatabase by lazy { Holder.INSTANCE }
    }

    abstract fun userDao(): UserDao
}