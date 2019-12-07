package com.shalan.mvvmonandroid.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
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


    class CreatureViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(creature: Creature) {
            itemView.creature_iv.setImageResource(creature.avatar)
            itemView.creature_name_tv.text = creature.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.creature_item_view_layout, parent, false)
        return CreatureViewHolder(view)
    }

    override fun onBindViewHolder(holder: CreatureViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}