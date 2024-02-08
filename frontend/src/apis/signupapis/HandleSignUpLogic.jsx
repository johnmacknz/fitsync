import React from 'react';
import { useNavigate } from 'react-router-dom';
import {useUserId} from "../../AppRouter";

const HandleSignUpLogic = ({ firstName, lastName, email, password, reEnterPassword, setErrorResponse }) => {

    const navigate = useNavigate();
    const { updateUserId } = useUserId();

    const handleSignUp = async () => {
        try {
            const response = await fetch('http://localhost:8080/person/signup', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ firstName, lastName, email, password, reEnterPassword }),
            });

            if (response.ok) {
                const userId = await response.text();
                updateUserId(userId);
                console.log(`Sign up successful - signed in as user ${userId}`);
                navigate('/dashboard');
            } else if (response.status === 401) {
                const responseMsg = await response.text();
                console.log(responseMsg);
                setErrorResponse(responseMsg);
            } else {
                console.log("Internal error")
            }
        } catch (error) {
            console.error('Error during login:', error);
        }
    };

    return (
        <button type="button" onClick={handleSignUp}>
            Sign Up
        </button>
    );
}

export default HandleSignUpLogic;