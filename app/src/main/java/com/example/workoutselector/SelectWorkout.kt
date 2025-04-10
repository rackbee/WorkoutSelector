package com.example.workoutselector

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Refresh
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.selects.select
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SelectWorkout(viewModel: SelectWorkoutViewModel = viewModel(), modifier: Modifier = Modifier ) {

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center ) {
        Text(
            style = MaterialTheme.typography.headlineLarge,
            text = "Get your workout!" )

        NumExerciseSelector(viewModel = viewModel)

        WorkoutSelector( viewModel = viewModel, topField = true )
        WorkoutSelector( viewModel = viewModel, topField = false )

        Button(onClick = { viewModel.UpdateWorkouts() }) {
            Text(text = "Go",
                style = MaterialTheme.typography.headlineLarge)
        }
        WorkoutList(viewModel)
    }
}

@Composable
fun NumExerciseSelector( viewModel: SelectWorkoutViewModel, modifier: Modifier = Modifier ) {

    var numExerciseExpanded by remember { mutableStateOf(false) }

    Box() {
        Button(onClick = { numExerciseExpanded = true }) {
            Row() {
                Text(text = "Num Exercises: ${viewModel.GetNumExercises()}",
                    style = MaterialTheme.typography.bodyMedium)
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
            }
            DropdownMenu(
                expanded = numExerciseExpanded,
                onDismissRequest = { numExerciseExpanded = false })
            {
                for ( num in 1 .. 8 ) {
                    DropdownMenuItem(text = { Text(num.toString()) }, onClick = {
                        viewModel.SetNumExercises(num)
                        numExerciseExpanded = false
                    })
                }
            }
        }
    }
}

@Composable
fun WorkoutSelector(viewModel: SelectWorkoutViewModel, topField : Boolean, modifier: Modifier = Modifier) {

    var isExpanded by remember { mutableStateOf(false) }

    var curName = ""
    var workoutOptions : List<WorkoutType> = listOf()
    var workoutSubTypeOptions : List<WorkoutSubType> = listOf()
    var typeNames : MutableList<String> = mutableListOf()
    when ( topField ) {
        true -> {
            curName = viewModel.GetWorkoutTypeName(viewModel.GetWorkoutType())
            workoutOptions = viewModel.GetTypeOptions()
            for ( next in workoutOptions ) {
                typeNames.add( viewModel.GetWorkoutTypeName(next))
            }
        }
        false -> {
            curName = viewModel.GetWorkoutSubTypeName(viewModel.GetSubWorkoutType())
            workoutSubTypeOptions = viewModel.GetSubTypeOptions( viewModel.GetWorkoutType())
            for ( next in workoutSubTypeOptions ) {
                typeNames.add( viewModel.GetWorkoutSubTypeName(next))
            }
        }
    }

    Box() {
        Button(onClick = { isExpanded = true }) {
            Row() {
                Text(
                    text = "Workout Type: ${curName}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
            }
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }) {

                for ( i in 0 .. typeNames.size-1) {
                    DropdownMenuItem(text = { Text(typeNames[i]) }, onClick = {
                        when (topField) {
                            true -> {
                                viewModel.SetWorkoutType(
                                    workoutOptions[i],
                                    viewModel.GetSubTypeOptions(workoutOptions[i]).get(0)
                                )
                            }
                            false -> {
                                viewModel.SetWorkoutType(viewModel.GetWorkoutType(), workoutSubTypeOptions[i])
                            }
                        }

                        isExpanded = false
                    })
                }
            }
        }

    }
}

@Composable
fun WorkoutList( viewModel: SelectWorkoutViewModel, modifier: Modifier = Modifier ) {

    LazyColumn( modifier = Modifier.fillMaxSize().padding(8.dp)) {
        items(viewModel.GetWorkouts()) { workout ->
            Workout(viewModel, workout)
        }
    }
}

@Composable
fun Workout(viewModel : SelectWorkoutViewModel, workout:Workout, modifier: Modifier = Modifier ) {
    Box(modifier = Modifier.fillMaxSize().padding(8.dp).clip(shape = RoundedCornerShape(10.dp)).background(color = Color.DarkGray)) {
        Row(modifier = Modifier.fillMaxSize().padding(8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = workout.name)
            val muscleGroup = viewModel.GetWorkoutSubTypeName(workout.muscleGroup)
            Text(text = muscleGroup)
            Button( onClick = { viewModel.ReplaceWorkout(workout)} ) {
                Icon(Icons.Default.Refresh, contentDescription = "")
            }
        }
    }
}