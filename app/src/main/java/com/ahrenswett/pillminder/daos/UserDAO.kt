package com.ahrenswett.pillminder.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahrenswett.pillminder.entities.User

@Dao
interface UserDAO {

    @Query("SELECT * FROM users ORDER BY username ASC")
    fun getAscendUserList(): List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Query("DELETE FROM users")
    suspend fun delete(user: User)


}