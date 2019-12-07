package com.shalan.mvvmonandroid.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Mohamed Shalan on 2019-12-06.
 */

/*
* hit points = 5 * intelligence  + 3 * strength + 4 * endurance */
class CreatureGeneratorTest {
    private lateinit var creatureGenerator: CreatureGenerator

    @Before
    fun setup() {
        creatureGenerator = CreatureGenerator()
    }

    @Test
    fun testGenerateHitPoints() {
        val attributes = CreatureAttributes(intelligence = 7, strength = 10, endurance = 5)
        val name = "Creature 1"
        val expectedCreature =
            Creature(name = name, attributes = attributes, avatar = 0, hitPoints = 85)
        Assert.assertEquals(
            expectedCreature,
            creatureGenerator.generateCreature(name = name, attributes = attributes, avatar = 0)
        )
    }
}