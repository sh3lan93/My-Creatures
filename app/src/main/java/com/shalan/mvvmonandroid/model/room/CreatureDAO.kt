package com.shalan.mvvmonandroid.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shalan.mvvmonandroid.model.Creature

/**
 * Created by Mohamed Shalan on 2019-12-06.
 */

@Dao
interface CreatureDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(creature: Creature)

    @Query("delete from creature_table")
    fun clearCreatures()

    @Query("select * from creature_table ORDER BY name ASC")
    fun getAllCreatures(): LiveData<List<Creature>>
}