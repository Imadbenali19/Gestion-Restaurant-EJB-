export const getPhoto = async (id) => {
    try {
        const result = await fetch(`http://10.0.2.2:8080/GestionRestauWS/restau/getPhotos/${id}/`);
        const data = await result.json();
        
        return data;
        
    } catch (error) {
        console.log("Error func getPhoto "+error)
    }
}