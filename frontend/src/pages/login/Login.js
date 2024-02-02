import React, { useState } from 'react';
import './login.css';
import {LoginNavbar} from "../../components";
import {LoginInput} from "../../containers";


const Login = () => {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = () => {
        console.log('Logging in with:', email, password);

        setEmail('');
        setPassword('');
    };

    return (
        <div className="ft__login__container">
            <LoginNavbar />
            <LoginInput />
        </div>
    );
};

export default Login;

