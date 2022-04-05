package com.example.to_do

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do.Adapter.ToDoAdapter
import com.example.to_do.Model.ToDoModel
import android.os.Bundle
import com.example.to_do.R
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
//    private var tasksRecyclerView: RecyclerView? = null
//    private var tasksAdapter: ToDoAdapter? = null
    private var taskList: MutableList<ToDoModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        var tasksAdapter = ToDoAdapter(this)
        var tasksRecyclerView = RecyclerView(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        taskList = ArrayList()
        tasksRecyclerView = findViewById(R.id.tasksRecyclerView)
        tasksRecyclerView.layoutManager = LinearLayoutManager(this)

        tasksRecyclerView.setAdapter(tasksAdapter)
        val task = ToDoModel()
        task.task = "This is a Test Task"
        task.status = 0
        task.id = 1
        (taskList as ArrayList<ToDoModel>).add(task)
        (taskList as ArrayList<ToDoModel>).add(task)
        (taskList as ArrayList<ToDoModel>).add(task)
        (taskList as ArrayList<ToDoModel>).add(task)
        (taskList as ArrayList<ToDoModel>).add(task)
        tasksAdapter!!.setTasks(taskList)
    }
}

