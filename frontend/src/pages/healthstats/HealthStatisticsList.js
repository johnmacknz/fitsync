import React, { useState, useEffect } from 'react';
import './healthStatistics.css';
import UserNavbar from "../../components/usernavbar/UserNavbar";
import {useUserId} from "../../AppRouter";

const HealthStatisticList = () => {
    const [healthStatistics, setHealthStatistics] = useState([]);
    const [newData, setNewData] = useState([]);
    const { userId } = useUserId();

    useEffect(() => {
        // Fetch all health statistics
        fetch(`http://localhost:8080/stats/person/${userId}`)
            .then(response => response.json())
            .then(data => setHealthStatistics(data))
            .catch(error => console.error('Error fetching health statistics:', error));
    }, []); // The empty dependency array ensures the effect runs only once on mount

    const statisticsWithPerson = {
        ...newData,
        personId: userId,
        healthDate: new Date().toISOString().split('T')[0],
    };
    const handleInsertHealthStatistic = async () => {
        try {
            // Make a POST request to insert a health statistic
            const response = await fetch('http://localhost:8080/stats', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(statisticsWithPerson),
            });

            // Handle the API response
            if (response.ok) {
                // Update the local state or perform any other actions
                console.log('Health statistic inserted successfully');
                // Fetch health statistics again to update the list
                try {
                    const newResponse = await fetch(`http://localhost:8080/stats/person/${userId}`);
                    const newData = await newResponse.json();
                    setHealthStatistics(newData);
                } catch (error) {
                    console.error('Error fetching health statistics:', error);
                }
            } else {
// Handle insertion failure
                const errorMessage = await response.text(); // Get the error message from the response
                console.error('Health statistic insertion failed:', errorMessage);

                // Display error message as a popup
                window.alert(`Error: ${errorMessage}`);
            }
        } catch (error) {
            console.error('Error during health statistic insertion:', error);
        }
    };


    return (
        <div className="ft__login__container">
            <UserNavbar />
            <div className="ft__health_container">
            <h2 className="form-header">Health Statistics</h2>
            <form className="ft__health_tabs">
                {/*<label className="form-label">*/}
                {/*    Person ID:*/}
                {/*    <input className="value-input"*/}
                {/*           type="number"*/}
                {/*           value={newData.personId}*/}
                {/*           onChange={(e) => setNewData({ ...newData, personId: e.target.value })}*/}
                {/*    />*/}
                {/*</label >*/}
                <label className="form-label">
                    Sleep:
                    <input className="value-input"
                           type="number"
                           value={newData.sleep}
                           onChange={(e) => setNewData({ ...newData, sleep: e.target.value })}
                    />
                </label>
                <label className="form-label">
                    Weight:
                    <input className="value-input"
                           type="number"
                           value={newData.weight}
                           onChange={(e) => setNewData({ ...newData, weight: e.target.value })}
                    />
                </label>
                <label className="form-label">
                    Blood Pressure:
                    <input className="value-input"
                           type="number"
                           value={newData.bloodPressure}
                           onChange={(e) => setNewData({ ...newData, bloodPressure: e.target.value })}
                    />
                </label>
                <label className="form-label">
                    Hydration:
                    <input className="value-input"
                           type="number"
                           value={newData.hydration}
                           onChange={(e) => setNewData({ ...newData, hydration: e.target.value })}
                    />
                </label>
                <label className="form-label">
                    Calorie In:
                    <input className="value-input"
                           type="number"
                           value={newData.calorieIn}
                           onChange={(e) => setNewData({ ...newData, calorieIn: e.target.value })}
                    />
                </label>
                <label className="form-label">
                    Calorie Out:
                    <input className="value-input"
                           type="number"
                           value={newData.calorieOut}
                           onChange={(e) => setNewData({ ...newData, calorieOut: e.target.value })}
                    />
                </label>
                <label className="form-label">
                    Heart Rate:
                    <input className="value-input"
                           type="number"
                           value={newData.heartRate}
                           onChange={(e) => setNewData({ ...newData, heartRate: e.target.value })}
                    />
                </label>
                <label className="form-label">
                    Stress:
                    <input className="value-input"
                           type="number"
                           value={newData.stress}
                           onChange={(e) => setNewData({ ...newData, stress: e.target.value })}
                    />
                </label>
                <button type="button" onClick={handleInsertHealthStatistic}>
                    Insert Record
                </button>
            </form>
            <table>
                <thead>
                <tr>
                    {/*<th>ID</th>*/}
                    <th>Health Date</th>
                    <th>Sleep</th>
                    <th>Weight</th>
                    <th>Blood Pressure</th>
                    <th>Hydration</th>
                    <th>Calorie In</th>
                    <th>Calorie Out</th>
                    <th>Heart Rate</th>
                    <th>Stress</th>
                    {/*<th>Person ID</th>*/}
                </tr>
                </thead>
                <tbody>
                {healthStatistics.map(statistic => (
                    <tr key={statistic.id}>
                        {/*<td>{statistic.id}</td>*/}
                        <td>{statistic.healthDate}</td>
                        <td>{statistic.sleep}</td>
                        <td>{statistic.weight}</td>
                        <td>{statistic.bloodPressure}</td>
                        <td>{statistic.hydration}</td>
                        <td>{statistic.calorieIn}</td>
                        <td>{statistic.calorieOut}</td>
                        <td>{statistic.heartRate}</td>
                        <td>{statistic.stress}</td>
                        {/*<td>{statistic.personId}</td>*/}
                    </tr>
                ))}
                </tbody>
            </table>
            </div>
        </div>
    );
};

export default HealthStatisticList;
