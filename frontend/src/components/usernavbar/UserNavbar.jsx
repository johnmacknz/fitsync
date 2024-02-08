import {Link} from 'react-router-dom';
import logo from '../../assets/fitsync-high-resolution-logo-transparent.png';
import {useUserId} from "../../AppRouter";


const UserNavbar = () => {
    const {userId} = useUserId();


    return (
        <div className="ft__navbar">
            <div className="ft__navbar-links">
                <div className="ft__navbar-links_logo">
                    <img src={logo} alt="FitSync Logo"/>
                </div>
                <div className="ft__navbar-links_container">
                    <Link to="/dashboard">Dashboard</Link>
                    <Link to="/meals">Meals</Link>
                    <Link to="/exercises">Exercise History</Link>
                    <Link to="/stats">Health</Link>
                    <Link to="/pb">Personal Bests</Link>
                </div>
            </div>

            <div className="ft__navbar-sign">
                <Link to="/login">
                    <button type="button">Log Out</button>
                </Link>
                <Link to="/account">
                <button type="button">Account</button>
                </Link>
                <div className="text">
                    <> User Name: {userId}</>
                </div>
            </div>
        </div>
    );
};

export default UserNavbar;