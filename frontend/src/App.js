import "./App.css";
import HomePage from "./pages/HomePage";
import OneNewsPage from "./pages/OneNewsPage";
import { BrowserRouter as Router } from "react-router-dom";

function App() {
  return (
    <Router>
      <div className="App">
        <OneNewsPage />
      </div>
    </Router>
  );
}

export default App;
