package com.shalan.mvvmonandroid.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration

import com.shalan.mvvmonandroid.R
import com.shalan.mvvmonandroid.view.adapters.CreatureAdapter
import com.shalan.mvvmonandroid.viewmodel.CreatureListViewModel
import kotlinx.android.synthetic.main.fragment_creatures_list.*

class CreaturesListFragment : Fragment() {

    private lateinit var creatureListViewModel: CreatureListViewModel

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_creatures_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        creatureListViewModel = ViewModelProviders.of(this).get(CreatureListViewModel::class.java)

        add_creature_btn.setOnClickListener {
            listener?.onAddCreatureClicked()
        }
        creature_rv.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        creature_rv.adapter = CreatureAdapter()
        creatureListViewModel.getCreaturesList().observe(this, Observer {
            (creature_rv.adapter as CreatureAdapter).submitList(it)
        })
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
        fun onAddCreatureClicked()
    }
}
