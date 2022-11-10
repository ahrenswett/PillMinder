package com.ahrenswett.pillminder.data.type_converters

import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Prescription
import org.junit.Assert.*
import org.junit.Test
import java.util.*


class ConvertersTest {
    val testList = listOf(
//        Bottle(
//            1,
//            "Depakote",
//            100,
//            Calendar.getInstance().set(2002,3,3),
//            Date(d).time,
//            "Ahren's"),
        Bottle(
            "depakote",
            100,
            Prescription(1,2000,2,"Dr. Christopher Ransom",null),
            "3-3-2052",
            "5-8-2022",
            "Llama2"),
//        Bottle(
//            3,
//            "Depate",
//            1000,
//            Date(2052,3,3).time,
//            Date(2022,5,8).time,
//            "Ahren's")
    )
    val testJson = Converters.bottleListToJson(testList)

    @Test
    fun listToJsonTest() {
        // TODO: find out how to test json serialization better
        println(Converters.bottleListToJson(testList))

    }

    @Test
    fun jsonToList() {
        val deserialList = Converters.bottleJsonToList(testJson)
        for(bottle in deserialList){
            println("bottle id : ${bottle.bottleID} \n" +
                    "contents : ${bottle.consumableID} \n" +
                    "quantity : ${bottle.quantityInBottle} \n" +
                    "start date : ${bottle.startDate} \n" +
                    "cabinet : ${bottle.cabinetID}")
        }
        assertEquals(deserialList, testList)
    }
}