package ru.rxnnct.yesorno.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.rxnnct.yesorno.R

class SettingsFragment: Fragment(R.layout.fragment_settings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.resetTutorial).setOnClickListener{
            // TODO: reset
        }

    }
}