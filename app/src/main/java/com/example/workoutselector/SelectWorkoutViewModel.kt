package com.example.workoutselector

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


data class WorkoutState( var workoutType: WorkoutType,
                         var workoutSubType : WorkoutSubType,
                         var numExercises : Int,
                         var sWorkouts : List<Workout>,
                         var showAdd : Boolean = false)

class SelectWorkoutViewModel : ViewModel() {

    // Model
    private val _workoutGenerator = WorkoutGenerator()

    // State
    // I can fix this by putting both values inside of a single state
    private var _workoutState by mutableStateOf( WorkoutState( workoutType = getTypeOptions()[0], workoutSubType = getSubTypeOptions(getTypeOptions()[0])[0], numExercises = 5, sWorkouts = listOf()))

    fun getNumExercises() : Int {
        return _workoutState.numExercises
    }

    fun setNumExercises( num : Int ) {
        _workoutState = _workoutState.copy( numExercises = num )
    }

    fun getWorkoutType() : WorkoutType {
        return _workoutState.workoutType
    }

    fun getSubWorkoutType() : WorkoutSubType {
        return _workoutState.workoutSubType
    }

    fun setWorkoutType( type: WorkoutType, subtype: WorkoutSubType ) {
        _workoutState = _workoutState.copy( workoutType= type, workoutSubType = subtype)
    }

    fun getTypeOptions() : List<WorkoutType> {
       return _workoutGenerator.GetWorkoutTypes()
    }

    fun getSubTypeOptions( workoutType: WorkoutType ) : List<WorkoutSubType> {
        return _workoutGenerator.GetWorkoutSubTypes( workoutType )
    }

    fun getWorkoutTypeName( workoutType : WorkoutType ) : String {
        return _workoutGenerator.GetWorkoutTypeName(workoutType)
    }

    fun getWorkoutSubTypeName( workoutSubType : WorkoutSubType ) : String {
        return _workoutGenerator.GetWorkoutSubTypeName(workoutSubType)
    }

    fun getShowAdd() : Boolean {
        return _workoutState.showAdd
    }

    fun setShowAdd( add : Boolean ) {
        _workoutState = _workoutState.copy( showAdd = true)
    }

    fun getWorkouts() : List<Workout> {
        return _workoutState.sWorkouts
    }

    fun updateWorkouts() {
        val result = _workoutGenerator.GenerateWorkout(_workoutState.workoutType, _workoutState.workoutSubType, _workoutState.numExercises )
        _workoutState = _workoutState.copy(sWorkouts = result, showAdd = true)
    }

    fun replaceWorkout( workoutToReplace: Workout ) {
        // Get a new random workout from the model
        val newWorkout = _workoutGenerator.ReplaceWorkout(_workoutState.sWorkouts, workoutToReplace, _workoutState.workoutType, _workoutState.workoutSubType)

        var workouts = _workoutState.sWorkouts.toMutableList()
        var workouts2 = workouts.map{ element ->
            if ( element.name == workoutToReplace.name ) {
                newWorkout ?: element
            }
            else {
                element
            }
        }
        _workoutState = _workoutState.copy(sWorkouts = workouts2)
    }

    fun addWorkout() {

        // Get a new random workout from the model
        val newWorkout = _workoutGenerator.ReplaceWorkout(_workoutState.sWorkouts, toReplace = null, _workoutState.workoutType, _workoutState.workoutSubType)

        newWorkout ?: return

        var workouts = _workoutState.sWorkouts.toMutableList()
        workouts.add( newWorkout )
        _workoutState = _workoutState.copy(sWorkouts = workouts, numExercises = _workoutState.numExercises+1)
    }

    fun removeWorkout() {

        var workouts = _workoutState.sWorkouts.toMutableList()

        if (workouts.size == 0 )
            return

        workouts.removeAt( workouts.size-1)

        _workoutState = _workoutState.copy(sWorkouts = workouts, numExercises = _workoutState.numExercises-1)

    }
}