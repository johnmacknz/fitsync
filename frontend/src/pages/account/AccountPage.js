import UserNavbar from "../../components/usernavbar/UserNavbar";
import React, { useState, useEffect } from 'react';
import {useUserId} from "../../AppRouter";

const AccountPage = () => {
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

    if (loading) {
        return <div>Loading...</div>;
    }

    if (!personDetails) {
        return <div>No data available</div>;
    }

    return (
        <div className="ft__login__container">
            <UserNavbar />
            <div>
                <h2>Person Details</h2>
                <pre>{JSON.stringify(personDetails, null, 2)}</pre>
            </div>
        </div>
    );
}
export default AccountPage;