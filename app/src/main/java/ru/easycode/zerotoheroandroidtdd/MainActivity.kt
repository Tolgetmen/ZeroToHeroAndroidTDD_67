package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isInvisible

//import androidx.core.view.isGone

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.hideButton)
        textView = findViewById(R.id.titleTextView)


        if (savedInstanceState != null) {
            val saveVisible = savedInstanceState.getInt(KEY, textView.visibility)
            textView.visibility = saveVisible
        }


        button.setOnClickListener {
            if (textView.isInvisible) {
                textView.visibility = View.VISIBLE
            } else {
                textView.visibility = View.INVISIBLE
            }

        }

        savedInstanceState?.let {
            textView.visibility = it.getInt(KEY, View.VISIBLE)
        }
    }

    companion object {
        private const val KEY = "visibilityKey"
    }


//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        val saveVisible = savedInstanceState.getInt("key", textView.visibility)
//        textView.visibility = saveVisible
//    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, textView.visibility)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}