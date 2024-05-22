package com.musid.noteapp.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.musid.noteapp.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest{

    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testAddNewNote(){
        onView(withId(R.id.item_add_note)).perform(click())

        val noteActivityScenario = ActivityScenario.launch(NoteAddActivity::class.java)
        noteActivityScenario.use {
            onView(withId(R.id.editTextTitle)).perform(typeText("Title 4"))
            onView(withId(R.id.editTextDescription)).perform(typeText("Description 4"))
            onView(withId(R.id.buttonSave)).perform(click())
        }
    }

    @Test
    fun testUpdateNote(){

        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.editTextTitleUpdate)).perform(clearText(), typeText("title 1"), closeSoftKeyboard())
        onView(withId(R.id.editTextDescriptionUpdate)).perform(clearText(),typeText("desc 1"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.buttonSaveUpdate)).perform(click())

    }
}