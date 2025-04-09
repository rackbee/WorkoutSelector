package com.example.workoutselector

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
        workouts.add( Workout(workouts.size+1, name = "Overhead Dumbbell Press", muscleGroup = "shoulder", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Standing Shoulder Fly", muscleGroup = "shoulder", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Bent Over Shoulder Fly", muscleGroup = "shoulder", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Face Pull", muscleGroup = "shoulder", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "45 Degree Shoulder Fly", muscleGroup = "shoulder", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Shrugs", muscleGroup = "shoulder", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Overhead Barbell Press", muscleGroup = "shoulder", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Front Shoulder Raise", muscleGroup = "shoulder", ppl = "pull" ))

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

        workouts.add( Workout(workouts.size+1, name = "Concentration Curl", muscleGroup = "bicep", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Hammer Curl", muscleGroup = "bicep", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "45 Degree Curl", muscleGroup = "bicep", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "EZ Bar Curl", muscleGroup = "bicep", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Cross Body Hammer Curl", muscleGroup = "bicep", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Waiter Curl", muscleGroup = "bicep", ppl = "pull" ))
        workouts.add( Workout(workouts.size+1, name = "Preacher Curl", muscleGroup = "bicep", ppl = "pull" ))


        workouts.add( Workout(workouts.size+1, name = "Overhead Extension", muscleGroup = "tricep", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Tricep Pull Down", muscleGroup = "tricep", ppl = "push" ))
        workouts.add( Workout(workouts.size+1, name = "Face Crusher", muscleGroup = "tricep", ppl = "push" ))


        workouts.add( Workout(workouts.size+1, name = "Leg Raise", muscleGroup = "core", ppl = "core" ))
        workouts.add( Workout(workouts.size+1, name = "Weighted Sit Up", muscleGroup = "core", ppl = "core" ))
        workouts.add( Workout(workouts.size+1, name = "Pike", muscleGroup = "core", ppl = "core" ))
        workouts.add( Workout(workouts.size+1, name = "Oblique Pull", muscleGroup = "core", ppl = "core" ))
        workouts.add( Workout(workouts.size+1, name = "Briefcase Hold", muscleGroup = "core", ppl = "core" ))
        workouts.add( Workout(workouts.size+1, name = "Plank", muscleGroup = "core", ppl = "core" ))



        workouts.add( Workout(workouts.size+1, name = "Squat", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Deadlif", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "RDL", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Hip Thrust", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Calf Raise", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Hamstring Curl", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Side Leg Curl", muscleGroup = "legs", ppl = "legs" ))
        workouts.add( Workout(workouts.size+1, name = "Sumo Deadlift", muscleGroup = "legs", ppl = "legs" ))





    }
    fun match(workout: Workout, type: String) : Boolean {
        if ( type == "push" && workout.ppl == "push" ) {
                return true
        }
        if ( type == "pull" && workout.ppl == "pull" ) {
            return true
        }
        if ( type == "legs" && workout.ppl == "legs" ) {
            return true
        }
        if ( type == "shoulders" && workout.muscleGroup == "shoulders" )
            return true;
        if ( type == "chest" && workout.muscleGroup == "chest" )
            return true;
        if ( type == "back" && workout.muscleGroup == "back" )
            return true;
        if ( type == "bicep" && workout.muscleGroup == "bicep" )
            return true;
        if ( type == "tricep" && workout.muscleGroup == "tricep" )
            return true;
        if ( type == "core" && workout.muscleGroup == "core" )
            return true;
        return false
    }

    fun notMatch( workout: Workout, type: String ) : Boolean{
        return !match(workout,type)
    }

    fun GenerateWorkout( type: String, num: Int ) : List<Workout> {
        var result = mutableListOf<Workout>()

        let {
            workouts.removeIf {
                notMatch(it, type)
            }

            return result
        }
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
            result.add( WorkoutType(1,"push"))
            result.add(WorkoutType(1,"pull"))
            result.add(WorkoutType(1,"legs"))
        }
        else if ( type.id == 3) { // Bro Split
            result.add(WorkoutType(1,"shoulders"))
            result.add(WorkoutType(1,"back"))
            result.add(WorkoutType(1,"chest"))
            result.add(WorkoutType(1,"biceps"))
            result.add(WorkoutType(1,"triceps"))
            result.add(WorkoutType(1,"core"))
            result.add(WorkoutType(1,"legs"))
        }

        return result
    }
}