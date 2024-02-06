import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import App from './App';
import SignUp from './pages/signup/SignUp';
import Login from './pages/login/Login';
import MealList from "./pages/meallist/MealList";
import Dashboard from "./pages/dashboard/Dashboard"
import MealDetails from "./pages/mealdetails/MealDetails";
import HealthStatisticsList from "./pages/healthstats/HealthStatisticsList";
import ExerciseList from "./pages/exerciselist/ExerciseList";

const AppRouter = () => (
    <Router>
        <Routes>
            <Route path="/" element={<App />} />
            <Route path="/signup" element={<SignUp />} />
            <Route path="/login" element={<Login />} />
            <Route path="/meals" element={<MealList />} />
            <Route path="/exercises" element={<ExerciseList />} />
            <Route path="/dashboard" element={<Dashboard />} />
            <Route exact path="/meals/:mealId" element={<MealDetails />} />
            <Route path="/stats/{id}" element={<HealthStatisticsList />} />
        </Routes>
    </Router>
);

export default AppRouter;
