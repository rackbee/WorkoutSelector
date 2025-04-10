package com.example.workoutselector

import androidx.compose.ui.text.toLowerCase
import java.util.Locale
import kotlin.random.Random

enum class WorkoutSubType() {
    Shoulders,
    Chest,
    Back,
    Core,
    Legs,
    Triceps,
    Biceps,
    Push,
    Pull,
    NA
}

enum class WorkoutType() {
    FullBody,
    PPL,
    Split
}

data class Workout( val id: Int,
                    var name: String,
                    var muscleGroup: WorkoutSubType,
                    var ppl: WorkoutSubType,
                    var exclude: Int = 0)

class WorkoutGenerator() {

    val workouts = mutableListOf<Workout>()

    init {
        PopulateWorkouts()
    }

    fun GetWorkoutTypeName(wt : WorkoutType) : String {
        when (wt) {
            WorkoutType.FullBody -> return "Full Body"
            WorkoutType.PPL -> return "Push Pull Legs"
            WorkoutType.Split -> return "Split"
        }
    }

    fun GetWorkoutSubTypeName( wt: WorkoutSubType ) : String {
        when (wt) {
            WorkoutSubType.Shoulders -> return "Shoulders"
            WorkoutSubType.Chest -> return "Chest"
            WorkoutSubType.Back -> return "Back"
            WorkoutSubType.Core -> return "Core"
            WorkoutSubType.Triceps -> return "Triceps"
            WorkoutSubType.Legs -> return "Legs"
            WorkoutSubType.Biceps -> return "Biceps"
            WorkoutSubType.Push -> return "Push"
            WorkoutSubType.Pull -> return "Pull"
            WorkoutSubType.NA -> return "N/A"
        }
    }

