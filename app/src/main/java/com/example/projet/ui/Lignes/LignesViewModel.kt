package com.example.projet.ui.Lignes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LignesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is lignes Fragment"
    }
    val text: LiveData<String> = _text
}