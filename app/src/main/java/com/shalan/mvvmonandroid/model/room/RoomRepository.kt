package com.shalan.mvvmonandroid.model.room

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.shalan.mvvmonandroid.app.MVVMOnAndroid
import com.shalan.mvvmonandroid.model.Creature
import com.shalan.mvvmonandroid.model.CreatureRepository

/**
 * Created by Mohamed Shalan on 2019-12-06.
 */
class RoomRepository: CreatureRepository {
    val creatureDao = MVVMOnAndroid.database.creatureDAO()

    override fun saveCreature(creature: Creature) {
        InsertAsyncTask(creatureDao).execute(creature)
    }

    override fun getAllCreature(): LiveData<List<Creature>>  = creatureDao.getAllCreatures()

    override fun clearAllCreature() {
        DeleteAsyncTask(creatureDao).execute()
    }

    private class InsertAsyncTask internal constructor(val creatureDAO: CreatureDAO):
        AsyncTask<Creature, Void, Void>() {
        override fun doInBackground(vararg params: Creature?): Void? {
            params[0]?.let {
                creatureDAO.insert(creature = it)
            }
            return null
        }

    }

    private class DeleteAsyncTask internal constructor(val creatureDAO: CreatureDAO): AsyncTask<Void, Void, Void>(){
        override fun doInBackground(vararg params: Void?): Void? {
            creatureDAO.clearCreatures()
            return null
        }

    }
}