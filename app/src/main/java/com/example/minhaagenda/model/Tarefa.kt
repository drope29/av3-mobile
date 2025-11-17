package com.example.minhaagenda.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tarefa(
    val id: Int,
    val descricao: String,
    val dataEntrega: String,
    val concluida: Boolean
) : Parcelable
