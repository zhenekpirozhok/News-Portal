import './App.css';
import HomePage from './pages/HomePage';
import CategoriesPage from './pages/CategoriesPage';
import { BrowserRouter as Router } from 'react-router-dom';

function App() {
  return (
    <Router>
    <div className="App">
      <HomePage />
    </div>
    </Router>
  );
}

export default App;
