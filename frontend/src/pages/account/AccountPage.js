import UserNavbar from "../../components/usernavbar/UserNavbar";
import useFetchUserDetails from "../../apis/accountapis/useFetchUserDetails";

const AccountPage = () => {

    const { personDetails, loading } = useFetchUserDetails();

    if (loading) {
        return <div>Loading...</div>;
    }

    if (!personDetails) {
        return <div>No data available</div>;
    }

    return (
        <div className="ft__login__container">
            <UserNavbar />
            <div className="text">
                <h2>Account</h2>
                <div>User ID: {personDetails.id}</div>
                <div>Name: {personDetails.firstName} {personDetails.lastName}</div>
                <div>Email: {personDetails.email}</div>
            </div>
        </div>
    );
}
export default AccountPage;