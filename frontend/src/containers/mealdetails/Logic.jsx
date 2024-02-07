import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import "./logic.css"

const Logic = () => {
    const { mealId } = useParams();
    const [meal, setMeal] = useState(null);
    const [ingredients, setIngredients] = useState(null); // Separate state for ingredients

    useEffect(() => {
        const fetchMealDetails = async () => {
            try {
                const mealResponse = await axios.get(`http://localhost:8080/meals/${mealId}`);
                setMeal(mealResponse.data);
                const ingredientsResponse = await axios.get(`http://localhost:8080/meals/${mealId}/ingredients`);
                setIngredients(ingredientsResponse.data);
            } catch (error) {
                console.error('Error fetching meal details:', error);
            }
        };

        fetchMealDetails();
    }, [mealId]);

    if (!meal || !ingredients) { // Check if either meal or ingredients is null
        return <div>Loading...</div>;
    }

    return (
        <div className="ft__logic_container">
            <div className="ft__logic_header">
                <div className="ft__logic_title">
                    <h2>{meal["mealName"]}</h2>
                    <p>{meal["mealType"]}</p>
                </div>
                <div className="ft__logic_image">
                    <img src={`data:image/jpeg;base64,${meal["mealImage"]}`} alt="Meal" />
                </div>
            </div>
            <div className="ft__logic_details">
                <div className="ingredients">
                    <h3>Ingredients:</h3>
                    <ul>
                        {ingredients.map((ingredient) => (
                            <li key={ingredient.id}>{ingredient["ingredientName"]}</li>
                        ))}
                    </ul>
                </div>
                <div className="ft__logic_cooking">
                    <h3>Cooking Instructions:</h3>
                    <p>{meal["cookingInstructions"]}</p>
                </div>
            </div>
        </div>

    );
}

export default Logic;
