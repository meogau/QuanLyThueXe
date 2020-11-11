import React, { Component } from 'react';
import Header from './general/Header';
// import logo from '../images/EZ_E-Bike_logo.png';
import { bikeparks } from '../components/test/bikeparks';
import map_maker from '../images/map-marker.webp';
import SearchBar from '../components/general/Search';

class BikeParks extends Component {
	state = {}
	render() {
		return (
			<div className="container-fluid bikepark-container">
				<Header />
				<SearchBar />
				<div className="background-color-aaa bikepark-wrapper mt-4">
					<div className="p-3">
						<h3>Chon ben xe gan ban</h3>
					</div>
					<div className="display-flex-wrap">
						{
							bikeparks.map((park, index) => {
								return <div className="one-park p-3 mx-auto" key={index}>
									<div className="one-park-content">
										<div className="p-2 one-park-header border border-bottom text-center">
											<img src={map_maker} alt="" className="mapmarker-img mr-2" /> {park.name}
										</div>
										<div className="p-3 one-park-body">
											<ul className="list-type-none ul-parkinfo">
												<li className="display-flex-row">
													<section className="li-section-bikeparks">Dia chi:</section>{park.address}
												</li>
												<li className="display-flex-row">
													<section className="li-section-bikeparks">So xe:</section>{park.numOfBikes}
												</li>
												<li className="display-flex-row">
													<section className="li-section-bikeparks">Trang thai:</section>{(park.open) ? "Mo cua" : "Dong cua"}
												</li>
											</ul>
										</div>
									</div>
								</div>
							})
						}
					</div>
				</div>
			</div>
		);
	}
}

export default BikeParks;