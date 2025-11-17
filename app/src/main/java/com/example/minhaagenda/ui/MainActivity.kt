package com.example.minhaagenda.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minhaagenda.R
import com.example.minhaagenda.adapter.TaskListAdapter
import com.example.minhaagenda.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: TaskListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setupRecyclerView()

        viewModel.tarefas.observe(this, Observer { tarefas ->
            adapter.submitList(tarefas)
        })

        viewModel.getTarefas()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
        adapter = TaskListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.setOnItemClickListener { tarefa ->
            val intent = android.content.Intent(this, DetailActivity::class.java)
            intent.putExtra("tarefa", tarefa)
            startActivity(intent)
        }
    }
}
