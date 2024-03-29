import React from 'react';
import Logo from '../../assets/fitsync-high-resolution-logo-transparent.png';
import './footer.css';

const Footer = () => (
    <div className="gpt3__footer section__padding">
        <div className="gpt3__footer-links">
            <div className="gpt3__footer-links_logo">
                <img src={Logo} alt="logo" />
                <p>Crechterwoord K12 182 DK Alknjkcb, <br /> All Rights Reserved</p>
            </div>
            <div className="gpt3__footer-links_div">
                <h4>Links</h4>
                <p>Overons</p>
                <p>Social Media</p>
                <p>Counters</p>
                <p>Contact</p>
            </div>
            <div className="gpt3__footer-links_div">
                <h4>Company</h4>
                <p>Terms & Conditions </p>
                <p>Privacy Policy</p>
                <p>Contact</p>
            </div>
            <div className="gpt3__footer-links_div">
                <h4>Get in touch</h4>
                <p>Crechterwoord K12 182 DK Alknjkcb</p>
                <p>085-132567</p>
                <p>info@payme.net</p>
            </div>
        </div>

        <div className="gpt3__footer-copyright">
            <p>@2024 FitSync. All rights reserved.</p>
        </div>
    </div>
);

export default Footer;