import React, {useState} from 'react';
import people from '../../assets/people.png';
import './header.css';

const Header = () => {
    const [email, setEmail] = useState('');

    const handleGetStartedClick = () => {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (email.trim() === '') {
            alert('Please enter your email address.');
        } else if (!emailRegex.test(email)) {
            alert('Please enter a valid email address.');
        } else {
            window.location.href = '/signup';
        }
    };


    return (
        <div className="ft__header section__padding" id="home">
            <div className="ft__header-content">
                <h1 className="gradient__text">Take Control Of Your Health</h1>
                <p>Welcome to a transformative journey towards a healthier you! Our fitness tracker is more than just a
                    tool;
                    it's your personal guide to wellness. Take control of your health with precision and purpose.
                    Whether you're a fitness enthusiast or just beginning your journey,
                    our intuitive platform empowers you to set and achieve your health goals.</p>

                <div className="ft__header-content__input">
                    <input
                        type="email"
                        placeholder="Your Email Address"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <button type="button" onClick={handleGetStartedClick}>
                        Get Started
                    </button>
                </div>

                <div className="ft__header-content__people">
                    <img src={people} alt="people"/>
                    <p>1,600 people requested access a visit in last 24 hours</p>
                </div>
            </div>
        </div>
    );
};
export default Header;