import "./App.css";
import HomePage from "./pages/HomePage";
import CategoriesPage from "./pages/CategoriesPage";
import OneCategoryPage from "./pages/OneCategoryPage";
import FilterPage from "./pages/FilterPage";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/categories" element={<CategoriesPage />} />
          <Route path="/category/:categoryId" element={<OneCategoryPage />} />
          <Route path="/filter" element={<FilterPage />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
