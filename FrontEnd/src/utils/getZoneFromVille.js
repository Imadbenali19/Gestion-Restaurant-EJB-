export const getZoneFromVille =(ville,zones)=>{
return zones.filter(zone=>zone.ville.nom===ville).map(zone=>zone.nom);
}