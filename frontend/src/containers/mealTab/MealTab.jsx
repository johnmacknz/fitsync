import React from 'react';
import './mealtab.css';

const MealTab = ({ meal }) => {
    return (
        <div className= "ft__mealtab_container">
            <div className= "ft__mealtab_text">
            <h2>{meal.mealName}</h2>
            <p>Calories: {meal.calories}</p>
            <p>Type: {meal.mealType}</p>
            <p>Cooking Instructions: {meal.cookingInstructions}</p>
            </div>
        </div>
    );
};

export default MealTab;