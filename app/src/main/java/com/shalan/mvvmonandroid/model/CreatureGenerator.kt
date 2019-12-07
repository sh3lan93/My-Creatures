package com.shalan.mvvmonandroid.model

import androidx.annotation.DrawableRes

/**
 * Created by Mohamed Shalan on 2019-12-06.
 */
class CreatureGenerator {

    fun generateCreature(
        attributes: CreatureAttributes,
        name: String, @DrawableRes avatar: Int
    ): Creature {
        val hitPoints =
            5 * attributes.intelligence + 3 * attributes.strength + 4 * attributes.endurance
        return Creature(name = name, avatar = avatar, attributes = attributes, hitPoints = hitPoints)
    }
}