import React, {useState} from 'react';
import './ExerciseList.css';

const ExerciseForm = ({onAddExercise}) => {
    const [exercise, setExercise] = useState({
        exerciseName: '',
        personId: 0,
        exerciseType: '',
        equipmentRequired: '',
        startTime: '',
        endTime: '',
        caloriesBurned: 0,
        sets: 0,
        reps: 0,
        distance: 0,
        weight: 0,
        description: ''
    });

    const handleChange = (e) => {
        setExercise({
            ...exercise,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        onAddExercise(exercise);
    };

    return (
        <form onSubmit={handleSubmit}>
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
                <input type="text" name="exerciseType" value={exercise.exerciseType} onChange={handleChange}/>
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
                <input type="number" name="distance" value={exercise.distance} onChange={handleChange}/>
            </div>

            <div className="form-group">
                <label>Weight (kg):</label>
                <input type="number" name="weight" value={exercise.weight} onChange={handleChange}/>
            </div>

            <div className="form-group">
                <label>Description:</label>
                <input type="text" name="description" value={exercise.description} onChange={handleChange}/>
            </div>

            <button type="submit">Add Exercise</button>
        </form>
    );
};

export default ExerciseForm;