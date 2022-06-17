package com.ahrenswett.pillminder.data.type_converters

import androidx.room.TypeConverter
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.model.Consumable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
//import com.ahrenswett.pillminder.entities.Form
//import com.ahrenswett.pillminder.entities.Measurement
import java.util.*


class Converters {
    @TypeConverter
    fun dateToLong(date: Date) : Long{
        return date.time
    }
    @TypeConverter
    fun longToDate(long: Long) : Date{
        return Date(long)
    }

// TODO: these list converters seem like they could be optimized to make it DRY
//    will need to see how room calls ty converters first. Then maybe a when?

    @TypeConverter
    fun bottleListToJson(bottleList: List<Bottle>) : String{
        return Json.encodeToString(bottleList)
    }
    @TypeConverter
    fun bottleJsonToList(string: String) : List<Bottle>{
        return Json.decodeFromString(string)
    }
    @TypeConverter
    fun cabinetListToJson(cabinetList: List<Cabinet>) : String{
        return Json.encodeToString(cabinetList)
    }
    @TypeConverter
    fun cabinetJsonToList(string: String) : List<Cabinet>{
        return Json.decodeFromString(string)
    }
    @TypeConverter
    fun consumableListToJson(consumableList: List<Consumable>) : String{
        return Json.encodeToString(consumableList)
    }
    @TypeConverter
    fun consumableJsonToList(string: String) : List<Consumable>{
        return Json.decodeFromString(string)
    }

}



//class MeasurementTypeConverters {
//    @TypeConverter
//    fun measurementToString(measurement: Measurement?) : String{
//        return measurement.toString()
//    }
//    @TypeConverter
//    fun  stringToMeasurement(string: String) : Measurement{
//        return Measurement.valueOf(string)
//    }
//}

//class FormTypeConverter{
//    @TypeConverter
//    fun formToString(form: Form) : String{
//        return form.toString()
//    }
//    @TypeConverter
//    fun  stringToForm(string: String) : Form{
//        return Form.valueOf(string)
//    }
//}

//class ReminderTypeConverter{
////    TODO: define the type converter
//}