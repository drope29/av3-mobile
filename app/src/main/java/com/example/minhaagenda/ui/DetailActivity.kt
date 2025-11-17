package com.example.minhaagenda.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.minhaagenda.R
import com.example.minhaagenda.model.Tarefa

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tarefa = intent.getParcelableExtra<Tarefa>("tarefa")

        val descricaoTextView = findViewById<TextView>(R.id.descricaoDetailTextView)
        val dataEntregaTextView = findViewById<TextView>(R.id.dataEntregaDetailTextView)
        val statusTextView = findViewById<TextView>(R.id.statusDetailTextView)

        tarefa?.let {
            descricaoTextView.text = it.descricao
            dataEntregaTextView.text = "Data de Entrega: ${it.dataEntrega}"
            statusTextView.text = if (it.concluida) "Status: Concluída" else "Status: Pendente"
        }
    }
}
