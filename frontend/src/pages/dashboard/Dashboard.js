import React, {useEffect, useState} from 'react';
import UserNavbar from "../../components/usernavbar/UserNavbar";
import {Bar, BarChart, Label, Legend, Line, LineChart, Rectangle, Tooltip, XAxis, YAxis} from 'recharts';
import {useUserId} from "../../AppRouter";
import "./dashboard.css"
import moment from 'moment';

const Dashboard = () => {
    const [healthStatistics, setHealthStatistics] = useState([]);
    const {userId} = useUserId();
    const [exerciseData, setExerciseData] = useState([]);

    useEffect(() => {

        // Fetch exercise data
        fetch(`http://localhost:8080/exercises/person/${userId}`)
            .then(response => response.json())
            .then(data => setExerciseData(data))
            .catch(error => console.error('Error fetching exercises:', error));


        // Fetch all health statistics
        fetch(`http://localhost:8080/stats/person/${userId}`)
            .then(response => response.json())
            .then(data => setHealthStatistics(data))
            .catch(error => console.error('Error fetching health statistics:', error));
    }, []); // The empty dependency array ensures the effect runs only once on mount

    // Prepare data for the line chart
    const statsChartData = healthStatistics.map(statistic => ({
        healthDate: moment(statistic.healthDate).format('MMM/DD'),
        heartRate: statistic.heartRate,
        hydration: statistic.hydration,
        stress: statistic.stress,
        bloodPressure: statistic.bloodPressure,

    }));
    const excerciseChartData = exerciseData.map(statistic => ({
        weightInKg: statistic.weightInKg,
        caloriesBurned: statistic.caloriesBurned,
        distanceInKm: statistic.distanceInKm,
        id: statistic.id,
    }));



    return (
        <div className="ft__login__container">
            <UserNavbar/>
            <div className="ft__dashboard_container">
                <div className="chart">
                    <h2 className="form-header">Heart Rate Graph</h2>
                    {statsChartData.length > 0 ? (
                    <LineChart classname="ft__dashboard_linechart" width={600} height={300} data={statsChartData}
                               margin={{top: 20, right: 30, left: 20, bottom: 10}}>
                        <Rectangle width="100%" height="100%" fill="#acf73e" stroke="#ccc" strokeWidth={1}/>
                        <XAxis dataKey="healthDate">
                            <Label value="Date" position="insideBottom" offset={-5} />
                        </XAxis>
                        <YAxis>
                            <Label value="Heart Rate(pulse)" angle={-90} position="insideLeft" />
                        </YAxis>
                        <Tooltip />
                        <Legend layout="vertical" verticalAlign="top" align="right"/>
                        <Line type="monotone" dataKey="heartRate" stroke="#8884d8" />
                    </LineChart>
                    ) : (
                    <p className="text-error">***************No data available for Heart Rate Graph****************</p>
                    )}
                </div>
                <div className="chart">
                    <h2 className="form-header">Weight vs Calorie Burned</h2>
                    {exerciseData.length > 0 ? (
                    <LineChart width={600} height={300} data={excerciseChartData}
                               margin={{top: 20, right: 30, left: 20, bottom: 10}}>
                        <Rectangle width="100%" height="100%" fill="#acf73e" stroke="#ccc" strokeWidth={1}/>
                        <XAxis dataKey="weightInKg">
                            <Label value="Weight in KG" position="insideBottom" offset={-5}/>
                        </XAxis>
                        <YAxis>
                            <Label value="Calories Burned" angle={-90} position="insideLeft"/>
                        </YAxis>
                        <Tooltip/>
                        <Legend layout="vertical" verticalAlign="top" align="right"/>
                        <Line type="monotone" dataKey="caloriesBurned" stroke="#8884d8"/>
                    </LineChart>
                    ) : (
                    <p className="text-error">********No data available for Weight vs Calorie Burned Graph*********</p>
                    )}
                </div>
                <div className="chart">
                    <h2 className="form-header">Distance (Km)</h2>
                    {excerciseChartData.length > 0 ? (
                    <BarChart width={600} height={300} data={excerciseChartData}
                              margin={{top: 20, right: 30, left: 20, bottom: 5}}>
                        <Rectangle width="100%" height="100%" fill="#acf73e" stroke="#ccc" strokeWidth={1}/>
                        <XAxis dataKey="id">
                            <Label value="Records" position="insideBottom" offset={-5}/>
                        </XAxis>
                        <YAxis>
                            <Label value="Distance in Km" angle={-90} position="insideLeft"/>
                        </YAxis>
                        <Tooltip/>
                        <Legend layout="vertical" verticalAlign="top" align="right"/>
                        <Bar dataKey="distanceInKm" fill="#8884d8"/>
                    </BarChart>
                    ) : (
                    <p className="text-error">***************No data available for Distance (Km) Graph*************</p>
                    )}
                </div>
                <div className="chart">
                    <h2 className="form-header">Hydration Graph</h2>
                    {statsChartData.length > 0 ? (
                    <LineChart width={600} height={300} data={statsChartData}
                               margin={{top: 20, right: 30, left: 20, bottom: 5}}>
                        <Rectangle width="100%" height="100%" fill="#acf73e" stroke="#ccc" strokeWidth={1}/>
                        <XAxis dataKey="healthDate">
                            <Label value="Date" position="insideBottom" offset={-5}/>
                        </XAxis>
                        <YAxis>
                            <Label value="Hydration" angle={-90} position="insideLeft"/>
                        </YAxis>
                        <Tooltip/>
                        <Legend layout="vertical" verticalAlign="top" align="right"/>
                        <Line type="monotone" dataKey="hydration" stroke="#8884d8"/>
                    </LineChart>
                    ) : (
                    <p className="text-error">***************No data available for Hydration Graph*****************</p>
                    )}
                </div>
                <div className="chart">
                    <h2 className="form-header">Stress Graph</h2>
                    {statsChartData.length > 0 ? (
                    <LineChart width={600} height={300} data={statsChartData}
                               margin={{top: 20, right: 30, left: 20, bottom: 5}}>
                        <Rectangle width="100%" height="100%" fill="#acf73e" stroke="#ccc" strokeWidth={1}/>
                        <XAxis dataKey="healthDate">
                            <Label value="Date" position="insideBottom" offset={-5}/>
                        </XAxis>
                        <YAxis>
                            <Label value="Stress" angle={-90} position="insideLeft"/>
                        </YAxis>
                        <Tooltip/>
                        <Legend layout="vertical" verticalAlign="top" align="right"/>
                        <Line type="monotone" dataKey="stress" stroke="#8884d8"/>
                    </LineChart>
                    ) : (
                    <p className="text-error">***************No data available for Stress Graph********************</p>
                    )}
                </div>
                <div className="chart">
                    <h2 className="form-header">Blood Pressure(Mean Arterial) Graph</h2>
                    {statsChartData.length > 0 ? (
                    <LineChart width={600} height={300} data={statsChartData}
                               margin={{top: 20, right: 30, left: 20, bottom: 5}}>
                        <Rectangle width="100%" height="100%" fill="#acf73e" stroke="#ccc" strokeWidth={1}/>
                        <XAxis dataKey="healthDate">
                            <Label value="Date" position="insideBottom" offset={-5}/>
                        </XAxis>
                        <YAxis>
                            <Label value="Blood Pressure" angle={-90} position="insideLeft"/>
                        </YAxis>
                        <Tooltip/>
                        <Legend layout="vertical" verticalAlign="top" align="right"/>
                        <Line type="monotone" dataKey="bloodPressure" stroke="#8884d8"/>
                    </LineChart>
                    ) : (
                    <p className="text-error">******No data available for Blood Pressure(Mean Arterial) Graph******</p>
                    )}
                </div>
            </div>
        </div>
    );
};

export default Dashboard;