import "./App.css";
import HomePage from "./pages/HomePage";
import CategoriesPage from "./pages/CategoriesPage";
import SearchPage from "./pages/SearchPage"
import OneCategoryPage from "./pages/OneCategoryPage";
import FilterPage from "./pages/FilterPage";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import OneNewsPage from "./pages/OneNewsPage";
import AdminPage from "./pages/AdminPage";
import store from "./redux/store";
import { Provider } from "react-redux";
import RegisterForm from "./components/RegisterForm/RegisterForm";
import SignInForm from "./components/SignInForm/SignInForm";
import SignInAdmin from "./components/SignInAdmin/SignInAdmin";

function App() {
  return (
    <Provider store={store}>
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/categories" element={<CategoriesPage />} />
          <Route path="/news/:newsId" element={<OneNewsPage />} />
          <Route path="/category/:categoryId" element={<OneCategoryPage />} />
          <Route path="/search" element={<SearchPage />}/>
          <Route path="/news" element={<FilterPage />} />
          <Route path="/login" element={<SignInForm />}/>
          <Route path="/admin" element={<AdminPage />}/>
          <Route path="/signInAdmin" element={<SignInAdmin />}/>
          <Route path="/register" element={<RegisterForm />}/>
        </Routes>
      </Router>
    </div>
    </Provider>
  );
}

export default App;
