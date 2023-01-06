export const getZoneFromVille =(ville,zones)=>{
return zones.filter(zone=>zone.ville.nom===ville).map(z=>({label:z.nom,value:z.nom}));
}