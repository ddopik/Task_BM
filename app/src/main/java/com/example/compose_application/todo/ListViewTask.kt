package com.example.compose_application.todo


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun TaskScreen() {

    val tasks = defaultTasks // Replace this with your task data source
    val ongoingTasks = tasks.filter { !it.isComplete }
    val completedTasks = tasks.filter { it.isComplete }

    Column {
        // Ongoing Tasks
        Text(text = "Ongoing Tasks", fontSize =40.sp)
        TaskList(tasks = ongoingTasks)

        // Completed Tasks
        Text(text = "Completed Tasks",  fontSize =40.sp)
        TaskList(tasks = completedTasks)
    }
}

@Composable
fun TaskList(tasks: List<Task>) {
    LazyColumn {
        items(tasks) { task ->
            TaskCard(task = task)
        }
    }
}
