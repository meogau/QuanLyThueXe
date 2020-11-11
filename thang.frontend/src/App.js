import logo from './logo.svg';
import {Switch, Route} from 'react-router-dom';
import Header from './components/general/Header';
import Home from './components/Home';
import BikePark from './components/BikeParkList';
import './App.css';

function App() {
  return (
    <div className="App">
      <Home />
    </div>
  );
}

export default App;
