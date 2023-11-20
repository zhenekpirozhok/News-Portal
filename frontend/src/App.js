import "./App.css";
import HomePage from "./pages/HomePage";
import CategoriesPage from "./pages/CategoriesPage";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/categories" element={<CategoriesPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
