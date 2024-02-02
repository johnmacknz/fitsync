import React from 'react';
import { garmin, strava, myfitnesspal, wahoo, zwift } from './imports';
import './brand.css';

const Brand = () => (
    <div className="gpt3__brand section__padding">
        <div>
            <img src={garmin} />
        </div>
        <div>
            <img src={strava} />
        </div>
        <div>
            <img src={myfitnesspal} />
        </div>
        <div>
            <img src={wahoo} />
        </div>
        <div>
            <img src={zwift} />
        </div>
    </div>
);

export default Brand;