import React, { useState, useEffect } from 'react';
import './ExerciseList.css';

const ExerciseList = () => {
    const [exercises, setExercises] = useState([]);
    const [exercise, setExercise] = useState({
        exerciseName: '',
        personId: '',
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

    useEffect(() => {
        // Fetch existing exercises
        let apiUrl = 'http://localhost:8080/exercises';
        fetch(apiUrl)
            .then(response => response.json())
            .then(data => setExercises(data))
            .catch(error => console.error('Error fetching exercises:', error));
    }, []);

    const handleChange = (e) => {
        setExercise({
            ...exercise,
            [e.target.name]: e.target.value,
        });
    };

    const handleAddExercise = (e) => {
        e.preventDefault();

        // Perform the POST request to add the new exercise
        fetch('http://localhost:8080/exercises', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(exercise),
        })
            .then(response => response.json())
            .then(data => setExercises([...exercises, data]))
            .catch(error => console.error('Error adding exercise:', error));
    };

    return (
        <div>
            <h2>Exercise List:</h2>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Exercise Name</th>
                    <th>Person ID</th>
                    <th>Exercise Type</th>
                    <th>Target Muscle</th>
                    <th>Equipment Required</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                    <th>Calories Burned</th>
                    <th>Sets</th>
                    <th>Reps</th>
                    <th>Distance (km)</th>
                    <th>Weight (kg)</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                {exercises.map(exercise => (
                    <tr key={exercise.id}>
                        <td>{exercise.id}</td>
                        <td>{exercise.exerciseName}</td>
                        <td>{exercise.personId}</td>
                        <td>{exercise.exerciseType}</td>
                        <td>{exercise.targetMuscle}</td>
                        <td>{exercise.equipmentRequired}</td>
                        <td>{exercise.startTime}</td>
                        <td>{exercise.endTime}</td>
                        <td>{exercise.caloriesBurned}</td>
                        <td>{exercise.reps}</td>
                        <td>{exercise.sets}</td>
                        <td>{exercise.distanceInKm}</td>
                        <td>{exercise.weightInKg}</td>
                        <td>{exercise.description}</td>
                    </tr>
                ))}
                </tbody>
            </table>

            <form onSubmit={handleAddExercise}>
                <div className="form-group">
                    <label>Exercise Name:</label>
                    <input type="text" name="exerciseName" value={exercise.exerciseName} onChange={handleChange}/>
                </div>

                <div className="form-group">
                    <label>Person ID:</label>
                    <input type="number" name="personId" value={exercise.personId} onChange={handleChange}/>
                </div>

                <div className="form-group">
                    <label>Exercise Type:</label>
                    <select name="exerciseType" value={exercise.exerciseType} onChange={handleChange}>
                        <option value="">Select Exercise Type</option>
                        <option value="Isometric Exercise">Isometric</option>
                        <option value="WeightLifting Exercise">WeightLifting</option>
                        <option value="BodyWeight Exercise">BodyWeight</option>
                        <option value="Distance Cardio Exercise">Distance Cardio</option>
                        <option value="No Distance Cardio Exercise">No Distance Cardio</option>
                    </select>
                </div>

                <div className="form-group">
                    <label>Target Muscle:</label>
                    <input type="text" name="targetMuscle" value={exercise.targetMuscle} onChange={handleChange}/>
                </div>

                <div className="form-group">
                    <label>Equipment required:</label>
                    <input type="text" name="equipmentRequired" value={exercise.equipmentRequired} onChange={handleChange}/>
                </div>

                <div className="form-group">
                    <label>Start time:</label>
                    <input type="datetime-local" name="startTime" value={exercise.startTime} onChange={handleChange}/>
                </div>

                <div className="form-group">
                    <label>End time:</label>
                    <input type="datetime-local" name="endTime" value={exercise.endTime} onChange={handleChange}/>
                </div>

                <div className="form-group">
                    <label>Calories burned:</label>
                    <input type="number" name="caloriesBurned" value={exercise.caloriesBurned} onChange={handleChange}/>
                </div>

                <div className="form-group">
                    <label>Sets:</label>
                    <input type="number" name="sets" value={exercise.sets} onChange={handleChange}/>
                </div>

                <div className="form-group">
                    <label>Reps:</label>
                    <input type="number" name="reps" value={exercise.reps} onChange={handleChange}/>
                </div>

                <div className="form-group">
                    <label>Distance (km):</label>
                    <input type="number" name="distanceInKm" value={exercise.distanceInKm} onChange={handleChange}/>
                </div>

                <div className="form-group">
                    <label>Weight (kg):</label>
                    <input type="number" name="weightInKg" value={exercise.weightInKg} onChange={handleChange}/>
                </div>

                <div className="form-group">
                    <label>Description:</label>
                    <input type="text" name="description" value={exercise.description} onChange={handleChange}/>
                </div>

                <button type="submit">Add Exercise</button>
            </form>
        </div>
    );
};

export default ExerciseList;