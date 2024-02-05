import React from 'react';
import { useNavigate } from 'react-router-dom';

const LoginButtonLogic = ({ email, password }) => {
    const navigate = useNavigate();

    const handleLogin = async () => {
        try {
            const response = fetch('http://localhost:8080/person/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ email, password }),
            }).then(response => {
                if (response.ok) {
                    console.log(response.text());
                    navigate('/dashboard');
                } else {
                    console.log(response.text());
                }
            });
        } catch (error) {
            console.error('Error during login:', error);
        }
    };

    return (
        <button type="button" onClick={handleLogin}>
            Login
        </button>
    );
};

export default LoginButtonLogic;