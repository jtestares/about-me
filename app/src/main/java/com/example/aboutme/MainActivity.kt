package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener{addNickname()}
        binding.nicknameText.setOnClickListener{updateNickname()}
    }

    private fun addNickname() {
        binding.apply {
            // set the textview to the user input
            myName?.nickname = binding.nicknameEdit.text.toString()
            invalidateAll()

            // hide the input field and done button
            nicknameEdit.visibility = View.GONE

            // hide the input field and done button
            doneButton.visibility = View.GONE

            // show textview for nickname
            nicknameText.visibility = View.VISIBLE

            // hide keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(doneButton.windowToken, 0)
        }
    }

    private fun updateNickname() {
        binding.apply {
            // show input field and button
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE

            // hide nickname textview
            nicknameText.visibility = View.GONE

            // set the focus to update text
            nicknameEdit.requestFocus()

            // show the keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(nicknameEdit, 0)
        }
    }
}
