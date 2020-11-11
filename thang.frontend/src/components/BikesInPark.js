import React, { Component } from 'react';
import SearchBar from '../components/general/Search';
import Header from '../components/general/Header';
import { bikes } from '../components/test/bikes';
import map_maker from '../images/map-marker.webp';
import logo from 'D:\\20201\\TKXDPM\\thang.frontend\\thang.frontend\\src\\images\\EZ_E-Bike_logo.png';

const selected_type_style = {
    backgroundColor: "white"
}
const unselected_type_style = {
    backgroundColor: "inherit"
}
const park = {
    name: "Park 01"
}

class Bikes extends Component {
    state = {
        displayBikes: [...bikes],
        selectedType: -1
    }
    onFilter = (type) => {
        if (type >= 0)
            this.setState({
                displayBikes: bikes.filter(bike => bike.type === type),
                selectedType: type
            })
        else this.setState({
            displayBikes: [...bikes],
            selectedType: -1
        })
    }
    onChangeSelect = (e) => {
        let type = parseInt(e.target.value);
        if (type >= 0)
            this.setState({
                displayBikes: bikes.filter(bike => bike.type === type),
                selectedType: type
            })
        else this.setState({
            displayBikes: [...bikes],
            selectedType: -1
        })
    }
    render() {
        return (
            <div className="container-fluid">
                <Header />
                <SearchBar />
                <div className="background-color-aaa bikeinpark-wrapper mt-4">
                    <div className="p-3 display-flex-row">
                        <img src={map_maker} alt="" className="mapmarker-img-big mr-2" /> <h3>{park.name}</h3>
                        <div className="flex-row-from-medium">
                            <div className="filter">
                                <section className="filter-btn px-3 py-2 border" style={(this.state.selectedType === -1) ? selected_type_style : unselected_type_style} onClick={() => this.onFilter(-1)}>Tat ca</section>
                                <section className="filter-btn px-3 py-2 border" style={(this.state.selectedType === 0) ? selected_type_style : unselected_type_style} onClick={() => this.onFilter(0)}>Xe dap don thuong</section>
                                <section className="filter-btn px-3 py-2 border" style={(this.state.selectedType === 1) ? selected_type_style : unselected_type_style} onClick={() => this.onFilter(1)}>Xe dap doi thuong</section>
                                <section className="filter-btn px-3 py-2 border" style={(this.state.selectedType === 2) ? selected_type_style : unselected_type_style} onClick={() => this.onFilter(2)}>Xe dap dien don</section>
                            </div>
                            <div className="filter-select">
                                <select onChange={this.onChangeSelect}>
                                    <option selected={(this.state.selectedType === -1)} value="-1">Tat ca</option>
                                    <option selected={(this.state.selectedType === 0)} value="0">Xe dap don thuong</option>
                                    <option selected={(this.state.selectedType === 1)} value="1">Xe dap doi thuong</option>
                                    <option selected={(this.state.selectedType === 2)} value="2">Xe dap dien don</option>
                                </select>
                            </div>
                            <div className="qrcode-input-area">
                                <b className="hide-on-small-view">Nhap QRCode:</b>
                                <input type="text" className="qrcode-input" placeholder="QRCode here" />
                                <button className="btn btn-outline-primary">Thue xe</button>
                            </div>
                        </div>
                    </div>
                    <div className="display-flex-wrap">
                        {
                            this.state.displayBikes.map((bike, index) => {
                                return <div className="one-bike p-3 mx-auto" key={index}>
                                    <div className="p-3">
                                        <img src={logo} className="mx-auto d-block" alt="" id="bike-img" />
                                    </div>
                                    <div className="p-3">
                                        <ul className="list-type-none ul-bikeinfo">
                                            <li className="display-flex-row">
                                                <section className="li-section-bike">Ten xe:</section>{bike.name}
                                            </li>
                                            <li className="display-flex-row">
                                                <section className="li-section-bike">Trang thai:</section>{(bike.status === 0) ? "San sang" : "Da duoc thue"}
                                            </li>
                                            <li className="display-flex-row">
                                                <section className="li-section-bike">Loai xe:</section>{(bike.type !== 0) ? ((bike.type === 1) ? "Xe dap doi thuong" : "Xe dap dien don") : "Xe dap don thuong"}
                                            </li>
                                            <li className="display-flex-row">
                                                <section className="li-section-bike">Gia coc:</section>{bike.value * 0.7}k VND
                                            </li>
                                            <li className="display-flex-row">
                                                <section className="li-section-bike">Mo ta xe:</section>{bike.description}
                                            </li>
                                        </ul>
                                        <div className="text-center">
                                            <button className="btn btn-outline-success">Thue xe</button>
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

export default Bikes;