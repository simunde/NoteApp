package com.musid.noteapp

import android.app.Application
import androidx.room.Database
import com.musid.noteapp.repository.NoteRepository
import com.musid.noteapp.room.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NoteApplication: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {
        NoteDatabase.getDatabase(this, applicationScope)
    }

    val repository by lazy { NoteRepository(database.getNoteDao())
    }
}