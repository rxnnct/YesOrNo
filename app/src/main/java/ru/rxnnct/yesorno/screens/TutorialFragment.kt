package ru.rxnnct.yesorno.screens

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import ru.rxnnct.yesorno.R

class TutorialFragment : Fragment(R.layout.fragment_tutorial) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.agreeButton).setOnClickListener {
            findNavController().navigate(
                R.id.action_tutorialFragment_to_mainFragment,
                bundleOf(),
                navOptions {
                    anim {
                        enter = androidx.navigation.ui.R.anim.nav_default_enter_anim
                        popEnter = androidx.navigation.ui.R.anim.nav_default_pop_enter_anim
                        popExit = androidx.navigation.ui.R.anim.nav_default_pop_exit_anim
                        exit = androidx.navigation.ui.R.anim.nav_default_exit_anim
                    }
                    launchSingleTop = true
                    popUpTo(R.id.navigation_graph_application) {
                        inclusive = true
                    }
                })
        }
    }
}