    fun PopulateWorkouts() {
        workouts.add( Workout(workouts.size+1, name = "Overhead Dumbbell Press", muscleGroup = WorkoutSubType.Shoulders, ppl = WorkoutSubType.Push ))
        workouts.add( Workout(workouts.size+1, name = "Standing Shoulder Fly", muscleGroup = WorkoutSubType.Shoulders, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "Bent Over Shoulder Fly", muscleGroup = WorkoutSubType.Shoulders, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "Face Pull", muscleGroup = WorkoutSubType.Shoulders, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "45 Degree Shoulder Fly", muscleGroup = WorkoutSubType.Shoulders, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "Shrugs", muscleGroup = WorkoutSubType.Shoulders, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "Overhead Barbell Press", muscleGroup = WorkoutSubType.Shoulders, ppl = WorkoutSubType.Push ))
        workouts.add( Workout(workouts.size+1, name = "Front Shoulder Raise", muscleGroup = WorkoutSubType.Shoulders, ppl = WorkoutSubType.Pull ))

        workouts.add( Workout(workouts.size+1, name = "Incline Bench Barbell", muscleGroup = WorkoutSubType.Chest, ppl = WorkoutSubType.Push, exclude = 1 ))
        workouts.add( Workout(workouts.size+1, name = "Incline Bench Dumbbell", muscleGroup = WorkoutSubType.Chest, ppl = WorkoutSubType.Push, exclude = 1 ))
        workouts.add( Workout(workouts.size+1, name = "Flat Bench Barbell", muscleGroup = WorkoutSubType.Chest, ppl = WorkoutSubType.Push, exclude = 2 ))
        workouts.add( Workout(workouts.size+1, name = "Flat Bench Dumbell", muscleGroup = WorkoutSubType.Chest, ppl = WorkoutSubType.Push, exclude = 2 ))
        workouts.add( Workout(workouts.size+1, name = "Pec Fly", muscleGroup = WorkoutSubType.Chest, ppl = WorkoutSubType.Push ))
        workouts.add( Workout(workouts.size+1, name = "Cable Fly", muscleGroup = WorkoutSubType.Chest, ppl = WorkoutSubType.Push ))
        workouts.add( Workout(workouts.size+1, name = "Dips", muscleGroup = WorkoutSubType.Chest, ppl = WorkoutSubType.Push ))
        workouts.add( Workout(workouts.size+1, name = "Deep Pushups", muscleGroup = WorkoutSubType.Chest, ppl = WorkoutSubType.Push ))

        workouts.add( Workout(workouts.size+1, name = "Bent Over Dumbell Row", muscleGroup = WorkoutSubType.Back, ppl = WorkoutSubType.Pull, exclude = 3 ))
        workouts.add( Workout(workouts.size+1, name = "Barbell Row", muscleGroup = WorkoutSubType.Back, ppl = WorkoutSubType.Pull, exclude = 3 ))
        workouts.add( Workout(workouts.size+1, name = "Body Hanging Row", muscleGroup = WorkoutSubType.Back, ppl = WorkoutSubType.Pull , exclude = 3))
        workouts.add( Workout(workouts.size+1, name = "Trap Cable Pull Down", muscleGroup = WorkoutSubType.Back, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "Trap Fly", muscleGroup = WorkoutSubType.Back, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "Pull Up", muscleGroup = WorkoutSubType.Back, ppl = WorkoutSubType.Pull, exclude = 4 ))
        workouts.add( Workout(workouts.size+1, name = "Chin Up", muscleGroup = WorkoutSubType.Back, ppl = WorkoutSubType.Pull, exclude = 4 ))
        workouts.add( Workout(workouts.size+1, name = "Wide Grip Pullup", muscleGroup = WorkoutSubType.Back, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "RDL", muscleGroup = WorkoutSubType.Back, ppl = WorkoutSubType.Core ))

        workouts.add( Workout(workouts.size+1, name = "Concentration Curl", muscleGroup = WorkoutSubType.Biceps, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "Hammer Curl", muscleGroup = WorkoutSubType.Biceps, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "45 Degree Curl", muscleGroup = WorkoutSubType.Biceps, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "EZ Bar Curl", muscleGroup = WorkoutSubType.Biceps, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "Cross Body Hammer Curl", muscleGroup = WorkoutSubType.Biceps, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "Waiter Curl", muscleGroup = WorkoutSubType.Biceps, ppl = WorkoutSubType.Pull ))
        workouts.add( Workout(workouts.size+1, name = "Preacher Curl", muscleGroup = WorkoutSubType.Biceps, ppl = WorkoutSubType.Pull ))


        workouts.add( Workout(workouts.size+1, name = "Overhead Extension", muscleGroup = WorkoutSubType.Triceps, ppl = WorkoutSubType.Push ))
        workouts.add( Workout(workouts.size+1, name = "Tricep Pull Down", muscleGroup = WorkoutSubType.Triceps, ppl = WorkoutSubType.Push ))
        workouts.add( Workout(workouts.size+1, name = "Face Crusher", muscleGroup = WorkoutSubType.Triceps, ppl = WorkoutSubType.Push ))


        workouts.add( Workout(workouts.size+1, name = "Leg Raise", muscleGroup = WorkoutSubType.Core, ppl = WorkoutSubType.Core ))
        workouts.add( Workout(workouts.size+1, name = "Weighted Sit Up", muscleGroup = WorkoutSubType.Core, ppl = WorkoutSubType.Core ))
        workouts.add( Workout(workouts.size+1, name = "Pike", muscleGroup = WorkoutSubType.Core, ppl = WorkoutSubType.Core ))
        workouts.add( Workout(workouts.size+1, name = "Oblique Pull", muscleGroup = WorkoutSubType.Core, ppl = WorkoutSubType.Core ))
        workouts.add( Workout(workouts.size+1, name = "Briefcase Hold", muscleGroup = WorkoutSubType.Core, ppl = WorkoutSubType.Core ))
        workouts.add( Workout(workouts.size+1, name = "Plank", muscleGroup = WorkoutSubType.Core, ppl = WorkoutSubType.Core ))



        workouts.add( Workout(workouts.size+1, name = "Squat", muscleGroup = WorkoutSubType.Legs, ppl = WorkoutSubType.Legs ))
        workouts.add( Workout(workouts.size+1, name = "Deadlift", muscleGroup = WorkoutSubType.Legs, ppl = WorkoutSubType.Legs ))
        workouts.add( Workout(workouts.size+1, name = "Hip Thrust", muscleGroup = WorkoutSubType.Legs, ppl = WorkoutSubType.Legs ))
        workouts.add( Workout(workouts.size+1, name = "Calf Raise", muscleGroup = WorkoutSubType.Legs, ppl = WorkoutSubType.Legs ))
        workouts.add( Workout(workouts.size+1, name = "Hamstring Curl", muscleGroup = WorkoutSubType.Legs, ppl = WorkoutSubType.Legs ))
        workouts.add( Workout(workouts.size+1, name = "Side Leg Curl", muscleGroup = WorkoutSubType.Legs, ppl = WorkoutSubType.Legs ))
        workouts.add( Workout(workouts.size+1, name = "Sumo Deadlift", muscleGroup = WorkoutSubType.Legs, ppl = WorkoutSubType.Legs ))





    }
    fun match(workout: Workout, workoutType: WorkoutType, workoutSubType : WorkoutSubType) : Boolean {

        if ( workoutType == WorkoutType.PPL )
        {
            return workout.ppl == workoutSubType;
        }

        if ( workoutType == WorkoutType.Split )
        {
            return workout.muscleGroup == workoutSubType;
        }

        return false;
    }

