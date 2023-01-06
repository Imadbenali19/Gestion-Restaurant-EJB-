import { StatusBar } from 'expo-status-bar';
import { useState, useEffect } from 'react';
import { StyleSheet, Text, View, Image, Modal, FlatList } from 'react-native';
import MapView from 'react-native-maps';
import { PROVIDER_GOOGLE, Marker } from "react-native-maps";
import Search from './components/Search';
import { getSpecialiteList } from './util/getSpecialiteList';
import Animated from 'react-native-reanimated';
import PagerView from 'react-native-pager-view';
import { getPhoto } from "./util/getPhotosOfRestau";


// const images = [
//   'https://lh3.googleusercontent.com/u/0/drive-viewer/AFDK6gPdfP5hPJXoQFbmwF0jfVXQhDcp-lNfV0K9TQqGFa8UaDXHIH7ceXuX4g36Kuats2GtEAeSuZXvifM9dT0sxDCvHJJMzQ=w1920-h902',
//   'https://lh3.googleusercontent.com/u/0/drive-viewer/AFDK6gPtRhcRYYUWNcpswpg2cy3b4LldCiNl3fyaXZVhVAYwC_5KRT4vP8Vm6YrE9UX6vLL_TA3SSPhWfgQDuG-rl6jFH4Y1aw=w1920-h902',
//   //'./assets/icon.png',

// ];
var i = 0;

export default function App() {
  const [positions, setPositions] = useState([]);

  const [modalVisible, setModalVisible] = useState(false);

  const [modalContent, setModalContent] = useState('');

  const [photos, setPhotos] = useState([]);

  // const renderItem = (item) => {
  //   console.log(i)
  //   console.log(item)
  //   i = i + 1;
  //   return (
  //     <View style={styles.page} key={i} >
  //       <Image source={{ uri: item }} style={styles.image} />
  //     </View>
  //   );
  // };

  useEffect(() => {

    fetch("http://10.0.2.2:8080/GestionRestauWS/restau/findAll")
      .then((res) => res.json())
      .then((positions) => {
        setPositions(positions);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [])

  useEffect(() => { }, [photos])

  const findPositions = (ville, zone, spec) => {
    console.log(ville)
    console.log(zone)
    console.log(spec)
    fetch(
      `http://10.0.2.2:8080/GestionRestauWS/restau/search/${ville.value}/${zone.value}/${spec.value}`
    )
      .then((res) => res.json())
      .then((positions) => {
        console.log("new positions: " + positions);
        setPositions(positions);
      })
      .catch((err) => {
        console.log("Error: " + err);
      });
  };



  const getRestauPhoto = (id) => {
    try {

      getPhoto(id).then(photos => {
        console.log("Photo Data func: " + photos[1].url)
        setPhotos(photos);
      })
    } catch (error) {
      console.log("Error setting photo " + error);
    }
  }
  return (
    <View style={styles.container}>
      <View></View>
      <Search findPositions={findPositions} />

      <MapView provider={PROVIDER_GOOGLE} style={styles.map} >
        {positions.length > 0 ? positions.map(position => {
          return (
            <Marker
              key={position.id}
              coordinate={{ latitude: position.lat, longitude: position.lon }}
              title={position.nom}
              description={position.description}
              onPress={() => {

                getPhoto(position.id).then(photos => {
                  try {

                    
                    position.photos = photos;
                    
                    console.log("Yes" + position.zone.nom)
                    setModalContent(position);
                    setModalVisible(true);
                  } catch (err) {
                    console.log("Kayn Error: " + err)
                  }
                })




              }}

            />

          )
        }) : ""}
      </MapView>
      {modalContent && <Modal
        animationType="slide"
        transparent={false}
        visible={modalVisible}
        onRequestClose={() => setModalVisible(false)}
        
      >
        <View style={styles.modalContent} key={modalContent.id}>
          <Text style={styles.titleText}>{modalContent.nom}</Text>
          <Text style={styles.descText}>{modalContent.description}</Text>
          <Text>{modalContent.adresse}</Text>
          {/* <Text>Belong to : {modalContent.serie.nom}</Text> */}
          <Text>Open at : {modalContent.date_open}</Text>
          <Text>Close at : {modalContent.date_close}</Text>
        </View>
        
            <View style={{ flex: 1 }}>
          <PagerView style={styles.viewPager} initialPage={0}>
            {/* { photos.length > 0 ? photos.map((item) => renderItem(item)):"" } */}

            {/* <Image source={require('./assets/icon.png')} style={styles.image} /> */}
            
           
          


            {
             modalContent.photos.map(photo =>  {
              // console.log("Photo map details: "+photo.url)
              // photo.url = photo.url.split(".")[0]+".png"
              // const link = `./assets/${photo.url}`
              // console.log("The fucling link: "+link);
              // let text='mcdoAbbad1.PNG'.split('.')[0]+'.png';
              
               console.log("ddddd :  " +photo.url)
               
               let y="mcdoAbbad1.png"
               x=photo.url;
               console.log("Lenggg "+photo.webUrl)
               
              return(
                  <Image source={{ uri: photo.webUrl }} style={styles.image} /> 
                )}
              )
             }  

          </PagerView>
        </View>
        

        
      </Modal>}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  map: {
    width: '100%',
    height: '100%',
  },
  modalContent: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  image: {
    width: 300,
    height: 300,
  },
  imageContainer: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  page: {
    justifyContent: 'center',
    alignItems: 'center',
  },
  viewPager: {
    flex: 1,
  },
  titleText: {
    fontSize: 20,
    fontWeight: "bold",
    color: 'red'
  },
  descText: {
    fontStyle: 'italic',
  }

});
