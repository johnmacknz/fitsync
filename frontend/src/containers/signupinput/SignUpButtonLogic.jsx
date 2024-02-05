import React from 'react';
import { useNavigate } from 'react-router-dom';

const SignUpButtonLogic = ({ firstName, lastName, email, password, reEnterPassword }) => {
    const navigate = useNavigate();

    const handleSignUp = async () => {
        try {
            const response = fetch('http://localhost:8080/person/signup', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ firstName, lastName, email, password, reEnterPassword }),
            }).then(response => {
                if (response.ok) {
                    console.log(response.text());
                    navigate('/dashboard');
                } else {
                    console.log(response.text());
                }
            });
        } catch (error) {
            console.error('Error during sign up:', error);
        }
    };

    return (
        <button type="button" onClick={handleSignUp}>
            Sign Up
        </button>
    );
}

export default SignUpButtonLogic;