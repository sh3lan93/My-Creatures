package com.shalan.mvvmonandroid.model

import androidx.annotation.DrawableRes
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Mohamed Shalan on 2019-12-06.
 */

@Entity(tableName = "creature_table")
data class Creature(
    @PrimaryKey @NonNull val name: String = "",
    val attributes: CreatureAttributes = CreatureAttributes(),
    val hitPoints: Int = 0,
    @DrawableRes val avatar: Int = 0
)