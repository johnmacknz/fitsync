import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { RiMenu3Line, RiCloseLine } from 'react-icons/ri';
import logo from '../../assets/fitsync-high-resolution-logo-transparent.png';
import './navbar.css';

const Navbar = () => {
    const [toggleMenu, setToggleMenu] = useState(false);

    const closeMenu = () => setToggleMenu(false);
    const toggleMenuHandler = () => setToggleMenu(!toggleMenu);

    return (
        <div className="ft__navbar">
            <div className="ft__navbar-links">
                <div className="ft__navbar-links_logo">
                    <img src={logo} alt="FitSync Logo" />
                </div>
                <div className="ft__navbar-links_container">
                    <Link to="/about-us" onClick={closeMenu}>About Us</Link>
                    <Link to="/features" onClick={closeMenu}>Features</Link>
                    <Link to="/pricing" onClick={closeMenu}>Pricing</Link>
                    <Link to="/store" onClick={closeMenu}>Store</Link>
                </div>
            </div>
            <div className="ft__navbar-sign">
                <Link to="/login" onClick={closeMenu}>Log In</Link>
                <Link to="/signup">
                    <button type="button">Sign up</button>
                </Link>
            </div>
            <div className="ft__navbar-menu">
                {toggleMenu
                    ? <RiCloseLine color="#fff" size={27} onClick={closeMenu} />
                    : <RiMenu3Line color="#fff" size={27} onClick={toggleMenuHandler} />}
                {toggleMenu && (
                    <div className="ft__navbar-menu_container scale-up-center">
                        <div className="ft__navbar-menu_container-links">
                            <Link to="/about-us" onClick={closeMenu}>About Us</Link>
                            <Link to="/features" onClick={closeMenu}>Features</Link>
                            <Link to="/pricing" onClick={closeMenu}>Pricing</Link>
                            <Link to="/store" onClick={closeMenu}>Store</Link>
                        </div>
                        <div className="ft__navbar-menu_container-links-sign">
                            <p>Sign in</p>
                            <Link to="/signup">
                                <button type="button">Sign up</button>
                            </Link>
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
};

export default Navbar;

