import React, { useState } from 'react';

const SignUpInput = () => {

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [reEnterPassword, setReEnterPassword] = useState('');

    const handleSignUp = () => {
        console.log('Signing Up with:', firstName, email, password);

        setEmail('');
        setPassword('');
    };

    return (
        <div >
            <div className="ft__login__wrapper">
                <form>
                    <div className="ft__login__input">
                        <input
                            type="firstName"
                            value={firstName}
                            onChange={(e) => setFirstName(e.target.value)}
                            placeholder="First Name"
                        />
                        <div className="underline"></div>
                    </div>
                    <br />
                    <div className="ft__login__input">
                        <input
                            type="lastName"
                            value={lastName}
                            onChange={(e) => setLastName(e.target.value)}
                            placeholder="Last Name"
                        />
                        <div className="underline"></div>
                    </div>
                    <br />
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
                    <div className="ft__login__input">
                        <input
                            type="reEnterPassword"
                            value={reEnterPassword}
                            onChange={(e) => setReEnterPassword(e.target.value)}
                            placeholder="Re-Enter Password"
                        />
                        <div className="underline"></div>
                    </div>
                    <br />
                    <div className="ft__login__options">
                        <div className="ft__login__remember">
                            <input
                                type="checkbox"
                                name="lsRememberMe"
                            />
                            <label>Remember me</label>
                        </div>
                        <button type="button" onClick={handleSignUp} >
                            Sign Up
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default SignUpInput;