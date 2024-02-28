package com.musid.noteapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.musid.noteapp.R

class NoteAddActivity : AppCompatActivity() {

    lateinit var editTextTitle : EditText
    lateinit var editTextDescription : EditText
    lateinit var buttonCancel : Button
    lateinit var buttonSave : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_add)

        editTextTitle = findViewById(R.id.editTextTitle)
        editTextDescription = findViewById(R.id.editTextDescription)
        buttonCancel = findViewById(R.id.buttonCancel)
        buttonSave = findViewById(R.id.buttonSave)

        supportActionBar?.title="Add Note"
        buttonSave.setOnClickListener {
            saveNote()
        }

        buttonCancel.setOnClickListener {
            Toast.makeText(applicationContext,"Nothing saved",Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    private fun saveNote() {
        val noteTitle: String = editTextTitle.text.toString()
        val noteDescription: String = editTextDescription.text.toString()

        val intent = Intent()
        intent.putExtra("title",noteTitle)
        intent.putExtra("description",noteDescription)
        setResult(RESULT_OK,intent)
        finish()
    }
}