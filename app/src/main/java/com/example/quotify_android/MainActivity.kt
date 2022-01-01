package com.example.quotify_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]
        setQuote(mainViewModel.getQuote())
        btnPrevious.setOnClickListener(this)
        btnNext.setOnClickListener(this)
    }

    private fun setQuote(quote: Quote) {
        tvText.text = quote.text
        tvAuthor.text = quote.author
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnPrevious -> setQuote(mainViewModel.previousQuote())
            R.id.btnNext -> setQuote(mainViewModel.nextQuote())
        }
    }
}