package com.example.compose_application.todo

data class Task(var title: String, var description: String, var isComplete: Boolean = false, var isFavorite: Boolean = false)
