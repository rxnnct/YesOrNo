package ru.rxnnct.yesorno.screens

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import ru.rxnnct.yesorno.MainActivity
import ru.rxnnct.yesorno.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.postDelayed({

            val action: Int = if (MainActivity.isTutorialEnded == "true") {
                R.id.action_splashFragment_to_mainFragment
            } else {
                R.id.action_splashFragment_to_tutorialFragment
            }

            findNavController().navigate(
                action,
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
        }, 1000)
    }
}