import { useEffect } from "react";
import { MapContainer, TileLayer, Marker, Popup, useMap } from "react-leaflet";
import MakerPopUp from "./MarkerPopUp";



const Map = ({ positions }) => {
  return (
    <MapContainer
      center={[31.654092326918466, -8.021360958271842]}
      zoom={8}
      scrollWheelZoom={false}
    >
      <TileLayer
        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      {positions.map((pos) => {
        console.log(pos);
        return (
          <Marker position={[pos.lat, pos.lon]}>
            <Popup>
              <MakerPopUp restau={pos}/>
              <br/>
              <center><b><a href={`https://www.google.com/maps/search/?api=1&query= ${pos.lat},${pos.lon}`}  target="_blank">Go!</a></b></center>
            </Popup>
          </Marker>
        );
      })}
    </MapContainer>
  );
};

export default Map;
