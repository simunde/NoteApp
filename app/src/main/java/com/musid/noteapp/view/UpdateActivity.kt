package com.musid.noteapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.musid.noteapp.R

class UpdateActivity : AppCompatActivity() {

    lateinit var editTextTitle: EditText
    lateinit var editTextDescription : EditText
    lateinit var buttonCancel : Button
    lateinit var buttonSave : Button
    var currentId=-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        editTextTitle = findViewById(R.id.editTextTitleUpdate)
        editTextDescription = findViewById(R.id.editTextDescriptionUpdate)
        buttonCancel = findViewById(R.id.buttonCancelUpdate)
        buttonSave = findViewById(R.id.buttonSaveUpdate)
        getAndSetData()

        supportActionBar?.title="Update Note"

        buttonSave.setOnClickListener {
            updateNote()
        }

        buttonCancel.setOnClickListener {
            Toast.makeText(applicationContext,"Nothing updated", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    private fun updateNote() {
        val updatedTitle= editTextTitle.text.toString()
        val updatedDescription= editTextDescription.text.toString()

        val intent = Intent()
        intent.putExtra("updatedTitle",updatedTitle)
        intent.putExtra("updatedDescription",updatedDescription)


        if (currentId!=-1){
            intent.putExtra("noteId",currentId)
            setResult(RESULT_OK,intent)
            finish()
        }

    }

    private fun getAndSetData(){

        //get
        val currentTitle=intent.getStringExtra("currentTitle")
        val currentDescription = intent.getStringExtra("currentDescription")
        currentId = intent.getIntExtra("currentId",-1)

        //set
        editTextTitle.setText(currentTitle)
        editTextDescription.setText(currentDescription)
    }
}