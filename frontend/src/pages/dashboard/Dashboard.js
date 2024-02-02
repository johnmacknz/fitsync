import {Navbar} from "../../components";
import {Footer} from "../../containers";

function Dashboard() {
    return (
        <div className="Dashboard">
            <div className="gradient__bg">
                <Navbar />
            </div>
            <Footer />
        </div>
    );
}

export default Dashboard;