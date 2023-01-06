export const getPhoto = async (id) => {
    const result = await fetch(`http://localhost:8080/GestionRestauWS/restau/getPhotos/${id}/`);
    const data = await result.json();
    console.log(data) 
    return data;
}