package com.shalan.mvvmonandroid.view

import android.content.Context
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.shalan.mvvmonandroid.R
import kotlinx.android.synthetic.main.fragment_avatar_list_dialog.*
import kotlinx.android.synthetic.main.fragment_avatar_list_dialog_item.view.*


class AvatarListDialogFragment : BottomSheetDialogFragment() {
    private var mListener: Listener? = null
    private val avatarList: MutableList<Int> = mutableListOf()
    private val args: AvatarListDialogFragmentArgs by navArgs()
    init {
        avatarList.add(R.drawable.creature_app_whistle_1)
        avatarList.add(R.drawable.creature_bear_sleepy)
        avatarList.add(R.drawable.creature_bird_blue_fly_1)
        avatarList.add(R.drawable.creature_bug_insect_happy)
        avatarList.add(R.drawable.creature_bug_spider)
        avatarList.add(R.drawable.creature_cat_derp)
        avatarList.add(R.drawable.creature_cow_01)
        avatarList.add(R.drawable.creature_dino_01)
        avatarList.add(R.drawable.creature_dog_bone)
        avatarList.add(R.drawable.creature_duck_yellow_1)
        avatarList.add(R.drawable.creature_frog_hungry)
        avatarList.add(R.drawable.creature_head_fox)
        avatarList.add(R.drawable.creature_head_pig)
        avatarList.add(R.drawable.creature_head_tiger)
        avatarList.add(R.drawable.creature_monkey_happy)
        avatarList.add(R.drawable.creature_monster_purple)
        avatarList.add(R.drawable.creature_monster_slug)
        avatarList.add(R.drawable.creature_monster_yeti_1)
        avatarList.add(R.drawable.creature_owl_attack_1)
        avatarList.add(R.drawable.creature_panda_fun)
        avatarList.add(R.drawable.creature_penguin_plane)
        avatarList.add(R.drawable.creature_rat)
        avatarList.add(R.drawable.creature_skunk)
        avatarList.add(R.drawable.creature_square_bunny)
        avatarList.add(R.drawable.creature_wolf_crazy)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_avatar_list_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.layoutManager = GridLayoutManager(context, 3)
        list.adapter = AvatarAdapter(avatarList, args.creaturesCount)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as Listener
    }

    override fun onDetach() {
        mListener = null
        super.onDetach()
    }

    interface Listener {
        fun onAvatarClicked(avatarId: Int)
    }

    private inner class ViewHolder internal constructor(
        inflater: LayoutInflater,
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(
        inflater.inflate(
            R.layout.fragment_avatar_list_dialog_item,
            parent,
            false
        )
    ) {

        internal val creatureAvatar: ImageView = itemView.creature_avatar_iv

    }

    private inner class AvatarAdapter internal constructor(private val avatarResourceList: List<Int>, private val mItemCount: Int) :
        RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context), parent)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.creatureAvatar.setImageResource(avatarResourceList.get(position))
            holder.creatureAvatar.setOnClickListener {
                mListener?.onAvatarClicked(avatarResourceList.get(position))
                dismiss()
            }
        }

        override fun getItemCount(): Int {
            return mItemCount
        }
    }
}
