export const getZoneList = async () => {
    const result = await fetch("http://localhost:8080/GestionRestauWS/zone/findAll");
    const data = await result.json();
    return data;

}