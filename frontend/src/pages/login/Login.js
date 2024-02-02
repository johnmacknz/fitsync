import React, { useState } from 'react';
import './login.css';
import '../../App.css';


const Login = () => {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = () => {
        console.log('Logging in with:', email, password);

        setEmail('');
        setPassword('');
    };

    return (
        <div className="ft__login__wrapper">
                <form>
                    <div className="ft__login__input">
                        <input
                            type="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            placeholder="Email"
                        />
                        <div className="underline"></div>
                    </div>
                    <br />
                    <div className="ft__login__input">
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            placeholder="Password"
                        />
                        <div className="underline"></div>
                    </div>
                    <br />
                    <button type="button" onClick={handleLogin}>
                        Login
                    </button>
                </form>
        </div>
    );
};

export default Login;

