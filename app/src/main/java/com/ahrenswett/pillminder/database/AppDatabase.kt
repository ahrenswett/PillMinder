package com.ahrenswett.pillminder.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahrenswett.pillminder.daos.BottleDAO
import com.ahrenswett.pillminder.daos.CabinetDAO
import com.ahrenswett.pillminder.daos.ConsumableDAO
import com.ahrenswett.pillminder.daos.UserDAO
import com.ahrenswett.pillminder.entities.*


@Database(entities = [
    User::class,
    Cabinet::class,
    Bottle::class,
    Consumable::class,
    Prescription::class
], version = 1)

//@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO
    abstract fun bottleDAO(): BottleDAO
    abstract fun cabinetDAO(): CabinetDAO
    abstract fun consumableDAO(): ConsumableDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}