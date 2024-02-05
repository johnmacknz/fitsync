import './App.css';
import {Brand, Navbar} from "./components";
import {Footer, Header} from "./containers";
import ExerciseList from "./pages/exerciselist/ExerciseList";

function App() {
  return (
    <div className="App">
        <div className="gradient__bg">
            <Navbar />
            <Header />
        </div>
        <ExerciseList/>
        <Brand />
        <Footer />
    </div>
  );
}

export default App;
