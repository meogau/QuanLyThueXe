import React, { Component } from 'react';
import logo from '../images/EZ_E-Bike_logo.png';
import Header from'./general/Header';

class Home extends Component {
    state = {}
    render() {
        return (
            <div className="row container-fluid home-container p-0 m-0">
                <Header />
                <div className="col-lg-6">
                    <img src={logo} className="logo mx-auto d-block" alt="" />
                </div>
                <div className="col-lg-6 intro-home my-auto text-center">
                    <h2>Rent out a bike and expore.</h2>
                    <p className="p-4 color-aaa">
                        Rent a bike (also bikes available) and take a circling trip or with your family and friends through Hanoi or discover it's beauty.
                    </p>
                    <div className="btn-view-bikeparks-home mx-auto px-4 pb-3">
                        Rent Bike now
                    </div>
                </div>
            </div>
        );
    }
}

export default Home;