package com.ahrenswett.pillminder.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ahrenswett.pillminder.data.daos.BottleDAO
import com.ahrenswett.pillminder.data.daos.CabinetDAO
import com.ahrenswett.pillminder.data.daos.ConsumableDAO
import com.ahrenswett.pillminder.data.type_converters.Converters
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.model.Consumable
import com.ahrenswett.pillminder.domain.model.Prescription


@Database(entities = [
    Cabinet::class,
    Bottle::class,
    Consumable::class,
    Prescription::class
], version = 1
)


@TypeConverters(Converters::class)

abstract class PillMinderDatabase : RoomDatabase() {
    abstract val cabinetDAO: CabinetDAO
    abstract val bottleDAO: BottleDAO
    abstract val consumableDAO: ConsumableDAO
}