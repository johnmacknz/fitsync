import { Link } from 'react-router-dom';
import logo from '../../assets/fitsync-high-resolution-logo-transparent.png';
import backbutton from '../../assets/back_icon.png'

const LoginNavbar = () => {

    return (
        <div className="ft__loginnavbar">
            <div className="ft__loginnavbar-back">
                <Link to="/">
                    <button type="button" className="back-button">
                        <img src={backbutton} alt="backbutton" className="back-icon" />
                        <span>Back</span>
                    </button>
                </Link>
            </div>
            <div className="ft__loginnavbar-links_logo">
                <img src={logo} alt="FitSync Logo" />
            </div>
            <div className="ft__loginnavbar-sign">
                <Link to="/login">
                    <button type="button">Log In</button>
                </Link>
            </div>
        </div>
    );
};

export default LoginNavbar;