    fun notMatch( workout: Workout, workoutType: WorkoutType, workoutSubType : WorkoutSubType ) : Boolean{
        return !match(workout,workoutType, workoutSubType)
    }

    fun GenerateWorkout( workoutType: WorkoutType, workoutSubType: WorkoutSubType, numExercises: Int ) : List<Workout> {
        when ( workoutType ) {
            WorkoutType.FullBody -> return GenerateFullBodyWorkout()
            WorkoutType.PPL -> return GeneratePPLWorkout(workoutSubType, numExercises);
            WorkoutType.Split -> return GenerateSplitWorkout(workoutSubType, numExercises);
        }
    }

    fun GenerateFullBodyWorkout() : List<Workout> {
        val result : MutableList<Workout> = mutableListOf()
        result.add(GenerateSplitWorkout(WorkoutSubType.Legs, 1).get(0))
        result.add(GenerateSplitWorkout(WorkoutSubType.Shoulders, 1).get(0))
        result.add(GenerateSplitWorkout(WorkoutSubType.Chest, 1).get(0))
        result.add(GenerateSplitWorkout(WorkoutSubType.Back, 1).get(0))
        result.add(GenerateSplitWorkout(WorkoutSubType.Core, 1).get(0))
        return result;
    }

    fun GeneratePPLWorkout( workoutSubType: WorkoutSubType, numExercises : Int ) : List<Workout> {

        val result : MutableList<Workout> = mutableListOf()
        // Eliminate all non-candidate workouts
        val trimmedWorkouts = workouts.toMutableList()
        trimmedWorkouts.removeIf {
            notMatch( it, WorkoutType.PPL, workoutSubType)
        }

        GetNumOfRandomWorkoutToList( trimmedWorkouts, result, numExercises)

        return result
    }



    fun GenerateSplitWorkout( workoutSubType: WorkoutSubType, numExercises : Int ) : List<Workout> {

        val result : MutableList<Workout> = mutableListOf()
        // Eliminate all non-candidate workouts
        val trimmedWorkouts = workouts.toMutableList()
        trimmedWorkouts.removeIf {
            notMatch( it, WorkoutType.Split, workoutSubType)
        }

        GetNumOfRandomWorkoutToList( trimmedWorkouts, result, numExercises)

        return result
    }

