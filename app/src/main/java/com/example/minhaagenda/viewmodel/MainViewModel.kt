package com.example.minhaagenda.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minhaagenda.data.RetrofitInstance
import com.example.minhaagenda.model.Tarefa
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _tarefas = MutableLiveData<List<Tarefa>>()
    val tarefas: LiveData<List<Tarefa>> = _tarefas

    private val _erro = MutableLiveData<String>()
    val erro: LiveData<String> = _erro

    fun getTarefas() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTarefas()
                _tarefas.value = response
            } catch (e: Exception) {
                _erro.value = "Erro ao buscar tarefas: ${e.message}"
            }
        }
    }
}
