package com.ahrenswett.pillminder.type_converters

import androidx.room.TypeConverter
import com.ahrenswett.pillminder.entities.Form
import com.ahrenswett.pillminder.entities.Measurement
import java.util.*


class DateTypeConverters {
    @TypeConverter
    fun dateToLong(date: Date) : Long{
        return date.time
    }
    @TypeConverter
    fun longToDate(long: Long) : Date{
        return Date(long)
    }
}

class MeasurementTypeConverters {
    @TypeConverter
    fun measurementToString(measurement: Measurement?) : String{
        return measurement.toString()
    }
    @TypeConverter
    fun  stringToMeasurement(string: String) : Measurement{
        return Measurement.valueOf(string)
    }
}

class FormTypeConverter{
    @TypeConverter
    fun formToString(form: Form) : String{
        return form.toString()
    }
    @TypeConverter
    fun  stringToForm(string: String) : Form{
        return Form.valueOf(string)
    }
}

class ReminderTypeConverter{
//    TODO: define the type converter
}