package com.shalan.mvvmonandroid.model

import androidx.lifecycle.LiveData

/**
 * Created by Mohamed Shalan on 2019-12-06.
 */
interface CreatureRepository {
    fun saveCreature(creature: Creature)
    fun getAllCreature(): LiveData<List<Creature>>
    fun clearAllCreature()
}