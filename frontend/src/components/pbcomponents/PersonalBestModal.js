import React from 'react';
import ExerciseFetcher from "../../apis/pbapis/ExerciseFetcher";

const PersonalBestModal = ({
                               modalVisible,
                               metric,
                               userId,
                               exerciseName,
                               setExerciseData,
                               setModalVisible,
                               handleMetricChange,
                               handleExerciseNameChange,
                               closeModal
                           }) => {
    return (
        modalVisible && (
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
                    <label htmlFor="exerciseName">Exercise Name (optional):</label>
                    <input type="text" id="exerciseName" name="exerciseName" value={exerciseName} onChange={handleExerciseNameChange} />
                    <br />
                    <ExerciseFetcher
                        metric={metric}
                        userId={userId}
                        exerciseName={exerciseName}
                        setExerciseData={setExerciseData}
                        setModalVisible={setModalVisible}
                    />
                </div>
            </div>
        )
    );
};

export default PersonalBestModal;