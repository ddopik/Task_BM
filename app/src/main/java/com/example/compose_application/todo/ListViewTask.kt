package com.example.compose_application.todo


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun TaskScreen() {
    var isStarClicked by remember { mutableStateOf(false) } // Add this line to track the click state
    var isCompleteClicked by remember { mutableStateOf(false) } // Add this line to track the click state


    val tasks = defaultTasks // Replace this with your task data source
    val ongoingTasks = tasks.filter { !it.isComplete }
    val completedTasks = tasks.filter { it.isComplete }

    Column {
        // Ongoing Tasks
        Text(text = "Ongoing Tasks", fontSize =40.sp)
        TaskList(
            tasks = ongoingTasks,
            isStarClicked = isStarClicked,
            onStarClicked = {isStarClicked = !isStarClicked},
            isCompleteClicked = isCompleteClicked,
            onCompleteClicked = {isCompleteClicked = !isCompleteClicked})

        // Completed Tasks
        Text(text = "Completed Tasks",  fontSize =40.sp)
        TaskList(
            tasks = completedTasks,
            isStarClicked = isStarClicked,
            onStarClicked = {isStarClicked = !isStarClicked},
            isCompleteClicked = isCompleteClicked,
            onCompleteClicked = {isCompleteClicked = !isCompleteClicked})
    }
}




@Composable
fun TaskList(tasks: List<Task>,isStarClicked: Boolean, onStarClicked: (Boolean) -> Unit,isCompleteClicked: Boolean, onCompleteClicked: (Boolean) -> Unit) {
    LazyColumn {
        items(tasks) { task ->
            onStarClicked(task.isFavorite)
            onCompleteClicked(task.isComplete)
            TaskCard(task = task,isStarClicked,onStarClicked,isCompleteClicked,onCompleteClicked)
        }
    }
}
