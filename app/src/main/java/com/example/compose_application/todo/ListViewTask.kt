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
import androidx.compose.runtime.mutableStateListOf
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

    val ongoingTasks = remember { mutableStateOf( defaultTasks.filter { !it.isComplete }) }
    val completedTasks = remember { mutableStateOf(defaultTasks.filter { it.isComplete }) }


    LazyColumn {
        item {
            if (ongoingTasks.value.isNotEmpty()){
                Text(text = "Ongoing Tasks", fontSize =40.sp)
                for (task in ongoingTasks.value){
                    TaskCard(task = task){
                        ongoingTasks.value =  defaultTasks.filter { !it.isComplete}
                        completedTasks.value = defaultTasks.filter { it.isComplete}
                    }
                }
            }

        }
        item {
            if (completedTasks.value.isNotEmpty()){
                Text(text = "Completed Tasks",  fontSize =40.sp)
                for (task in completedTasks.value){
                    TaskCard(task = task){
                        ongoingTasks.value =  defaultTasks.filter { !it.isComplete}
                        completedTasks.value = defaultTasks.filter { it.isComplete}

                    }
                }
            }
        }

    }


}

