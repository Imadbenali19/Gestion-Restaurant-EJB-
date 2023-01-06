export const getVilleList = async () => {
    const result = await fetch("http://10.0.2.2:8080/GestionRestauWS/ville/findAll");
    const data = await result.json();
    return data;
}