package com.shalan.mvvmonandroid.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.shalan.mvvmonandroid.model.Creature
import com.shalan.mvvmonandroid.model.CreatureAttributes
import com.shalan.mvvmonandroid.model.CreatureGenerator
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Created by Mohamed Shalan on 2019-12-07.
 */

class AddCreatureViewModelTest{
    private lateinit var addCreatureViewModel: AddCreatureViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var generator: CreatureGenerator

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        addCreatureViewModel = AddCreatureViewModel(generator)
    }

    @Test
    fun testUpdateCreature(){
        val attributes = CreatureAttributes(10, 3, 7)
        val stubCreature: Creature = Creature(name = "Test Creature", attributes = attributes, hitPoints = 87)
        `when`(generator.generateCreature(attributes, "Test Creature", 0)).thenReturn(stubCreature)
        addCreatureViewModel.intelligence = 10
        addCreatureViewModel.strength = 3
        addCreatureViewModel.endurance = 7

        addCreatureViewModel.generateCreature()
        assertEquals(stubCreature, addCreatureViewModel.creature)
    }
}