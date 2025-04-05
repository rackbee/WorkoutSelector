package com.example.workoutselector

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class Workout( val id: Int,
                    var name: String,
                    var muscleGroup: String,
                    var ppl: String )

@Composable
fun SelectWorkout( modifier: Modifier = Modifier ) {

    var numExerciseExpanded by remember { mutableStateOf(false) }
    var numExercises by remember { mutableStateOf(5) }
    var workoutTypeExpanded by remember { mutableStateOf(false) }
    var workoutSelectedName by remember { mutableStateOf("Workout: Select") }
    var workoutSelectedType by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center ) {
        Text(
            style = MaterialTheme.typography.headlineLarge,
            text = "Get your workout!" )


        // var numExerciseName by remember{mutableStateOf()}
        Box() {
            Button(onClick = { numExerciseExpanded = true }) {
                Row() {
                    Text(text = "Num Exercises: ${numExercises}",
                         style = MaterialTheme.typography.bodyMedium)
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
                }
                DropdownMenu(
                    expanded = numExerciseExpanded,
                    onDismissRequest = { numExerciseExpanded = false })
                {
                    DropdownMenuItem(text = { Text("1") }, onClick = {
                        numExercises = 1
                        numExerciseExpanded = false
                    })
                    DropdownMenuItem(text = { Text("2") }, onClick = {
                        numExercises = 2
                        numExerciseExpanded = false
                    })
                    DropdownMenuItem(text = { Text("3") }, onClick = {
                        numExercises = 3
                        numExerciseExpanded = false
                    })
                    DropdownMenuItem(text = { Text("4") }, onClick = {
                        numExercises = 4
                        numExerciseExpanded = false
                    })
                    DropdownMenuItem(text = { Text("5") }, onClick = {
                        numExercises = 5
                        numExerciseExpanded = false
                    })
                    DropdownMenuItem(text = { Text("6") }, onClick = {
                        numExercises = 6
                        numExerciseExpanded = false
                    })
                    DropdownMenuItem(text = { Text("7") }, onClick = {
                        numExercises = 7
                        numExerciseExpanded = false
                    })
                    DropdownMenuItem(text = { Text("8") }, onClick = {
                        numExercises = 8
                        numExerciseExpanded = false
                    })
                }
            }
        }


        Box() {
            Button(onClick = { workoutTypeExpanded = true }) {
                Row() {
                    Text(text = workoutSelectedName,
                        style = MaterialTheme.typography.bodyMedium)
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
                }
                DropdownMenu(
                    expanded = workoutTypeExpanded,
                    onDismissRequest = { workoutTypeExpanded = false })
                {
                    DropdownMenuItem(text = { Text("Full Body") }, onClick = {
                        workoutSelectedType = 1
                        workoutSelectedName = "Workout: Full Body"
                        workoutTypeExpanded = false
                    })
                    DropdownMenuItem(text = { Text("Push, Pull, Legs") }, onClick = {
                        workoutSelectedType = 2
                        workoutSelectedName = "Workout: Push, Pull, Legs"
                        workoutTypeExpanded = false
                    })
                    DropdownMenuItem(text = { Text("Bro Split") }, onClick = {
                        workoutSelectedType = 3
                        workoutSelectedName = "Workout: Bro Split"
                        workoutTypeExpanded = false
                    })
                }
            }
        }
        Button(onClick = {}) {
            Text(text = "Go",
                style = MaterialTheme.typography.headlineLarge)
        }
        WorkoutList()
    }
}

@Composable
fun WorkoutList( modifier: Modifier = Modifier ) {

    var sItems by remember{ mutableStateOf( listOf<Workout>())}
    LazyColumn( modifier = Modifier.fillMaxSize().padding(8.dp)) {
        items(sItems) {

        }
    }
}