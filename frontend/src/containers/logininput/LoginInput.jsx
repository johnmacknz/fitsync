import React, { useState } from 'react';
import LoginButtonLogic from "./LoginButtonLogic";

const LoginInput = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    return (
        <div>
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
                    <div className="ft__login__options">
                        <div className="ft__login__remember">
                            <input type="checkbox" name="lsRememberMe" />
                            <label>Remember me</label>
                        </div>
                        <LoginButtonLogic email={email} password={password} />
                    </div>
                </form>
            </div>
        </div>
    );
};

export default LoginInput;