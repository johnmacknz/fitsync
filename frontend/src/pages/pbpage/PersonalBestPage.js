import React, { useState } from 'react';
import moment from 'moment';
import UserNavbar from "../../components/usernavbar/UserNavbar";
import './personalbestpage.css';

const PersonalBestPage = () => {
    const [modalVisible, setModalVisible] = useState(false);
    const [metric, setMetric] = useState('weight');
    const [personId, setPersonId] = useState('');
    const [exerciseName, setExerciseName] = useState('');
    const [exerciseData, setExerciseData] = useState([]);

    const formatDuration = (duration) => {
        const hours = duration.hours();
        const minutes = duration.minutes();
        const seconds = duration.seconds();

        return `${hours}h ${minutes}m ${seconds}s`;
    };

    const fetchAndDisplayExercises = () => {
        let endpoint = `http://localhost:8080/exercises/pb/${metric}/${personId}`;

        if (exerciseName) {
            endpoint += `/${exerciseName}`;
        }

        fetch(endpoint)
            .then(response => response.json())
            .then(data => {
                setExerciseData(data);
                setModalVisible(false);
            })
            .catch(error => console.error('Error fetching exercises:', error));
    };

    const openModal = () => {
        setModalVisible(true);
    };

    const closeModal = () => {
        setModalVisible(false);
    };

    const handleMetricChange = (event) => {
        setMetric(event.target.value);
    };

    const handlePersonIdChange = (event) => {
        setPersonId(event.target.value);
    };

    const handleExerciseNameChange = (event) => {
        setExerciseName(event.target.value);
    };

    return (
        <div className="ft__login__container">
            <UserNavbar />
            <div id="exerciseListContainer">
                <h2>Personal Bests</h2>
                <table id="exerciseList" border="1">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Exercise Name</th>
                        <th>Equipment Required</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                        <th>Calories Burned</th>
                        <th>Weight (kg)</th>
                        <th>Distance (km)</th>
                        <th>Sets</th>
                        <th>Reps</th>
                        <th>Description</th>
                        <th>Person ID</th>
                    </tr>
                    </thead>
                    <tbody>
                    {exerciseData.map(exercise => (
                        <tr key={exercise.id}>
                            <td>{exercise.id}</td>
                            <td>{exercise.exerciseName}</td>
                            <td>{exercise.equipmentRequired}</td>
                            <td>{moment(exercise.startTime).format('YYYY-MM-DD HH:mm')}</td>
                            <td>{moment(exercise.endTime).format('YYYY-MM-DD HH:mm')}</td>
                            <td>{exercise.caloriesBurned}</td>
                            <td>{exercise.weightInKg || '-'}</td>
                            <td>{exercise.distanceInKm || '-'}</td>
                            <td>{exercise.sets || '-'}</td>
                            <td>{exercise.reps || '-'}</td>
                            <td>{exercise.description}</td>
                            <td>{exercise.personId}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
                <button id="findPersonalBestButton" onClick={openModal}>Find Personal Best</button>
            </div>

            {modalVisible && (
                <div id="personalBestModal" className="modal">
                    <div className="modal-content">
                        <span className="close" onClick={closeModal}>&times;</span>
                        <label htmlFor="metric">Metric:</label>
                        <select id="metric" name="metric" value={metric} onChange={handleMetricChange} required>
                            <option value="weight">Weight</option>
                            <option value="duration">Duration</option>
                            <option value="distance">Distance</option>
                            <option value="sets">Sets</option>
                            <option value="reps">Reps</option>
                        </select>
                        <br />
                        <label htmlFor="personId">Person ID:</label>
                        <input type="number" id="personId" name="personId" value={personId} onChange={handlePersonIdChange} required />
                        <br />
                        <label htmlFor="exerciseName">Exercise Name (optional):</label>
                        <input type="text" id="exerciseName" name="exerciseName" value={exerciseName} onChange={handleExerciseNameChange} />
                        <br />
                        <button id="fetchExercisesButton" onClick={fetchAndDisplayExercises}>Fetch Exercises</button>
                    </div>
                </div>
            )}
        </div>
    );
};

export default PersonalBestPage;