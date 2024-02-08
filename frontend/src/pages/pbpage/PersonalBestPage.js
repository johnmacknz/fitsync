import React, { useState } from 'react';
import UserNavbar from "../../components/usernavbar/UserNavbar";
import './personalbestpage.css';
import {useUserId} from "../../AppRouter";
import PersonalBestModal from "../../components/pbcomponents/PersonalBestModal";
import PersonalBestTable from "../../components/pbcomponents/PersonalBestTable";

const PersonalBestPage = () => {
    const [modalVisible, setModalVisible] = useState(false);
    const [metric, setMetric] = useState('weight');
    const [exerciseName, setExerciseName] = useState('');
    const [exerciseData, setExerciseData] = useState([]);
    const { userId } = useUserId();

    const openModal = () => {
        setModalVisible(true);
    };

    const closeModal = () => {
        setModalVisible(false);
    };

    const handleMetricChange = (event) => {
        setMetric(event.target.value);
    };

    const handleExerciseNameChange = (event) => {
        setExerciseName(event.target.value);
    };

    return (
        <div className="ft__login__container">
            <UserNavbar />
            <PersonalBestTable
                exerciseData={exerciseData}
                openModal={openModal}
                />
            <PersonalBestModal
                modalVisible={modalVisible}
                metric={metric}
                userId={userId}
                exerciseName={exerciseName}
                setExerciseData={setExerciseData}
                setModalVisible={setModalVisible}
                handleMetricChange={handleMetricChange}
                handleExerciseNameChange={handleExerciseNameChange}
                closeModal={closeModal}
            />
        </div>
    );
};

export default PersonalBestPage;