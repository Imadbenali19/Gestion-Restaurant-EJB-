export const getZoneList = async () => {
    const result = await fetch("http://10.0.2.2:8080/GestionRestauWS/zone/findAll");
    const data = await result.json();
    return data;

}