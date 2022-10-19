package com.auvehassan.paging3

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.auvehassan.paging3.model.Result
import javax.inject.Inject


class QuotePagingAdapter() : PagingDataAdapter<Result, QuotePagingAdapter.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_quote, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote = getItem(position)
        Log.i(TAG, "onBindViewHolder: $position")
        quote?.let { holder.quoteView.text = quote.content }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quoteView = itemView.findViewById<TextView>(R.id.quote)
    }

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
                oldItem._id == newItem._id

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
                oldItem == newItem

        }
        private const val TAG = "QuotePagingAdapter"
    }
}
