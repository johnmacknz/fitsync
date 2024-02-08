import './login.css';
import {LoginNavbar} from "../../components";
import {LoginInput} from "../../containers";



const Login = () => {

    return (
        <div className="ft__login__container">
            <LoginNavbar />
            <LoginInput />
        </div>
    );
};

export default Login;

