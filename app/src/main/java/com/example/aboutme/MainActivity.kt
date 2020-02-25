package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener{addNickname(it)}
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{updateNickname(it)}
    }

    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)

        // set the textview to the user input
        nickNameTextView.text = editText.text

        // hide the input field and done button
        editText.visibility = View.GONE
        view.visibility = View.GONE

        // show textview for nickname
        nickNameTextView.visibility = View.VISIBLE


        // hide keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        // show input field and button
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE

        // hide nickname textview
        view.visibility = View.GONE

        // set the focus to update text
        editText.requestFocus()

        // show the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }

}
