import MapView from 'react-native-maps';
import { PROVIDER_GOOGLE,Marker } from "react-native-maps";
import { StyleSheet, Text, View } from 'react-native';

export default function MapContainer({ positions }) {
    return (
        <MapView provider={PROVIDER_GOOGLE} style={styles.map} >
            {positions.map(position => {
                console.log(position)
                return (
                    <Marker
                        key={position.nom}
                        coordinate={{ latitude: position.latitude, longitude: position.longitude }}
                        title={"Marker hello test"}
                        description={"marker.description"}
                    />
                )
            })}


        </MapView>
    )
}
const styles = StyleSheet.create({
    container: {
      flex: 1,
    },
    map: {
      width: '100%',
      height: '100%',
    },
  });