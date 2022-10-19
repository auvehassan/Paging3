package com.auvehassan.paging3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    lateinit var adapter: QuotePagingAdapter
    @Inject
    lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = QuotePagingAdapter()
        recyclerView = findViewById<RecyclerView?>(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            adapter

        }

//        quoteViewModel = ViewModelProvider(this)[QuoteViewModel::class.java]
        quoteViewModel.quotes.observe(this) {
            adapter.submitData(lifecycle, it)
            adapter.addOnPagesUpdatedListener {
                Log.i(TAG, "onCreate: $it")
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}