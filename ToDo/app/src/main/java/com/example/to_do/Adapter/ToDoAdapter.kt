package com.example.to_do.Adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.to_do.Model.ToDoModel
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.to_do.R
import android.widget.CheckBox
import com.example.to_do.MainActivity

class ToDoAdapter(private val activity: MainActivity) : RecyclerView {
    private var todoList: List<ToDoModel>? = null
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_layout, parent, false)
        return ViewHolder(itemView)
    }

    fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = todoList!![position]
        holder.task.text = item.task
        holder.task.isChecked = toBoolean(item.status)
    }

    fun getItemCount(): Int {
        return todoList!!.size
    }

    private fun toBoolean(n: Int): Boolean {
        return n != 0
    }

    fun setTasks(todolist: List<ToDoModel>?) {
        todoList = todolist
    }

    class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        var task: CheckBox

        init {
            task = view.findViewById(R.id.todoCheckBox)
        }
    }
}