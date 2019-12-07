package com.shalan.mvvmonandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shalan.mvvmonandroid.model.Creature
import com.shalan.mvvmonandroid.model.CreatureRepository
import com.shalan.mvvmonandroid.model.room.RoomRepository

/**
 * Created by Mohamed Shalan on 2019-12-07.
 */
class CreatureListViewModel(private val repository: CreatureRepository = RoomRepository()): ViewModel() {

    fun getCreaturesList(): LiveData<List<Creature>> = repository.getAllCreature()
}