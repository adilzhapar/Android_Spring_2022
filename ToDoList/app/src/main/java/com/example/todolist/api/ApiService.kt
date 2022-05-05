package com.example.lab51.api

import com.example.todolist.DTO.ToDo
import com.example.todolist.DTO.ToDoItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users/")
    fun getUsers(): Call<List<ToDo>>

    @GET("todos/")
    fun getTodosByUserId(@Query("userId") userId: Int): Call<List<ToDoItem>>
}