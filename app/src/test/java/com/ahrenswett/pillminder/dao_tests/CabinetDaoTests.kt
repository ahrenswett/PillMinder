package com.ahrenswett.pillminder.dao_tests

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ahrenswett.pillminder.data.PillMinderDatabase
import com.ahrenswett.pillminder.data.daos.BottleDAO
import com.ahrenswett.pillminder.data.daos.CabinetDAO
import com.ahrenswett.pillminder.data.daos.ConsumableDAO
import com.ahrenswett.pillminder.domain.model.Cabinet
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class SimpleEntityReadWriteTest {
    private lateinit var consumableDAO: ConsumableDAO
    private lateinit var cabinetDao : CabinetDAO
    private lateinit var bottleDAO: BottleDAO
    private lateinit var db: PillMinderDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, PillMinderDatabase::class.java).build()
        cabinetDao = db.cabinetDAO
        consumableDAO = db.consumableDAO
        bottleDAO = db.bottleDAO
    }

    @After
    @Throws(IOException::class)
    fun closeDb(){
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun addNewCabinetTest() : Unit = runBlocking {
        val testName = "Broken Cabinet"
        cabinetDao.addNewCabinet(Cabinet(testName))
        val allCabinets = cabinetDao.getCabinets().first()
        assertEquals(allCabinets[0].name, testName)
    }

}

