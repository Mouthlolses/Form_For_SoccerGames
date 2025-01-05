package com.example.futportuguese.database.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converter {

    //Converter do valor em BigDecimal para Double pois o SQLite não reconhece valores em "BigDecimal"
    @TypeConverter
    fun deDouble(valor: Double?): BigDecimal {
        return valor?.let { BigDecimal(valor.toString()) } ?: BigDecimal.ZERO
    }

    @TypeConverter
    fun bigDecimalParaDouble(valor: BigDecimal?) : Double? {
        return valor?.let { valor.toDouble() }
    }
}