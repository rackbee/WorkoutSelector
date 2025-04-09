package com.example.workoutselector

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


data class WorkoutState( var workoutType: WorkoutType,
                         var workoutSubType : WorkoutType,
                         var numExercises : Int,
                         var sWorkouts : List<Workout> )

class SelectWorkoutViewModel : ViewModel() {

    // Model
    private val _workoutGenerator = WorkoutGenerator()

    // State
    // I can fix this by putting both values inside of a single state
    private val _workoutState = mutableStateOf( WorkoutState( workoutType = GetTypeOptions().get(0), workoutSubType = GetSubTypeOptions(GetTypeOptions().get(0)).get(0), numExercises = 5, sWorkouts = listOf()))
    val workoutState : State<WorkoutState> = _workoutState

    fun GetNumExercises() : Int {
        return _workoutState.value.numExercises
    }

    fun SetNumExercises( num : Int ) {
        _workoutState.value = _workoutState.value.copy( numExercises = num )
    }

    fun GetWorkoutType() : WorkoutType {
        return _workoutState.value.workoutType
    }

    fun GetSubWorkoutType() : WorkoutType {
        return _workoutState.value.workoutSubType
    }

    fun SetWorkoutType( type: WorkoutType, subtype: WorkoutType ) {
        _workoutState.value = _workoutState.value.copy( workoutType= type, workoutSubType = subtype)
    }

    fun GetTypeOptions() : List<WorkoutType> {
       return _workoutGenerator.GetWorkoutTypes()
    }

    fun GetSubTypeOptions( workoutType: WorkoutType ) : List<WorkoutType> {
        return _workoutGenerator.GetWorkoutSubTypes( workoutType )
    }

    fun GetWorkouts() : List<Workout> {
        return _workoutState.value.sWorkouts;
    }
    fun UpdateWorkouts() {
        val result = _workoutGenerator.GenerateWorkout(_workoutState.value.workoutType, _workoutState.value.workoutSubType, _workoutState.value.numExercises )
        _workoutState.value = _workoutState.value.copy(sWorkouts = result)

    }

}