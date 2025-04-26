package com.example.workoutselector

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
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
fun SelectWorkoutContainer(modifier: Modifier = Modifier, viewModel: SelectWorkoutViewModel = viewModel() ) {
    Scaffold( modifier = Modifier.fillMaxSize(),
        topBar = {SelectWorkoutTopBar()},
        floatingActionButton = {SelectWorkoutActionButtons(viewModel = viewModel)})
    { padding ->
        SelectWorkout( modifier = Modifier.padding(padding), viewModel = viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectWorkoutTopBar( modifier: Modifier = Modifier ) {
    TopAppBar( modifier = Modifier,
                colors = TopAppBarColors(containerColor = Color.DarkGray,
                    scrolledContainerColor = Color.Green,
                    navigationIconContentColor = Color.Blue,
                    actionIconContentColor = Color.Cyan,
                    titleContentColor = Color.White ),
                title = { Text( text = "Select your Workout")})
}

@Composable
fun SelectWorkoutActionButtons( modifier: Modifier = Modifier, viewModel: SelectWorkoutViewModel ) {
    AddRemove( viewModel = viewModel )
}

@Composable
fun SelectWorkout(modifier: Modifier = Modifier, viewModel: SelectWorkoutViewModel = viewModel() ) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
            Column( modifier = Modifier, verticalArrangement = Arrangement.Center) {
                NumExerciseSelector(viewModel = viewModel)
            }
            Column ( modifier = Modifier ) {
                WorkoutSelector(viewModel = viewModel, topField = true)
                WorkoutSelector(viewModel = viewModel, topField = false)
            }
            Column {
                Button(onClick = { viewModel.updateWorkouts() },
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
            }
        }


        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize()) {
                WorkoutList(viewModel)

//                Row( modifier = Modifier
//                    .align(Alignment.BottomCenter)
//                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
//                    AddRemove(viewModel)
//                }

            }
        }
    }
}

@Composable
fun NumExerciseSelector( viewModel: SelectWorkoutViewModel, modifier: Modifier = Modifier ) {

    var numExerciseExpanded by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { numExerciseExpanded = true },
               colors =  ButtonColors( contentColor = Color.White,
                                        containerColor = Color.DarkGray,
                                        disabledContentColor = Color.White,
                                        disabledContainerColor = Color.DarkGray)) {
            Row {
                Text(text = "# ${viewModel.getNumExercises()}",
                    style = MaterialTheme.typography.bodyMedium)
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
            }
            DropdownMenu(
                expanded = numExerciseExpanded,
                onDismissRequest = { numExerciseExpanded = false })
            {
                for ( num in 1 .. 8 ) {
                    DropdownMenuItem(text = { Text(num.toString()) }, onClick = {
                        viewModel.setNumExercises(num)
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
            curName = viewModel.getWorkoutTypeName(viewModel.getWorkoutType())
            workoutOptions = viewModel.getTypeOptions()
            for ( next in workoutOptions ) {
                typeNames.add( viewModel.getWorkoutTypeName(next))
            }
        }
        false -> {
            curName = viewModel.getWorkoutSubTypeName(viewModel.getSubWorkoutType())
            workoutSubTypeOptions = viewModel.getSubTypeOptions( viewModel.getWorkoutType())
            for ( next in workoutSubTypeOptions ) {
                typeNames.add( viewModel.getWorkoutSubTypeName(next))
            }
        }
    }

    Box {
        Button(
            onClick = { isExpanded = true },
            colors =  ButtonColors( contentColor = Color.White,
            containerColor = Color.DarkGray,
            disabledContentColor = Color.White,
            disabledContainerColor = Color.DarkGray)) {
            Row {
                Text(modifier = Modifier,
                    text = curName,
                    style = MaterialTheme.typography.bodyMedium
                )
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = "")
            }
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }) {

                for ( i in 0 ..< typeNames.size-1) {
                    DropdownMenuItem(text = { Text(typeNames[i]) }, onClick = {
                        when (topField) {
                            true -> {
                                viewModel.setWorkoutType(
                                    workoutOptions[i],
                                    viewModel.getSubTypeOptions(workoutOptions[i])[0]
                                )
                            }
                            false -> {
                                viewModel.setWorkoutType(viewModel.getWorkoutType(), workoutSubTypeOptions[i])
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
        items(viewModel.getWorkouts()) { workout ->
            WorkoutItem(viewModel, workout)
        }
    }
}

@Composable
fun WorkoutItem(viewModel : SelectWorkoutViewModel, workout:Workout, modifier: Modifier = Modifier ) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .background(color = Color.DarkGray)) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = workout.name)
            val muscleGroup = viewModel.getWorkoutSubTypeName(workout.muscleGroup)
            Text(text = muscleGroup)
            Button( onClick = { viewModel.replaceWorkout(workout)},
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
    Row( modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        //if (viewModel.GetShowAdd())
        Button(
            modifier = Modifier,
            onClick = { viewModel.addWorkout() },
            colors = ButtonColors(
                containerColor = Color.Green,
                contentColor = Color.Black,
                disabledContainerColor = Color.Green,
                disabledContentColor = Color.Black
            )
        ) {
            Icon(Icons.Default.Add, contentDescription = "")
        }

        Button(
            modifier = Modifier,
            onClick = { viewModel.removeWorkout() },
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
}