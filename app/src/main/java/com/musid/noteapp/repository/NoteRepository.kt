package com.musid.noteapp.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.musid.noteapp.model.Note
import com.musid.noteapp.room.NoteDAO
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDAO) {

    val myAllNotes :  Flow<List<Note>> = noteDao.getAllNotes()
    //val myAllNotes :  LiveData<List<Note>> = noteDao.getAllNotes()


    @WorkerThread
    suspend fun insert(note:Note){
        noteDao.insert(note)
    }



    @WorkerThread
    suspend fun update(note:Note){
        noteDao.update(note)
    }


    @WorkerThread
    suspend fun delete(note:Note){
        noteDao.delete(note)
    }

    @WorkerThread
    suspend fun deleteAllNotes(){
        noteDao.deleteAllNotes()
    }
}