package ru.rxnnct.yesorno.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.rxnnct.yesorno.R

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.mainBottomNavigationView)
        val navigationController = (childFragmentManager.findFragmentById(R.id.mainFragmentContainerView) as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottomNavigationView, navigationController)

        navigationController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.yesNoSolutionFragment) {
                bottomNavigationView.visibility = View.GONE
            } else {
                bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }
}