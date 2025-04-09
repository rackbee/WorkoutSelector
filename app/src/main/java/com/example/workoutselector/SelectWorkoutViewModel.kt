package com.example.workoutselector

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class WorkoutState( var workoutType: WorkoutType, var workoutSubType : WorkoutType)

class SelectWorkoutViewModel : ViewModel() {

    private val _workoutGenerator = WorkoutGenerator()

    private val _numExercises = mutableStateOf(5)

    // I can fix this by putting both values inside of a single state
    private val _workoutState = mutableStateOf( WorkoutState( GetTypeOptions().get(0), GetSubTypeOptions(GetTypeOptions().get(0)).get(0)))

    val numExercises: MutableState<Int> = _numExercises
    val workoutState: MutableState<WorkoutState> = _workoutState

    fun init2() {
        numExercises.value = 5
 //       SetWorkoutType(GetTypeOptions().get(0))
    }

    fun SetNumExercises( num : Int ) {
        _numExercises.value = num
    }

    fun SetWorkoutType( type: WorkoutType, subtype: WorkoutType ) {
        _workoutState.value = WorkoutState(type,subtype)
    }

    fun GetTypeOptions() : List<WorkoutType> {
       return _workoutGenerator.GetWorkoutTypes()
    }

    fun GetSubTypeOptions( workoutType: WorkoutType ) : List<WorkoutType> {
        return _workoutGenerator.GetWorkoutSubTypes( workoutType )
    }


}