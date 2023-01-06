export const getSpecialiteList = async () => {
    const result = await fetch("http://localhost:8080/GestionRestauWS/specialite/findAll");
    const data = await result.json();
    return data;
}