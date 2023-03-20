import React, { useState, useEffect } from 'react'
import { Link } from "react-router-dom";
import {
    obtainASingleImageForCard,
    calculateRating,
    createStarRatingString,
    getDirectionFromCoordinates,
    textShortener
} from '../../utils/utils';
import styles from "./CardReservation.module.css"
import LoadingSpinner from '../loadingSpinner/LoadingSpinner';
import classNames from 'classnames';

const CardReservation = (props) => {

    const { imagenes, latitud, longitud } = props || {};
    const [numberRating, setNumberRating] = useState("");
    const [shortAdress, setShortAdress] = useState(null);
    const [starRatingIconString, setStarRatingIconString] = useState([]);
    const [singleImg, setSingleImg] = useState("");
    const [adress, setAdress] = useState("")
    const [showMoreText, setShowMoreText] = useState(false);

    const divStyle = {
        backgroundImage: `url(${singleImg})`,
    };

    const handleClickAdress = () => setShowMoreText(!showMoreText);

    useEffect(() => {
        getDirectionFromCoordinates(latitud, longitud, setAdress)
        setShowMoreText(false);
    }, []);

    useEffect(() => {
        setSingleImg(obtainASingleImageForCard(imagenes));
        setNumberRating(calculateRating(props.puntuaciones));
        setStarRatingIconString(createStarRatingString(numberRating));
    }, [numberRating]);

    useEffect(() => {
        textShortener(adress, setShortAdress, 80, styles.description, styles.mas);
    }, [adress]);


    if (!shortAdress) {
        return <LoadingSpinner />;
    }

    return (
        <div className={styles.card}>

            <div className={styles.cardContent}>

                <div className={styles.leftContainer}>
                    <h2 className={styles.title}>Detalle de la reserva</h2>
                    <div className={styles.mainImageContainer}>
                        <div className={styles.imgPlace} style={divStyle}></div>
                    </div>
                </div>

                <div className={styles.rightContainer}>
                    <div className={styles.titleCatStarContainer}>
                        <p className={styles.category}>{props.categoria.titulo}</p>
                        <h3 className={styles.placeName}>{props.nombre}</h3>
                        <p className={styles.starRating}>{starRatingIconString}</p>
                    </div>

                    <div onClick={handleClickAdress}> {!showMoreText ? (
                        <div className={styles.locationContainer}>
                            <div className={styles.locationIcon}>
                                <img
                                    className={styles.locationImg}
                                    src="/src/assets/img/icons/locationIcon.svg"
                                    alt=""
                                />
                            </div>
                            <p className={styles.adressText}>{shortAdress}</p>
                        </div>)
                        :
                        (<div className={styles.locationContainer}>
                            <p className={classNames(styles.adressText, styles.showAllText)}>{adress}</p>
                        </div>)
                    }
                    </div>

                    <div className={styles.containerCheck}>
                        <hr />
                        <div className={styles.containerCheckIn}>
                            <p>Check in</p>
                            <p>_/_/_/</p>
                        </div>
                        <hr />
                        <div className={styles.containerCheckOut}>
                            <p>Check out</p>
                            <p>_/_/_/</p>
                        </div>
                        <hr />
                    </div>
                    <div className={styles.btnContainer}>
                        <Link className={styles.btn} to="/verifiedReservation">Confirmar&nbsp;reserva</Link>
                    </div>
                </div>

            </div>
        </div>
    )
}

export default CardReservation