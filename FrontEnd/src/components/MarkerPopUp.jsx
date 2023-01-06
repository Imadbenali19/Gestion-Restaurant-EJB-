import { useState } from "react";
import { useEffect } from "react"
import { getPhoto } from "../utils/getPhotosOfRestau";
import { Carousel } from '@mantine/carousel';
import { Image } from '@mantine/core';

const MakerPopUp = ({ restau }) => {
    const [photos, setPhotos] = useState([]);
    useEffect(() => {
        console.log(restau)
        getPhoto(restau.id).then(photos => {
            console.log(photos);
            setPhotos(photos);
        })
        console.log(restau);
    }, [])
    return (
        <div>
            <h2>{restau.nom}</h2>
            <p>{restau.description}</p>
            <p><b>{restau.nom}</b> apparient à la serie de {restau.serie.nom}</p>
            <p><b>Open at : </b>{restau.date_open}</p>
            <p><b>Close at : </b>{restau.date_close}</p>
            <Carousel sx={{ maxWidth: 250 }} mx="auto" withIndicators height={200}>{
                photos.length > 0 ? photos.map(photo => {
                    return (
                        <Carousel.Slide key={photo.url}>
                            <Image
                                radius="md"
                                src={"/images/"+photo.url}
                                alt="Random unsplash image"
                            />
                        </Carousel.Slide>
                    )
                }) : ""
            }

            </Carousel>


        </div>
    )
}

export default MakerPopUp;