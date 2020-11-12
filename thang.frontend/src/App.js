import {Switch, Route} from 'react-router-dom';
import Home from './components/Home';
import BikePark from './components/BikeParkList';
import BikesInPark from './components/BikesInPark';
import SearchResult from './components/SearchResult';
import './App.css';

function App() {
  return (
    <div className="App">
      <Switch>     
        <Route path="/search/:key" component={SearchResult} />   
        <Route path="/bikeparks/:parkID/:parkName" component={BikesInPark} />
        <Route path='/bikeparks' component={BikePark} />
        <Route path="/" component={Home} />
      </Switch>
    </div>
  );
}

export default App;
