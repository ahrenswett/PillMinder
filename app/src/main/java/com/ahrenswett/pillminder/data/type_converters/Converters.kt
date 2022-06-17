package com.ahrenswett.pillminder.data.type_converters

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement
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

//    @TypeConverter
    fun listToJson(list: List<Any>) : String{
        return Json.encodeToString(list)
    }
    @TypeConverter
    fun JsonToList(string: String) : List<Any>{
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