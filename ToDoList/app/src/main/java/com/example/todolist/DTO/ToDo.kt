package com.example.todolist.DTO

import com.example.todolist.DTO.ToDoItem

class ToDo {

    var id: Long = -1
    var name = ""
    var createdAt = ""
    var items: MutableList<ToDoItem> = ArrayList()

}