import React from 'react';
import SignUpInput from "../../containers/signupinput/SignUpInput";
import SignUpNavbar from "../../components/signupnavbar/SignUpNavbar";

const SignUp = () => (
        <div className="ft__login__container">
            <SignUpNavbar />
            <SignUpInput />
        </div>
);

export default SignUp;
