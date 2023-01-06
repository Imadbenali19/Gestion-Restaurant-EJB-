import { Grid, NativeSelect, Button } from "@mantine/core";
import { useEffect, useState } from "react";
import { getZoneList } from "../utils/getZoneList";
import { getVilleList } from "../utils/getVilleList";
import { getSpecialiteList } from "../utils/getSpecialiteList";
import { getZoneFromVille } from "../utils/getZoneFromVille";

const Search = ({ findPositions }) => {
  const [zoneNames, setZoneNames] = useState([]);
  const [zones, setZones] = useState([]);
  const [villeNames, setVilleNames] = useState([]);
  const [specialiteNames, setSpecialiteNames] = useState([]);

  const [selectedVille, setSelectedVille] = useState("");
  const [selectedZone, setSelectedZone] = useState("");
  const [selectedSpec, setSelectedSpec] = useState("");


const updateZonelist=(ville)=>{
  setZoneNames(getZoneFromVille(ville,zones))
  
}

  useEffect(() => {
    getZoneList().then((zones) => {
      setZoneNames(zones.map((z) => z.nom));
      setZones(zones);
    });
    getVilleList().then((villes) => {
      setVilleNames(villes.map((v) => v.nom));
    });
    getSpecialiteList().then((spes) => {
      setSpecialiteNames(spes.map((s) => s.nom));
    });
  }, []);

  return (
    <Grid>
      <Grid.Col span={4}>
        <NativeSelect
          value={selectedVille}
          onChange={(e) =>  {setSelectedVille(e.currentTarget.value);updateZonelist(e.currentTarget.value)}}
          data={["", ...villeNames]}
          label="Ville"
        />
      </Grid.Col>
      <Grid.Col span={4}>
        <NativeSelect
          value={selectedZone}
          onChange={(e) => setSelectedZone(e.currentTarget.value)}
          data={["", ...zoneNames]}
          label="Zone"
        />
      </Grid.Col>
      <Grid.Col span={4}>
        <NativeSelect
          value={selectedSpec}
          onChange={(e) => setSelectedSpec(e.currentTarget.value)}
          data={["", ...specialiteNames]}
          label="Specialite"
        />
      </Grid.Col>
      <Grid.Col span={3} offset={9}>
        <Button
          onClick={() => {
            findPositions(selectedVille, selectedZone, selectedSpec);
          }}
          size="lg"
        >
          Search
        </Button>
      </Grid.Col>
    </Grid>
  );
};

export default Search;
