import React from 'react';

const ExerciseFetcher = ({ metric, userId, exerciseName, setExerciseData, setModalVisible }) => {
    const fetchAndDisplayExercises = () => {
        let endpoint = `http://localhost:8080/exercises/pb/${metric}/${userId}`;

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

    return (
        <button id="fetchExercisesButton" onClick={fetchAndDisplayExercises}>Ok</button>
    );
};

export default ExerciseFetcher;