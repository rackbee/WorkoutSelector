package com.example.workoutselector

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
fun SelectWorkout(modifier: Modifier = Modifier, viewModel: SelectWorkoutViewModel = viewModel() ) {

    Column(
        modifier = Modifier.padding(vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            style = MaterialTheme.typography.headlineLarge,
            text = "Get your workout!"
        )

        NumExerciseSelector(viewModel = viewModel)

        WorkoutSelector(viewModel = viewModel, topField = true)
        WorkoutSelector(viewModel = viewModel, topField = false)

        Button(onClick = { viewModel.UpdateWorkouts() },
            shape = CircleShape,
            modifier = Modifier.size(80.dp),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonColors(
                containerColor = Color.Blue,
                contentColor = Color.White,
                disabledContainerColor = Color.Blue,
                disabledContentColor = Color.White)) {
            Text(
                text = "Go",

                style = MaterialTheme.typography.headlineSmall
            )
        }
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize()) {
                WorkoutList(viewModel)

                Row( modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    AddRemove(viewModel)
                }

            }
        }
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
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(viewModel.GetWorkouts()) { workout ->
            WorkoutItem(viewModel, workout)
        }
    }
}

@Composable
fun WorkoutItem(viewModel : SelectWorkoutViewModel, workout:Workout, modifier: Modifier = Modifier ) {
    Box(modifier = Modifier.fillMaxSize().padding(8.dp).clip(shape = RoundedCornerShape(10.dp)).background(color = Color.DarkGray)) {
        Row(modifier = Modifier.fillMaxSize().padding(8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = workout.name)
            val muscleGroup = viewModel.GetWorkoutSubTypeName(workout.muscleGroup)
            Text(text = muscleGroup)
            Button( onClick = { viewModel.ReplaceWorkout(workout)},
                    shape = CircleShape,
                    modifier = Modifier.size(30.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonColors(
                        containerColor = Color.Green,
                        contentColor = Color.Black,
                        disabledContainerColor = Color.Green,
                        disabledContentColor = Color.Black
                    )) {
                Icon(Icons.Default.Refresh, contentDescription = "")
            }
        }
    }
}

@Composable
fun AddRemove(viewModel : SelectWorkoutViewModel, modifier: Modifier = Modifier ) {
       //if (viewModel.GetShowAdd())
        Button(
            modifier = Modifier,
            onClick = { viewModel.AddWorkout() },
            colors = ButtonColors(
                containerColor = Color.Green,
                contentColor = Color.Black,
                disabledContainerColor = Color.Green,
                disabledContentColor = Color.Black
            )) {
            Icon(Icons.Default.Add, contentDescription = "")
        }

        Button(
            modifier = Modifier,
            onClick = { viewModel.RemoveWorkout() },
            colors = ButtonColors(
                containerColor = Color.Red,
                contentColor = Color.White,
                disabledContainerColor = Color.Red,
                disabledContentColor = Color.White
            )
        ) {
            Icon(Icons.Default.Clear, contentDescription = "")
        }
}