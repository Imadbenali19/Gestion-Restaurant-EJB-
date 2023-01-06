import { useEffect, useState } from "react";
import { StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import { getZoneList } from "../util/getZoneList";
import { getVilleList } from "../util/getVilleList";
import { getSpecialiteList } from "../util/getSpecialiteList";
import { getZoneFromVille } from "../util/getZoneFromVille";
import Dropdown from "./DropDown";

const Search = ({ findPositions }) => {
  const [zoneNames, setZoneNames] = useState([]);
  const [zones, setZones] = useState([]);
  const [villeNames, setVilleNames] = useState([]);
  const [specialiteNames, setSpecialiteNames] = useState([]);

  const [selectedVille, setSelectedVille] = useState(undefined);
  const [selectedZone, setSelectedZone] = useState(undefined);
  const [selectedSpec, setSelectedSpec] = useState(undefined);


const updateZonelist=(ville)=>{
  setZoneNames(getZoneFromVille(ville,zones))
  
}

  useEffect(() => {
    getZoneList().then((zones) => {
      setZoneNames(zones.map((z) => ({label:z.nom,value:z.nom})));
      console.log(zones);
      setZones(zones);
    });
    getVilleList().then((villes) => {
      setVilleNames(villes.map((v) => ({label:v.nom,value:v.nom})));
    });
    getSpecialiteList().then((spes) => {
      setSpecialiteNames(spes.map((s) => ({label:s.nom,value:s.nom})));
    });
  }, []);

  return (
    <View style={styles.row}>
      <View></View>
      <View>
        <Dropdown
          value={selectedVille}
          onSelect={setSelectedVille}
          data={["", ...villeNames]}
          label="Ville"
          updateZonelist={updateZonelist}
        />
      </View>
      <View>
        <Dropdown
          value={selectedZone}
          onSelect={setSelectedZone}
          data={["", ...zoneNames]}
          label="Zone"
        />
      </View>
      <View>
        <Dropdown
          value={selectedSpec}
          onSelect={setSelectedSpec}
          data={["", ...specialiteNames]}
          label="Specialite"
        />
      </View>
      <View span={3} offset={9}>
        <TouchableOpacity style={styles.button} onPress={()=>{findPositions(selectedVille,selectedZone,selectedSpec)}}><Text>Search</Text></TouchableOpacity>
      </View>
    </View>
  );
};

export default Search;


const styles = StyleSheet.create({
  
  button: {
    alignItems: "center",
    backgroundColor: "#DDDDDD",
    padding: 10
  },
  
});