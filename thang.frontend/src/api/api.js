export const api = {
    getBikeList: (cb) => {
        fetch("/BikeParkings", {
            method: "GET",
            mode: "cors"
        })
            .then(res => res.json())
            .then(json => cb(json));
    },
    getBikesInPark: (parkID, cb) => {
        fetch(`/Bikes/BikeParkingId/${parkID}`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            },
            mode: "cors"
        })
            .then(res => res.json())
            .then(json => cb(json));
    },
    searchPark: (key,cb) => {
        fetch(`/BikeParkings/Name/${key}`,{
            method: "GET"
        })
        .then(res => res.json())
        .then(json => cb(json));
    }
}