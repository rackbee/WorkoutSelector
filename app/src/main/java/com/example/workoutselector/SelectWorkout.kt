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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



@Composable
fun SelectWorkout( viewModel: SelectWorkoutViewModel, modifier: Modifier = Modifier ) {

    var numExerciseExpanded by remember { mutableStateOf(false) }
    var workoutTypeExpanded by remember { mutableStateOf(false) }
    var workoutSubTypeExpanded by remember { mutableStateOf(false) }
    // var workoutType by remember {mutableStateOf(viewModel.workoutType)}
    // var workoutSubType by remember{mutableStateOf(viewModel.workoutSubType)}


    val workoutTypes = viewModel.GetTypeOptions()
    val workoutSubTypes = viewModel.GetSubTypeOptions(viewModel.workoutState.value.workoutType)

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
                    Text(text = "Num Exercises: ${viewModel.numExercises.value}",
                         style = MaterialTheme.typography.bodyMedium)
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
                }
                DropdownMenu(
                    expanded = numExerciseExpanded,
                    onDismissRequest = { numExerciseExpanded = false })
                {
                    for ( num in 1 .. 8 ) {

                        DropdownMenuItem(text = { Text(num.toString()) }, onClick = {
                            viewModel.numExercises.value = num
                            numExerciseExpanded = false
                        })
                    }
                }
            }
        }


        Box() {
            Button(onClick = { workoutTypeExpanded = true }) {
                Row() {
                    Text(text = "Workout Type: ${viewModel.workoutState.value.workoutType.name}",
                        style = MaterialTheme.typography.bodyMedium)
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
                }
                DropdownMenu(
                    expanded = workoutTypeExpanded,
                    onDismissRequest = { workoutTypeExpanded = false })
                {
                    for ( type in workoutTypes) {
                        DropdownMenuItem(text = { Text( type.name )}, onClick = {
                            viewModel.SetWorkoutType( type, viewModel.GetSubTypeOptions(type).get(0) )
                            // workoutType = viewModel.workoutType
                            workoutTypeExpanded = false
                        })
                    }
                }

            }
        }

        Box() {
            Button(onClick = { workoutSubTypeExpanded = true }) {
                Row() {
                    Text(text = "Workout Type: ${viewModel.workoutState.value.workoutSubType.name}",
                        style = MaterialTheme.typography.bodyMedium)
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
                }
                DropdownMenu(
                    expanded = workoutSubTypeExpanded,
                    onDismissRequest = { workoutSubTypeExpanded = false })
                {
                    for ( type in workoutSubTypes) {
                        DropdownMenuItem(text = { Text( type.name )}, onClick = {
                            viewModel.SetWorkoutType( viewModel.workoutState.value.workoutType, type)
                            // workoutSubType = viewModel.workoutSubType
                            workoutSubTypeExpanded = false
                        })
                    }
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