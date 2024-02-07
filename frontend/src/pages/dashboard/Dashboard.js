import React, { useState, useEffect } from 'react';
import '../healthstats/healthStatistics.css';
import UserNavbar from "../../components/usernavbar/UserNavbar";
import { LineChart, Line, XAxis, YAxis, Tooltip, Legend, Label, Rectangle } from 'recharts';

const HealthStatisticList = () => {
    const [healthStatistics, setHealthStatistics] = useState([]);

    useEffect(() => {
        // Fetch all health statistics
        fetch('http://localhost:8080/stats')
            .then(response => response.json())
            .then(data => setHealthStatistics(data))
            .catch(error => console.error('Error fetching health statistics:', error));
    }, []); // The empty dependency array ensures the effect runs only once on mount

    // Prepare data for the line chart
    const chartData = healthStatistics.map(statistic => ({
        healthDate: statistic.healthDate,
        bloodPressure: statistic.bloodPressure,
    }));

    return (
        <div className="ft__login__container">
            <UserNavbar />
            <h2 className="form-header">Health Statistics</h2>
            <LineChart width={600} height={300} data={chartData} margin={{ top: 20, right: 30, left: 20, bottom: 5 }}>
                <Rectangle width="100%" height="100%" fill="#acf73e" stroke="#ccc" strokeWidth={1} />
                <XAxis dataKey="healthDate">
                    <Label value="Date" position="insideBottom" />
                </XAxis>
                <YAxis>
                    <Label value="Blood Pressure" angle={-90} position="insideLeft" />
                </YAxis>
                <Tooltip />
                <Legend />
                <Line type="monotone" dataKey="bloodPressure" stroke="#8884d8" />
            </LineChart>
        </div>
    );
};

export default HealthStatisticList;
