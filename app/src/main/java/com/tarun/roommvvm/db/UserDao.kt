package com.tarun.roommvvm.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao // annotation defined for dao classes
interface UserDao {

    //insert single entity
    @Insert
    fun insert(entity: UserEntity)

    //fetching all user details
    @Query("select * from user")
    fun fetchAllData(): LiveData<List<UserEntity>>

    @Query("select * from user")
    fun getAllData(): List<UserEntity>

    //delete single data
    @Delete
    fun delete(entity: UserEntity)

    @Query("delete from user where id=:user_id")
    fun delete(user_id: Long)

}