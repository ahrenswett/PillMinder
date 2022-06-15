package com.ahrenswett.pillminder.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahrenswett.pillminder.data.daos.BottleDAO
import com.ahrenswett.pillminder.data.daos.CabinetDAO
import com.ahrenswett.pillminder.data.daos.ConsumableDAO
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.model.Consumable


@Database(entities = [
//    User::class,
    Cabinet::class,
    Bottle::class,
    Consumable::class,
//    Prescription::class
], version = 1)

//@TypeConverters(
//    Converters::class,
////    MeasurementTypeConverters::class,
////    FormTypeConverter::class,
////    ReminderTypeConverter::class,
//)
abstract class PillMinderDatabase : RoomDatabase() {
    abstract val cabinetDAO: CabinetDAO
    abstract val bottleDAO: BottleDAO
    abstract val consumableDAO: ConsumableDAO

//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//             synchronized(this) {
//                 return INSTANCE ?: Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_database"
//                ).build().also {
//                    INSTANCE = it
//                }
//            }
//        }
//    }
}