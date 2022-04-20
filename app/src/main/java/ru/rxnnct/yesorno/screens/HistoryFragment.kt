package ru.rxnnct.yesorno.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.rxnnct.yesorno.R
import ru.rxnnct.yesorno.YesOrNoApplication

class HistoryFragment: Fragment(R.layout.fragment_history) {

    private val solutionResultViewModel: SolutionResultViewModel by viewModels {
        SolutionResultViewModelFactory((activity?.application as YesOrNoApplication).solutionResultRepository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.historyRecyclerview)
        val adapter = HistoryListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        solutionResultViewModel.allSolutionResults.observe(viewLifecycleOwner) { solutionResults ->
            solutionResults?.let { adapter.submitList(it) }
        }
    }
}