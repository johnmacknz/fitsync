import { useNavigate } from 'react-router-dom';
import {useUserId} from "../../AppRouter";

const HandleLoginLogic = ({ email, password, setErrorResponse }) => {
    const navigate = useNavigate();
    const { updateUserId } = useUserId();

    const handleLogin = async () => {
        try {
            const response = await fetch('http://localhost:8080/person/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ email, password }),
            });

            if (response.ok) {
                const userId = await response.text();
                updateUserId(userId);
                console.log(`Authentication successful - signed in as user ${userId}`);
                navigate('/dashboard');
            } else if (response.status === 401) {
                console.log("Invalid credentials");
                setErrorResponse("Incorrect email or password")
            } else {
                console.log("Internal error")
            }
        } catch (error) {
            console.error('Error during login:', error);
        }
    };

    return (
        <button type="button" onClick={handleLogin}>
            Login
        </button>
    );
};

export default HandleLoginLogic;