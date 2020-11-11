import React, { Component } from 'react';
import Header from './general/Header';
import logo from '../images/EZ_E-Bike_logo.png';
import {bikeparks} from '../components/test/bikeparks';

class BikeParks extends Component {
    state = {}
    render() {
        return (
            <div className="container-fluid bikepark-container">
                <Header/>
                <div className="bikepark-title row mt-3">
                    <div className="col-3">
                        <img src={logo} className="bikepark-logo m-auto d-block" alt="" />
                    </div>
                    <div className="col-9 m-auto row">
                        <input type="text" className="form-control mx-auto col-6 col-md-8" placeholder="Search bike, park..." />
                        <div className="col-4">
                            <button className="btn btn-outline-primary ml-1 col-6 col-md-4">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                    </div>
                </div>
                <div className="background-color-aaa bikepark-wrapper display-flex-wrap">
                    <h3>Chon ben xe gan ban</h3>
                    <div className="display-flex-wrap">
                        {
                            bikeparks.map((park,index => {
                                return <div className="one-park">
                                    
                                </div>
                            }))
                        }
                    </div>
                </div>
            </div>
        );
    }
}

export default BikeParks;