    private fun GetNumOfRandomWorkoutToList( workouts: MutableList<Workout>, resultList : MutableList<Workout>, numExercises : Int ) {

        var iter = 0;
        while ( iter < numExercises ) {
            if (workouts.size == 0)
                break;

            var next = GetRandomWorkout(workouts)
            if (next == null)
                break;

            workouts.remove(next);

            // If we find a workout that has a conflict throw it away
            if (next.exclude != 0 && resultList.any { it.exclude == next.exclude }) {
                continue;
            }

            resultList.add(next)

            iter++
        }
    }

    private fun GetRandomWorkout( workouts : List<Workout> ) : Workout? {

        if ( workouts.size == 1 )
            return workouts[0]

        return workouts[Random.nextInt(0, workouts.size)]
    }


//    fun GenerateWorkout( workoutType: String, workoutSubType: String, numExercises: Int ) : List<Workout> {
//
//        var result = mutableListOf<Workout>()
//
//        // Copy the current list
//        var localWorkout = workouts.toMutableList()
//        var localNumExercises = numExercises
//
//        // Remove the last day's workout exercises (to improve entropy)
//
//        when ( workoutType.lowercase() )
//        {
//            "full body" -> {
//                result.add( GenerateWorkout( "bro split", "shoulders", 1 ).get(0))
//                result.add( GenerateWorkout( "bro split", "back", 1 ).get(0))
//                result.add( GenerateWorkout( "bro split", "legs", 1 ).get(0))
//                result.add( GenerateWorkout( "bro split", "chest", 1 ).get(0))
//                result.add( GenerateWorkout( "bro split", "core", 1 ).get(0))
//                // for ( num in 0 .. numExercises ) { // Todo - do a random sampling of a list of subtype
//                //}
//            }
//
//            "push pull legs" -> {
//                // Filter down to the subtype
//                localWorkout.removeIf {
//                    notMatch(it, workoutSubType)
//                }
//
//                if ( localNumExercises > localWorkout.size)
//                    localNumExercises = localWorkout.size
//                for ( num in 1 .. localNumExercises ) {
//
//                    var next = 0
//                    try { next = Random.nextInt(0, localWorkout.size-1) }
//                    catch (err: Exception ) { next = 0 }
//                    var nextWorkout = localWorkout.get( next)
//                    result.add(nextWorkout)
//                    localWorkout.remove(nextWorkout)
//                }
//            }
//
//            "bro split" -> {
//                // Filter down to the subtype
//                localWorkout.removeIf {
//                    notMatch(it, workoutSubType)
//                }
//
//                if ( localNumExercises >  localWorkout.size)
//                    localNumExercises = localWorkout.size
//                for ( num in 1 .. localNumExercises ) {
//
//                    var next = 0
//                    try { next = Random.nextInt(0, localWorkout.size-1) }
//                    catch (err: Exception ) { next = 0 }
//                    var nextWorkout = localWorkout.get( next)
//                    result.add(nextWorkout)
//                    localWorkout.remove(nextWorkout)
//                }
//            }
//        }
//
//        return result
//    }

    fun GetWorkoutTypes( ) : List<WorkoutType> {
        var result = mutableListOf<WorkoutType>()

        result.add( WorkoutType.FullBody)
        result.add( WorkoutType.PPL)
        result.add( WorkoutType.Split )

        return result
    }

    fun GetWorkoutSubTypes( type: WorkoutType ) : List<WorkoutSubType> {
        var result = mutableListOf<WorkoutSubType>()

        when ( type ) {
            WorkoutType.FullBody -> result.add(WorkoutSubType.NA);

            WorkoutType.PPL -> {
                result.add(WorkoutSubType.Push)
                result.add(WorkoutSubType.Pull)
                result.add(WorkoutSubType.Legs)
                result.add(WorkoutSubType.Core)
            }

            WorkoutType.Split -> {
                result.add(WorkoutSubType.Shoulders)
                result.add(WorkoutSubType.Back)
                result.add(WorkoutSubType.Chest)
                result.add(WorkoutSubType.Core)
                result.add(WorkoutSubType.Legs)
                result.add(WorkoutSubType.Biceps)
                result.add(WorkoutSubType.Triceps)
            }
        }

        return result
    }
}