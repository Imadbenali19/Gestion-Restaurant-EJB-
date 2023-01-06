import { useState, useEffect } from "react";
import "./App.css";

import Map from "./components/Map";
import Search from "./components/Search";
import { getZoneList } from "./utils/getZoneList";
import { getVilleList } from "./utils/getVilleList";
import { getSpecialiteList } from "./utils/getSpecialiteList";

function App() {
  const [positions, setPositions] = useState([]);
  const [zoneList, setZones] = useState([]);
  // const [villes, setVilles] = useState([]);
  // const [specialites, setSpecialites] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/GestionRestauWS/restau/findAll")
      .then((res) => res.json())
      .then((positions) => {
        setPositions(positions);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  const findPositions = (ville, zone, spec) => {
    fetch(
      `http://localhost:8080/GestionRestauWS/restau/search/${ville}/${zone}/${spec}`
    )
      .then((res) => res.json())
      .then((positions) => {
        console.log("new positions: " + positions);
        setPositions(positions);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className="App">
      <h1>Map Restaux</h1>
      <div className="container">
        <Search
          findPositions={findPositions}
          zonesList={[]}
          // villesList={villes}
          // specialitesList={specialites}
        />

        {positions.length > 0 ? <Map positions={positions} /> : ""}
      </div>
    </div>
  );
}

export default App;
