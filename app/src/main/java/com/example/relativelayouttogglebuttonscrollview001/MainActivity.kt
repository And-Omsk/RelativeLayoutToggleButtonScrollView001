package com.example.relativelayouttogglebuttonscrollview001

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textViewBook: TextView
    private lateinit var textTV: TextView
    private lateinit var loadButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textViewBook= findViewById(R.id.textViewBook)
        loadButton= findViewById(R.id.loadButton)
        textTV=findViewById(R.id.textTV)

        val database = DataBase()
        val bookText = database.text

        loadButton.setOnClickListener {
            val wordsList = loadBook(bookText)
            //val bookTextResult = wordsList.joinToString(separator = " ")
            //val bookText=wordsList.joinToString(" ")
            textTV.text = wordsList.joinToString(" ")
        }

    }
}
fun loadBook(string: String):List<String> = string.split(" ")