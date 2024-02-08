import { useState, useEffect } from 'react';
import {useUserId} from "../../AppRouter";

const useFetchUserDetails = () => {
    const [personDetails, setPersonDetails] = useState(null);
    const [loading, setLoading] = useState(true);
    const { userId } = useUserId();

    useEffect(() => {
        const fetchData = async () => {
            console.log("User ID:", userId);
            try {
                const response = await fetch("http://localhost:8080/person/account/" + userId);
                if (!response.ok) {
                    console.log('Failed to fetch user data');
                }
                const data = await response.json();
                setPersonDetails(data);
                setLoading(false);
            } catch (error) {
                console.error('Error fetching user data:', error);
                setLoading(false);
            }
        };
        fetchData();
    }, [userId]);

    return { personDetails, loading };
};

export default useFetchUserDetails;