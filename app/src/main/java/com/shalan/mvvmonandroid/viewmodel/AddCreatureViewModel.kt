package com.shalan.mvvmonandroid.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shalan.mvvmonandroid.common.CreatureAttributeType
import com.shalan.mvvmonandroid.model.Creature
import com.shalan.mvvmonandroid.model.CreatureAttributes
import com.shalan.mvvmonandroid.model.CreatureGenerator
import com.shalan.mvvmonandroid.model.CreatureRepository
import com.shalan.mvvmonandroid.model.room.RoomRepository

/**
 * Created by Mohamed Shalan on 2019-12-07.
 */
class AddCreatureViewModel(
    private val creatureGenerator: CreatureGenerator = CreatureGenerator(),
    private val repository: CreatureRepository = RoomRepository()
) : ViewModel() {


    private val creatureLiveData = MutableLiveData<Creature>()

    private val saveCreatureLiveData = MutableLiveData<Boolean>()


    var name: String = ""

    var intelligence: Int = 0

    var strength: Int = 0

    var endurance: Int = 0

    var creatureAvatar = 0

    var creature = Creature()

    init {
        creatureLiveData.postValue(Creature())
    }

    fun getSaveCreatureLiveData(): LiveData<Boolean> = saveCreatureLiveData

    fun getCreature(): LiveData<Creature> = creatureLiveData

    fun generateCreature() {
        val creatureAttributes = CreatureAttributes(intelligence, strength, endurance)
        creature = creatureGenerator.generateCreature(creatureAttributes, name, creatureAvatar)
        creatureLiveData.postValue(creature)
    }

    fun updateAttributes(attributeType: CreatureAttributeType, value: Int) {
        when (attributeType) {
            CreatureAttributeType.INTELLIGENCE -> intelligence = value
            CreatureAttributeType.STRENGTH -> strength = value
            CreatureAttributeType.ENDURANCE -> endurance = value
        }
        generateCreature()
    }

    fun updateAvatar(avatar: Int) {
        creatureAvatar = avatar
        generateCreature()
    }

    fun updateName(creatureName: String) {
        name = creatureName
        generateCreature()
    }

    fun saveCreature() {
        if (canSaveCreature()) {
            repository.saveCreature(creature)
            saveCreatureLiveData.postValue(true)
        } else {
            saveCreatureLiveData.postValue(false)
        }
    }

    fun canSaveCreature(): Boolean =
        intelligence != 0 && strength != 0 && endurance != 0 && name.isNotEmpty() && name.isNotBlank() && creatureAvatar != 0


}