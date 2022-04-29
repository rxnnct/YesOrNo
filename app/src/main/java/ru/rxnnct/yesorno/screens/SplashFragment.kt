package ru.rxnnct.yesorno.screens

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import ru.rxnnct.yesorno.MainActivity
import ru.rxnnct.yesorno.R
import ru.rxnnct.yesorno.YesOrNoApplication
import ru.rxnnct.yesorno.model.Settings

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val settingsViewModel: SettingsViewModel by viewModels {
        SettingsViewModelFactory((activity?.application as YesOrNoApplication).settingsRepository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.postDelayed({
            val appSettings = settingsViewModel.settings

            val action: Int = if (appSettings.value?.tutorialCompleted == true) {
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