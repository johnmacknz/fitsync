import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import App from './App';
import SignUp from './pages/signup/SignUp';
import Login from './pages/login/Login';
import MealList from "./pages/meallist/MealList";
import Dashboard from "./pages/dashboard/Dashboard"
import MealDetails from "./pages/mealdetails/MealDetails";

const AppRouter = () => (
    <Router>
        <Routes>
            <Route path="/" element={<App />} />
            <Route path="/signup" element={<SignUp />} />
            <Route path="/login" element={<Login />} />
            <Route path="/meals" element={<MealList />} />
            <Route path="/dashboard" element={<Dashboard />} />
            <Route exact path="/meals/:mealId" element={<MealDetails />} />
        </Routes>
    </Router>
);

export default AppRouter;
