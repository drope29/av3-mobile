package com.example.minhaagenda.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.minhaagenda.R
import com.example.minhaagenda.model.Tarefa

class TaskListAdapter : ListAdapter<Tarefa, TaskListAdapter.TaskViewHolder>(TaskDiffCallback()) {

    private var onItemClickListener: ((Tarefa) -> Unit)? = null

    fun setOnItemClickListener(listener: (Tarefa) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val tarefa = getItem(position)
        holder.bind(tarefa)
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(tarefa)
        }
    }

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val descricaoTextView: TextView = itemView.findViewById(R.id.descricaoTextView)
        private val dataEntregaTextView: TextView = itemView.findViewById(R.id.dataEntregaTextView)

        fun bind(tarefa: Tarefa) {
            descricaoTextView.text = tarefa.descricao
            dataEntregaTextView.text = tarefa.dataEntrega
        }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<Tarefa>() {
        override fun areItemsTheSame(oldItem: Tarefa, newItem: Tarefa): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Tarefa, newItem: Tarefa): Boolean {
            return oldItem == newItem
        }
    }
}
