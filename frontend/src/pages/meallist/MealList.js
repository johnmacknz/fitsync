import React, { useState, useEffect } from 'react';
import './MealList.css';
import UserNavbar from "../../components/usernavbar/UserNavbar";
import MealTab from "../../containers/mealTab/MealTab";
import { Link } from "react-router-dom";

const MealList = () => {
    const [meals, setMeals] = useState([]);
    const [loading, setLoading] = useState(true); // State to track loading status

    useEffect(() => {
        const fetchMeals = () => {
            fetch('http://localhost:8080/meals')
                .then(response => response.json())
                .then(data => {
                    setMeals(data);
                    setLoading(false); // Set loading to false once meals are fetched
                })
                .catch(error => {
                    console.error('Error fetching meals:', error);
                    setLoading(false); // Set loading to false in case of error
                });
        };

        fetchMeals();
    }, []);

    return (
        <div className="ft__login__container">
            <UserNavbar />
            <div className="tabs-container">
                {loading ? (
                    <div className="loading">
                        Loading...
                    </div>
                ) : (
                    meals.map((meal) => (
                        <Link key={meal.id} to={`/meals/${meal.id}`}>
                            <MealTab meal={meal} />
                        </Link>
                    ))
                )}
            </div>
        </div>
    );
};

export default MealList;


