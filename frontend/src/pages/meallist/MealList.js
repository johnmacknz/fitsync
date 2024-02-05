import React, { useState, useEffect } from 'react';

import './MealList.css';
import UserNavbar from "../../components/usernavbar/UserNavbar";
import MealTab from "../../containers/mealTab/MealTab";

const MealList = () => {
    const [meals, setMeals] = useState([]);

    useEffect(() => {
        const fetchMeals = () => {
            fetch('http://localhost:8080/meals')
                .then(response => response.json())
                .then(data => setMeals(data))
                .catch(error => console.error('Error fetching meals:', error));
        };

        fetchMeals();
    }, []);

    return (
                <div className="ft__login__container">
                    <UserNavbar />
                    <div className="tabs-container">
                        {meals.map((meal) => (
                            <MealTab key={meal.id} meal={meal} />
                        ))}
                    </div>
                </div>
    );
};

export default MealList;


