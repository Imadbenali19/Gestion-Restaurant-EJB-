export const getVilleList = async () => {
    const result = await fetch("http://localhost:8080/GestionRestauWS/ville/findAll");
    const data = await result.json();
    return data;
}