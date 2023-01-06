export const getSpecialiteList = async () => {

    try{
        
        const result = await fetch("http://10.0.2.2:8080/GestionRestauWS/specialite/findAll");
        const data = await result.json();

        console.log(data)
        return data;
    }catch(e){
        console.log("We got an error")
    }
}