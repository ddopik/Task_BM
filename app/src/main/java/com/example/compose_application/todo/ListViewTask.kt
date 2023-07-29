package com.example.compose_application.todo


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

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

    val ongoingTasks = remember { mutableStateOf(defaultTasks.filter { !it.isComplete }) }
    val completedTasks = remember { mutableStateOf(defaultTasks.filter { it.isComplete }) }
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    LazyColumn(state = listState) {
        item {
            if (ongoingTasks.value.isNotEmpty()) {
                Text(text = "Ongoing Tasks", fontSize = 40.sp)
                for (task in ongoingTasks.value) {
                    TaskCard(task = task) {
                        ongoingTasks.value = defaultTasks.filter { !it.isComplete }
                        completedTasks.value = defaultTasks.filter { it.isComplete }
                        if (!listState.isScrollInProgress) {
                            scope.launch {
                                listState.animateScrollToItem(defaultTasks.size)
                            }
                        }
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

