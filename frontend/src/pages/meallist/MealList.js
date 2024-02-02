import React, { useState, useEffect } from 'react';

import './MealList.css';

const MealList = () => {
    const [meals, setMeals] = useState([]);
    const [darkMode, setDarkMode] = useState(false);

    useEffect(() => {
        const fetchMeals = () => {
            fetch('http://localhost:8080/meals')
                .then(response => response.json())
                .then(data => setMeals(data))
                .catch(error => console.error('Error fetching meals:', error));
        };

        fetchMeals();
    }, []);

    useEffect(() => {
        const body = document.body;
        body.classList.toggle('dark-mode', darkMode);
    }, [darkMode]);

    const toggleDarkMode = () => {
        setDarkMode(prevMode => !prevMode);
    };

    return (
    <>
                <div>
                    <div className="mode-toggle">
                        <input
                            type="checkbox"
                            id="darkModeToggle"
                            checked={darkMode}
                            onChange={toggleDarkMode}
                        />
                        <label htmlFor="darkModeToggle" className="slider"></label>
                        <span className="mode-label">
                    {darkMode ? 'Dark Mode' : 'Light Mode'}
                </span>
                    </div>
                    <h2>All Meals</h2>
                    <table>
                        <thead>
                        <tr>
                            <th>Meal Name</th>
                            <th>Calories</th>
                            <th>Meal Type</th>
                            <th>Cooking Instructions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {meals.map((meal) => (
                            <tr key={meal.id}>
                                <td>{meal.mealName}</td>
                                <td>{meal.calories}</td>
                                <td>{meal.mealType}</td>
                                <td>{meal.cookingInstructions}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
    </>
    );
};

export default MealList;


