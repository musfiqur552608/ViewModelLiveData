package org.freedu.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var countTxt:TextView
    private lateinit var countBtn:Button
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTxt = findViewById(R.id.clickCount)
        countBtn = findViewById(R.id.countBtn)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        var count:LiveData<Int> = mainActivityViewModel.getInitialCounter()

        count.observe(this, Observer {
            countTxt.text = it.toString()
        })

        countBtn.setOnClickListener {
            mainActivityViewModel.getCounter()
        }

    }
}