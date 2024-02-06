import axios from "axios";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";


const Logic = () => {
    const {mealId} = useParams();
    const [meal, setMeal] = useState(null);

    useEffect(() => {
        const fetchMealDetails = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/meals/${mealId}`);
                setMeal(response.data);
            } catch (error) {
                console.error('Error fetching meal details:', error);
            }
        };

        fetchMealDetails();
    }, [mealId]);

    if (!meal) {
        return <div>Loading...</div>;
    }

    return (
        <div className="meal-details">
            <div>
                <h2>{meal["mealName"]}</h2>
                <p>{meal["mealType"]}</p>
                <img src={`data:image/jpeg;base64,${meal["mealImage"]}`} alt="Meal" />
            </div>
        </div>
    );
}

export default Logic;