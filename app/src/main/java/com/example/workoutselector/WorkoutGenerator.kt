package com.example.workoutselector

import androidx.compose.ui.text.toLowerCase
import java.util.Locale
import kotlin.random.Random

data class Workout( val id: Int,
                    var name: String,
                    var muscleGroup: String,
                    var ppl: String )

data class WorkoutType( val id: Int,
                        val name: String )

class WorkoutGenerator() {

    val workouts = mutableListOf<Workout>()

    init {
        PopulateWorkouts()
    }



    fun PopulateWorkouts() {
        workouts.add( Workout(workouts.size+1, name = "Overhead Dumbbell Press", muscleGroup = "shoulders", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Standing Shoulder Fly", muscleGroup = "shoulders", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Bent Over Shoulder Fly", muscleGroup = "shoulders", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Face Pull", muscleGroup = "shoulders", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "45 Degree Shoulder Fly", muscleGroup = "shoulders", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Shrugs", muscleGroup = "shoulders", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Overhead Barbell Press", muscleGroup = "shoulders", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Front Shoulder Raise", muscleGroup = "shoulders", ppl = "pull" ))

        workouts.add( Workout(workouts.size+1, name = "Incline Bench Barbell", muscleGroup = "chest", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Incline Bench Dumbbell", muscleGroup = "chest", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Flat Bench Barbell", muscleGroup = "chest", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Flat Bench Dumbell", muscleGroup = "chest", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Pec Fly", muscleGroup = "chest", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Cable Fly", muscleGroup = "chest", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Dips", muscleGroup = "chest", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Deep Pushups", muscleGroup = "chest", ppl = "push" ))

        workouts.add( Workout(workouts.size+1, name = "Bent Over Dumbell Row", muscleGroup = "back", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Barbell Row", muscleGroup = "back", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Body Hanging Row", muscleGroup = "back", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Trap Cable Pull Down", muscleGroup = "back", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Trap Fly", muscleGroup = "back", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Pull Up", muscleGroup = "back", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Chin Up", muscleGroup = "back", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Wide Grip Pullup", muscleGroup = "back", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "RDL", muscleGroup = "back", ppl = "legs" ))

        workouts.add( Workout(workouts.size+1, name = "Concentration Curl", muscleGroup = "biceps", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Hammer Curl", muscleGroup = "biceps", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "45 Degree Curl", muscleGroup = "biceps", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "EZ Bar Curl", muscleGroup = "biceps", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Cross Body Hammer Curl", muscleGroup = "biceps", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Waiter Curl", muscleGroup = "biceps", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Preacher Curl", muscleGroup = "biceps", ppl = "pull" ))


        workouts.add( Workout(workouts.size+1, name = "Overhead Extension", muscleGroup = "triceps", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Tricep Pull Down", muscleGroup = "triceps", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Face Crusher", muscleGroup = "triceps", ppl = "push" ))


        workouts.add( Workout(workouts.size+1, name = "Leg Raise", muscleGroup = "core", ppl = "core" ))
        workouts.add( Workout(workouts.size+1, name = "Weighted Sit Up", muscleGroup = "core", ppl = "core" ))
        workouts.add( Workout(workouts.size+1, name = "Pike", muscleGroup = "core", ppl = "core" ))
        workouts.add( Workout(workouts.size+1, name = "Oblique Pull", muscleGroup = "core", ppl = "core" ))
        workouts.add( Workout(workouts.size+1, name = "Briefcase Hold", muscleGroup = "core", ppl = "core" ))
        workouts.add( Workout(workouts.size+1, name = "Plank", muscleGroup = "core", ppl = "core" ))



        workouts.add( Workout(workouts.size+1, name = "Squat", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Deadlift", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "RDL", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Hip Thrust", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Calf Raise", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Hamstring Curl", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Side Leg Curl", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Sumo Deadlift", muscleGroup = "legs", ppl = "legs" ))





    }
    fun match(workout: Workout, type: String) : Boolean {
        if ( type.lowercase() == "push" && workout.ppl.lowercase() == "push" ) {
                return true
        }
        if ( type.lowercase() == "pull" && workout.ppl.lowercase() == "pull" ) {
            return true
        }
        if ( type.lowercase() == "legs" && workout.ppl.lowercase() == "legs" ) {
            return true
        }
        if ( type.lowercase() == "shoulders" && workout.muscleGroup.lowercase() == "shoulders" )
            return true;
        if ( type.lowercase() == "chest" && workout.muscleGroup.lowercase()== "chest" )
            return true;
        if ( type.lowercase() == "back" && workout.muscleGroup.lowercase() == "back" )
            return true;
        if ( type.lowercase() == "biceps" && workout.muscleGroup.lowercase() == "biceps" )
            return true;
        if ( type.lowercase() == "triceps" && workout.muscleGroup.lowercase() == "triceps" )
            return true;
        if ( type.lowercase() == "core" && workout.muscleGroup.lowercase() == "core" )
            return true;
        return false
    }

    fun notMatch( workout: Workout, type: String ) : Boolean{
        return !match(workout,type)
    }

    fun GenerateWorkout( workoutType: WorkoutType, workoutSubType: WorkoutType, numExercises: Int ) : List<Workout> {
        return GenerateWorkout( workoutType.name, workoutSubType.name, numExercises )
    }

    fun GenerateWorkout( workoutType: String, workoutSubType: String, numExercises: Int ) : List<Workout> {

        var result = mutableListOf<Workout>()

        // Copy the current list
        var localWorkout = workouts.toMutableList()
        var localNumExercises = numExercises

        // Remove the last day's workout exercises (to improve entropy)

        when ( workoutType.lowercase() )
        {
            "full body" -> {
                result.add( GenerateWorkout( "bro split", "shoulders", 1 ).get(0))
                result.add( GenerateWorkout( "bro split", "back", 1 ).get(0))
                result.add( GenerateWorkout( "bro split", "legs", 1 ).get(0))
                result.add( GenerateWorkout( "bro split", "chest", 1 ).get(0))
                result.add( GenerateWorkout( "bro split", "core", 1 ).get(0))
                // for ( num in 0 .. numExercises ) { // Todo - do a random sampling of a list of subtype
                //}
            }

            "push pull legs" -> {
                // Filter down to the subtype
                localWorkout.removeIf {
                    notMatch(it, workoutSubType)
                }

                if ( localNumExercises > localWorkout.size)
                    localNumExercises = localWorkout.size
                for ( num in 1 .. localNumExercises ) {

                    var next = 0
                    try { next = Random.nextInt(0, localWorkout.size-1) }
                    catch (err: Exception ) { next = 0 }
                    var nextWorkout = localWorkout.get( next)
                    result.add(nextWorkout)
                    localWorkout.remove(nextWorkout)
                }
            }

            "bro split" -> {
                // Filter down to the subtype
                localWorkout.removeIf {
                    notMatch(it, workoutSubType)
                }

                if ( localNumExercises >  localWorkout.size)
                    localNumExercises = localWorkout.size
                for ( num in 1 .. localNumExercises ) {

                    var next = 0
                    try { next = Random.nextInt(0, localWorkout.size-1) }
                    catch (err: Exception ) { next = 0 }
                    var nextWorkout = localWorkout.get( next)
                    result.add(nextWorkout)
                    localWorkout.remove(nextWorkout)
                }
            }
        }

        return result
    }

    fun GetWorkoutTypes( ) : List<WorkoutType> {
        var result = mutableListOf<WorkoutType>()

        result.add( WorkoutType( 1,"Full Body"))
        result.add( WorkoutType( 2,"Push Pull Legs"))
        result.add( WorkoutType( 3,"Bro Split"))

        return result
    }

    fun GetWorkoutSubTypes( type: WorkoutType ) : List<WorkoutType> {
        var result = mutableListOf<WorkoutType>()

        if ( type.id == 0) // N/A
        {
            result.add(WorkoutType(0, "N/A"))
        }
        else if (type.id == 1) // Full Body
        {
            result.add(WorkoutType(0, "N/A"))
        }
        else if ( type.id == 2) { // PPL
            result.add( WorkoutType(1,"Push"))
            result.add(WorkoutType(1,"Pull"))
            result.add(WorkoutType(1,"Legs"))
        }
        else if ( type.id == 3) { // Bro Split
            result.add(WorkoutType(1,"Shoulders"))
            result.add(WorkoutType(2,"Back"))
            result.add(WorkoutType(3,"Chest"))
            result.add(WorkoutType(4,"Biceps"))
            result.add(WorkoutType(5,"Triceps"))
            result.add(WorkoutType(6,"Core"))
            result.add(WorkoutType(7,"Legs"))
        }

        return result
    }
}