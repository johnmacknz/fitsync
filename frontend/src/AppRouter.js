import React, {createContext, useState} from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import App from './App';
import SignUp from './pages/signup/SignUp';
import Login from './pages/login/Login';
import MealList from "./pages/meallist/MealList";
import PersonalBestPage from "./pages/pbpage/PersonalBestPage";
import Dashboard from "./pages/dashboard/Dashboard"
import MealDetails from "./pages/mealdetails/MealDetails";
import HealthStatisticsList from "./pages/healthstats/HealthStatisticsList";
import ExerciseList from "./pages/exerciselist/ExerciseList";
import AccountPage from "./pages/account/AccountPage";
import { Navigate } from 'react-router-dom';

const UserContext = createContext();
const AppRouter = () => {

    const [userId, setUserId] = useState(null);
    const updateUserId = (newUserId) => {
        setUserId(newUserId);
    }

    const checkForUserId = () => {
        const allowedRoutes = ['/', '/login', '/signup'];
      if (userId === null && !allowedRoutes.includes(window.location.pathname)) {
          return <Navigate to = "/login" />;
      }
      return null;
    }

    return (
        <UserContext.Provider value={{ userId, updateUserId }}>
            <Router>
                {checkForUserId()}
                <Routes>
                    <Route path="/" element={<App/>}/>
                    <Route path="/signup" element={<SignUp/>}/>
                    <Route path="/login" element={<Login/>}/>
                    <Route path="/meals" element={<MealList/>}/>
                    <Route path="/exercises" element={<ExerciseList />} />
                    <Route path="/pb" element={<PersonalBestPage/>}/>
                    <Route path="/dashboard" element={<Dashboard/>}/>
                    <Route exact path="/meals/:mealId" element={<MealDetails/>}/>
                    <Route path="/stats" element={<HealthStatisticsList/>}/>
                    <Route path="/account" element={<AccountPage/>}/>
                </Routes>
            </Router>
        </UserContext.Provider>
    )
};

export default AppRouter;
export const useUserId = () => React.useContext(UserContext);
