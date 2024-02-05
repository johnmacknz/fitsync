import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import App from './App';
import SignUp from './pages/signup/SignUp';
import Login from './pages/login/Login';
import MealList from "./pages/meallist/MealList";

const AppRouter = () => (
    <Router>
        <Routes>
            <Route path="/" element={<App />} />
            <Route path="/signup" element={<SignUp />} />
            <Route path="/login" element={<Login />} />
            <Route path="/meals" element={<MealList />} />
        </Routes>
    </Router>
);

export default AppRouter;
