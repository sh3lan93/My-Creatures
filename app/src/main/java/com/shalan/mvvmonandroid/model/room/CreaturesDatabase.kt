package com.shalan.mvvmonandroid.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.shalan.mvvmonandroid.model.Creature

/**
 * Created by Mohamed Shalan on 2019-12-06.
 */

@Database(entities = [Creature::class], version = 1)
@TypeConverters(CreatureAttributeTypeConverter::class)
abstract class CreaturesDatabase: RoomDatabase() {

    abstract fun creatureDAO(): CreatureDAO
}