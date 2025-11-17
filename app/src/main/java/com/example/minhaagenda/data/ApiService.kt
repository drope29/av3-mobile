package com.example.minhaagenda.data

import com.example.minhaagenda.model.Tarefa
import retrofit2.http.GET

interface ApiService {
    @GET("minhas_tarefas")
    suspend fun getTarefas(): List<Tarefa>
}
