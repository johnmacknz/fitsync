import React, {useEffect, useState} from "react";
import UserNavbar from "../../components/usernavbar/UserNavbar";
import {useUserId} from "../../AppRouter";

const ExerciseListInput = () => {

    const [exercises, setExercises] = useState([]);
    const [exercise, setExercise] = useState({
        exerciseName: '',
        exerciseType: '',
        targetMuscle: '',
        equipmentRequired: '',
        startTime: '',
        endTime: '',
        caloriesBurned: '',
        sets: '',
        reps: '',
        distanceInKm: '',
        weightInKg: '',
        description: ''
    });
    const [selectedExerciseType, setSelectedExerciseType] = useState('');

    const [visibleColumns, setVisibleColumns] = useState([]);
    const { userId } = useUserId();

    const columnDisplayNameMap = {
        exerciseName: 'Exercise Name',
        exerciseType: 'Exercise Type',
        targetMuscle: 'Target Muscle',
        equipmentRequired: 'Equipment Required',
        startTime: 'Start Date',
        endTime: 'End Date',
        caloriesBurned: 'Calories Burned',
        sets: 'Sets',
        reps: 'Reps',
        distanceInKm: 'Distance (km)',
        weightInKg: 'Weight (kg)',
        description: 'Description'
    };

    useEffect(() => {
        // Fetch existing exercises
        let apiUrl = `http://localhost:8080/exercises/person/${userId}`;
        fetch(apiUrl)
            .then(response => response.json())
            .then(data => setExercises(data))
            .catch(error => console.error('Error fetching exercises:', error));
    }, [userId]);

    const handleChange = (e) => {
        setExercise({
            ...exercise,
            [e.target.name]: e.target.value,
        });
    };

    const handleAddExercise = (e) => {
        e.preventDefault();


        const exerciseWithType = {
            ...exercise,
            exerciseType: selectedExerciseType,
            personId: userId,
        };

        // Perform the POST request to add the new exercise
        fetch('http://localhost:8080/exercises', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(exerciseWithType),
        })
            .then(response => response.json())
            .then(data => {
                setExercises([...exercises, data]);
                setExercise({
                    exerciseName: '',
                    exerciseType: '',
                    targetMuscle: '',
                    equipmentRequired: '',
                    startTime: '',
                    endTime: '',
                    caloriesBurned: '',
                    sets: '',
                    reps: '',
                    distanceInKm: '',
                    weightInKg: '',
                    description: ''
                });
            })
            .catch(error => console.error('Error adding exercise:', error));
    };

    const filteredExercises = exercises.filter(exercise => {
        return exercise.exerciseType === selectedExerciseType;
    });

    const handleExerciseTypeButtonClick = (type) => {
        setSelectedExerciseType(type);


        // Define which columns to display based on the exercise type
        switch (type) {
            case 'BodyWeight Exercise':
                setVisibleColumns(['exerciseName', 'startTime', 'endTime', 'caloriesBurned', 'sets', 'reps', 'targetMuscle', 'description']);
                break;
            case 'WeightLifting Exercise':
                setVisibleColumns(['exerciseName', 'startTime', 'endTime', 'caloriesBurned', 'sets', 'reps', 'weightInKg', 'targetMuscle', 'equipmentRequired', 'description']);
                break;
            case 'Isometric Exercise':
                setVisibleColumns(['exerciseName', 'startTime', 'endTime', 'caloriesBurned', 'targetMuscle', 'description']);
                break;
            case 'Distance Cardio Exercise':
                setVisibleColumns(['exerciseName', 'startTime', 'endTime', 'caloriesBurned', 'distanceInKm', 'description']);
                break;
            case 'No Distance Cardio Exercise':
                setVisibleColumns(['exerciseName', 'startTime', 'endTime', 'caloriesBurned', 'description']);
                break;
            default:
                setVisibleColumns([]);

                return;
        }

    };

    return (
        <div className="ft__login__container">
            <UserNavbar />
            <div className="navbar">
                {/* Add buttons for each exercise type */}
                {['BodyWeight Exercise', 'WeightLifting Exercise', 'Isometric Exercise', 'Distance Cardio Exercise', 'No Distance Cardio Exercise'].map(type => (
                    <button
                        key={type}
                        onClick={() => handleExerciseTypeButtonClick(type)}
                        className={selectedExerciseType === type ? 'active' : ''}
                    >
                        {type}
                    </button>
                ))}
            </div>


            <h2>Activities:</h2>
            <table>
                <thead>
                <tr>
                    {visibleColumns.map(column => (
                        <th key={column}>{columnDisplayNameMap[column]}</th>
                    ))}
                </tr>
                </thead>
                <tbody>
                {filteredExercises.map(exercise => (
                    <tr key={exercise.id}>
                        {visibleColumns.map(column => (
                            <td key={column}>{exercise[column]}</td>
                        ))}
                    </tr>
                ))}
                </tbody>
            </table>

            <form onSubmit={handleAddExercise}>
                {/* Display specific form fields based on the selected exercise type */}
                {selectedExerciseType && (
                    <>
                        <div className="form-group">
                            <label>Exercise Name:</label>
                            <input type="text" name="exerciseName" value={exercise.exerciseName}
                                   onChange={handleChange}/>
                        </div>

                        <div className="form-group">
                            <label>Start time:</label>
                            <input type="datetime-local" name="startTime" value={exercise.startTime}
                                   onChange={handleChange}/>
                        </div>

                        <div className="form-group">
                            <label>End time:</label>
                            <input type="datetime-local" name="endTime" value={exercise.endTime}
                                   onChange={handleChange}/>
                        </div>

                        <div className="form-group">
                            <label>Calories burned:</label>
                            <input type="number" name="caloriesBurned" value={exercise.caloriesBurned}
                                   onChange={handleChange}/>
                        </div>

                        {selectedExerciseType === 'Isometric Exercise' && (
                            <>
                                <div className="form-group">
                                    <label>Target Muscle:</label>
                                    <input type="text" name="targetMuscle" value={exercise.targetMuscle}
                                           onChange={handleChange}/>
                                </div>
                            </>
                        )}

                        {selectedExerciseType === 'WeightLifting Exercise' && (
                            <>
                                <div className="form-group">
                                    <label>Sets:</label>
                                    <input type="number" name="sets" value={exercise.sets} onChange={handleChange}/>
                                </div>

                                <div className="form-group">
                                    <label>Reps:</label>
                                    <input type="number" name="reps" value={exercise.reps} onChange={handleChange}/>
                                </div>

                                <div className="form-group">
                                    <label>Weight (kg):</label>
                                    <input type="number" name="weightInKg" value={exercise.weightInKg}
                                           onChange={handleChange}/>
                                </div>

                                <div className="form-group">
                                    <label>Target Muscle:</label>
                                    <input type="text" name="targetMuscle" value={exercise.targetMuscle}
                                           onChange={handleChange}/>
                                </div>

                                <div className="form-group">
                                    <label>Equipment required:</label>
                                    <input type="text" name="equipmentRequired" value={exercise.equipmentRequired}
                                           onChange={handleChange}/>
                                </div>
                            </>
                        )}

                        {selectedExerciseType === 'BodyWeight Exercise' && (
                            <>
                                <div className="form-group">
                                    <label>Sets:</label>
                                    <input type="number" name="sets" value={exercise.sets} onChange={handleChange}/>
                                </div>

                                <div className="form-group">
                                    <label>Reps:</label>
                                    <input type="number" name="reps" value={exercise.reps} onChange={handleChange}/>
                                </div>

                                <div className="form-group">
                                    <label>Target Muscle:</label>
                                    <input type="text" name="targetMuscle" value={exercise.targetMuscle}
                                           onChange={handleChange}/>
                                </div>
                            </>
                        )}

                        {selectedExerciseType === 'Distance Cardio Exercise' && (
                            <div className="form-group">
                                <label>Distance (km):</label>
                                <input type="number" name="distanceInKm" value={exercise.distanceInKm}
                                       onChange={handleChange}/>
                            </div>
                        )}

                        {/* No extra fields for 'No Distance Cardio Exercise' */}

                        <div className="form-group">
                            <label>Description:</label>
                            <input type="text" name="description" value={exercise.description} onChange={handleChange}/>
                        </div>

                        <button type="submit">Add Exercise</button>
                    </>
                )}
            </form>
        </div>
    );
};

export default ExerciseListInput;