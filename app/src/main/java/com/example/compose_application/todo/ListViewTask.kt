package com.example.compose_application.todo


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true)
//@Composable
//fun TaskScreen() {
//
//    val tasks = defaultTasks // Replace this with your task data source
//    val ongoingTasks = tasks.filter { !it.isComplete }
//    val completedTasks = tasks.filter { it.isComplete }
//
//    Column {
//        // Ongoing Tasks
//        Text(text = "Ongoing Tasks", fontSize =40.sp)
//        TaskList(tasks = ongoingTasks)
//
//        // Completed Tasks
//        Text(text = "Completed Tasks",  fontSize =40.sp)
//        TaskList(tasks = completedTasks)
//    }
//}

@Preview(showBackground = true)
@Composable
fun TaskList() {
    val tasks = defaultTasks // Replace this with your task data source
    val ongoingTasks = tasks.filter { !it.isComplete }
    val completedTasks = tasks.filter { it.isComplete }


    LazyColumn {
        item {
            if (ongoingTasks.isNotEmpty()){
                Text(text = "Ongoing Tasks", fontSize =40.sp)
                for (task in ongoingTasks){
                    TaskCard(task = task)
                }
            }

        }
        item {
            if (completedTasks.isNotEmpty()){
                Text(text = "Completed Tasks",  fontSize =40.sp)
                for (task in completedTasks){
                    TaskCard(task = task)
                }
            }
        }

    }


}
