package com.shalan.mvvmonandroid.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shalan.mvvmonandroid.BR
import com.shalan.mvvmonandroid.R
import com.shalan.mvvmonandroid.model.Creature
import kotlinx.android.synthetic.main.creature_item_view_layout.view.*

/**
 * Created by Mohamed Shalan on 2019-12-07.
 */
class CreatureAdapter() :
    ListAdapter<Creature, CreatureAdapter.CreatureViewHolder>(creatureDiffUtil) {

    companion object {
        val creatureDiffUtil = object : DiffUtil.ItemCallback<Creature>() {
            override fun areItemsTheSame(oldItem: Creature, newItem: Creature): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Creature, newItem: Creature): Boolean =
                oldItem == newItem

        }
    }


    class CreatureViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(creature: Creature) {
            binding.setVariable(BR.creature, creature)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatureViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.creature_item_view_layout,
            parent,
            false
        )
        return CreatureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreatureViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}