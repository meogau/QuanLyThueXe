import React, { Component } from 'react';
import logo from 'D:\\20201\\TKXDPM\\thang.frontend\\thang.frontend\\src\\images\\EZ_E-Bike_logo.png';

class SearchBar extends Component {
    state = {  }
    render() { 
        return (  
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
        );
    }
}
 
export default SearchBar;