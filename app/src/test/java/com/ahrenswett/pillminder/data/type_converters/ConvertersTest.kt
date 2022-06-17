package com.ahrenswett.pillminder.data.type_converters

import com.ahrenswett.pillminder.domain.model.Bottle
import org.junit.Assert.*

import org.junit.Test
import java.util.*


class ConvertersTest {
    val test = Converters()
    val testList = listOf(
        Bottle(
            1,
            "Depakote",
            100,
//                Date(2002,3,3),
//                Date(2022,5,4),
            "Ahren's"),
        Bottle(
            2,
            "Deote",
            10,
//                Date(2052,3,3),
//                Date(2022,5,8),
            "Ahren's"),
        Bottle(
            3,
            "Depate",
            1000,
//                Date(2042,3,3),
//                Date(2062,5,4),
            "Ahren's")
    )
    val testJson = test.bottleListToJson(testList)

    @Test
    fun listToJsonTest() {
        println(test.bottleListToJson(testList))
    }

    @Test
    fun jsonToList() {
        val deserialList = test.bottleJsonToList(testJson)
        for(bottle in deserialList){
            println("bottle id : ${bottle.bottleID} \n" +
                    "contents : ${bottle.consumableID} \n" +
                    "quantity : ${bottle.quantityInBottle} \n" +
                    "cabinet : ${bottle.cabinetID}")
        }
        assertEquals(deserialList, testList)
    }
}