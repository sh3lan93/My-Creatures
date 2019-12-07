package com.shalan.mvvmonandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.shalan.mvvmonandroid.view.AddCreatureFragment
import com.shalan.mvvmonandroid.view.AvatarListDialogFragment
import com.shalan.mvvmonandroid.view.CreaturesListFragment
import kotlinx.android.synthetic.main.app_def_toolbar.*

class MainActivity : AppCompatActivity(), CreaturesListFragment.OnFragmentInteractionListener,
    AddCreatureFragment.OnFragmentInteractionListener, AvatarListDialogFragment.Listener{

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navGraph = navController.graph)
        app_main_toolbar.setupWithNavController(navController, appBarConfiguration)

    }

    override fun onAddCreatureClicked() {
        navController.navigate(R.id.action_creaturesListFragment_to_addCreatureFragment)
    }

    override fun onAvatarClicked(avatarId: Int) {
        val hostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val visibleFragment = hostFragment.childFragmentManager.fragments.get(0) as AddCreatureFragment
        visibleFragment.updateAvatar(avatarId)
    }
}
