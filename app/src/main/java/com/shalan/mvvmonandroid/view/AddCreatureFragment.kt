package com.shalan.mvvmonandroid.view

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.shalan.mvvmonandroid.R
import com.shalan.mvvmonandroid.common.CreatureAttributeType
import com.shalan.mvvmonandroid.viewmodel.AddCreatureViewModel
import kotlinx.android.synthetic.main.fragment_add_creature.*

class AddCreatureFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    private lateinit var addCreatureViewModel: AddCreatureViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_creature, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addCreatureViewModel = ViewModelProviders.of(this).get(AddCreatureViewModel::class.java)

        creature_avatar_iv.setOnClickListener {
            findNavController().navigate(R.id.action_addCreatureFragment_to_avatarListDialogFragment)
        }

        save_btn.setOnClickListener {
            if (addCreatureViewModel.saveCreature()) {
                findNavController().navigateUp()
            } else {
                Toast.makeText(context, getString(R.string.save_creature_failed), Toast.LENGTH_LONG)
                    .show()
            }
        }

        configureAttributesAdapter()

        configureObserverCreature()

        configureUpdateCreatureName()

        configureSelectionOnIntelligence()

        configureSelectionOnStrength()

        configureSelectionOnEndurance()
    }

    private fun configureSelectionOnEndurance() {
        endurance_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                addCreatureViewModel.updateAttributes(
                    CreatureAttributeType.ENDURANCE,
                    getAttributeValue(position)
                )
            }

        }
    }

    private fun configureSelectionOnStrength() {
        strength_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                addCreatureViewModel.updateAttributes(
                    CreatureAttributeType.STRENGTH,
                    getAttributeValue(position)
                )
            }

        }
    }

    private fun configureSelectionOnIntelligence() {
        intelligence_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                addCreatureViewModel.updateAttributes(
                    CreatureAttributeType.INTELLIGENCE,
                    getAttributeValue(position)
                )
            }

        }
    }

    private fun configureUpdateCreatureName() {
        creature_name_tiet.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                addCreatureViewModel.updateName(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }

    private fun configureObserverCreature() {
        addCreatureViewModel.getCreature().observe(this, Observer {
            hit_points_value_tv.text = it.hitPoints.toString()
        })
    }

    private fun configureAttributesAdapter() {
        context?.let {
            val intelligenceAdapter: ArrayAdapter<String> = ArrayAdapter(
                it,
                android.R.layout.simple_dropdown_item_1line,
                resources.getStringArray(R.array.intelligence_attributes)
            )
            intelligence_spinner.adapter = intelligenceAdapter

            val strengthAdapter: ArrayAdapter<String> = ArrayAdapter(
                it,
                android.R.layout.simple_dropdown_item_1line,
                resources.getStringArray(R.array.strength_attributes)
            )
            strength_spinner.adapter = strengthAdapter

            val enduranceAdapter: ArrayAdapter<String> = ArrayAdapter(
                it,
                android.R.layout.simple_dropdown_item_1line,
                resources.getStringArray(R.array.endurance_attributes)
            )
            endurance_spinner.adapter = enduranceAdapter
        }
    }

    fun getAttributeValue(position: Int): Int {
        when (position) {
            0 -> return 0
            1 -> return 3
            2 -> return 7
            3 -> return 10
        }
        return 0
    }

    fun updateAvatar(avatar: Int) {
        creature_avatar_iv.setImageResource(avatar)
        addCreatureViewModel.updateAvatar(avatar)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
    }
}
