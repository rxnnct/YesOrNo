package ru.rxnnct.yesorno.screens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.rxnnct.yesorno.R
import ru.rxnnct.yesorno.model.SolutionResult
import ru.rxnnct.yesorno.screens.HistoryListAdapter.SolutionResultViewHolder

class HistoryListAdapter : ListAdapter<SolutionResult, SolutionResultViewHolder>(SolutionResultsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolutionResultViewHolder {
        return SolutionResultViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SolutionResultViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.solutionType + " | " + current.question + " | " + current.result)
    }

    class SolutionResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val solutionResultItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            solutionResultItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): SolutionResultViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.history_recyclerview_item, parent, false)
                return SolutionResultViewHolder(view)
            }
        }
    }

    class SolutionResultsComparator : DiffUtil.ItemCallback<SolutionResult>() {
        override fun areItemsTheSame(oldItem: SolutionResult, newItem: SolutionResult): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: SolutionResult, newItem: SolutionResult): Boolean {
            return oldItem.id == newItem.id
        }
    }
}