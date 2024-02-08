import React from 'react';
import moment from 'moment';

const PersonalBestTable = ({ exerciseData, openModal }) => {
    return (
        <div id="exerciseListContainer">
            <h2>Personal Bests</h2>
            <table id="exerciseList" border="1">
                <thead>
                <tr>
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
                </tr>
                </thead>
                <tbody className="ft__personalbestpage_text">
                {exerciseData.map(exercise => (
                    <tr key={exercise.id}>
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
                    </tr>
                ))}
                </tbody>
            </table>
            <button id="findPersonalBestButton" onClick={openModal}>Find Personal Best</button>
        </div>
    );
};

export default PersonalBestTable;