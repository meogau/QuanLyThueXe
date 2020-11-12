import React, { Component } from 'react';

class HeaderWithSearch extends Component {
    state = {}
    render() {
        return (
            <div className="row container-fluid header-container m-0">
                <div className="col-md-1 text-center pt-4 show-on-md">
                    <a href="/">Home</a>
                </div>
                <div className="col-md-2 text-center  pt-4 show-on-md">
                    <a href="/bikeparks">Bike Parks</a>
                </div>
                <div className="col-md-2 text-center pt-4 show-on-md">
                    <a href="#">Return bike</a>
                </div>
                <div className="col-md-1 text-center pt-4 show-on-md">
                    <a href="#">About</a>
                </div>

                <div className="col-md-3 col-xl-4 text-center">                  
                </div>
                <div className="col-md-3 col-xl-2 text-center pt-3 pb-3">
                    <button className="btn btn-outline-dark">Sign in</button><button className="btn btn-outline-primary ml-2">Sign up</button>
                </div>
            </div>
        );
    }
}

export default HeaderWithSearch;