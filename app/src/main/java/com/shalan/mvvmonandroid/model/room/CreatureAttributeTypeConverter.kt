package com.shalan.mvvmonandroid.model.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.shalan.mvvmonandroid.model.CreatureAttributes

/**
 * Created by Mohamed Shalan on 2019-12-06.
 */
class CreatureAttributeTypeConverter {

    @TypeConverter
    fun fromCreatureAttribute(creatureAttributes: CreatureAttributes): String? {
        val gson = Gson()
        return gson.toJson(creatureAttributes)
    }

    @TypeConverter
    fun toCreatureAttribute(json: String?): CreatureAttributes?{
        json?.let {
            val gson = Gson()
            return gson.fromJson(json, CreatureAttributes::class.java)
        }
        return null
    }
}