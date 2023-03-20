import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import styles from "./CardRecommendation.module.css";
import {
    createStarRatingString,
    transformNumberRatingToTextEquivalent,
    calculateRating,
    obtainASingleImageForCard,
    textShortener
} from "../../utils/utils";
import { scrollToTop } from "../../utils/utils";
import FavoriteIconComponent from "../favoriteIconComponent/FavoriteIconComponent";
import LoadingSpinner from "../loadingSpinner/LoadingSpinner";

const CardRecommendation = (props) => {
    const { imagenes, caracteristicas, descripcion } = props || {};
    const [navigateToDetailsPath, setNavigateToDetailsPath] = useState(
        `/productDetails/${props.id}`
    );
    const [shortDescription, setShortDescription] = useState("");
    const [numberRating, setNumberRating] = useState("");
    const [starRatingIconString, setStarRatingIconString] = useState([]);
    const [wordRating, setwordRating] = useState("");
    const [singleImg, setSingleImg] = useState("");

    let propsContainerFav = {
        data: props,
        heartColor: "white",
        shadow: `drop-shadow(0px 0px 2px rgba(0, 0, 0, 0.5))`,
    }

    const divStyle = {
        backgroundImage: `url(${singleImg})`,
    };

    useEffect(() => {
        setSingleImg(obtainASingleImageForCard(imagenes));
        setNumberRating(calculateRating(props.puntuaciones));
        setStarRatingIconString(createStarRatingString(numberRating));
        setwordRating(transformNumberRatingToTextEquivalent(numberRating));
        textShortener(descripcion, setShortDescription, 80, styles.description, styles.mas);
    }, [numberRating]);

    if (!props) {
        return <LoadingSpinner />;
    }

    return (
        <article className={styles.card}>
            <div className={styles.leftHalfContainer}>
                <div className={styles.mainImageContainer}>
                    <div className={styles.imgPlace} style={divStyle}></div>
                    <div className={styles.hearthIcon}>
                        {/* <img className={styles.hearthIcon} src="/src/assets/img/icons/heartIcon.svg" alt="" /> */}
                        <FavoriteIconComponent  {...propsContainerFav} />
                    </div>
                </div>
            </div>
            <div className={styles.rightHalfContainer}>
                <div className={styles.upperFirst}>
                    <div className={styles.upperFirstLeft}>
                        <div className={styles.category}>{props.categoria.titulo}</div>
                        <p className={styles.starRating}>{starRatingIconString}</p>
                    </div>
                    <div className={styles.numberRating}>{numberRating}</div>
                </div>
                <div className={styles.upperSecond}>
                    <div className={styles.placeName}>{props.nombre}</div>
                    <div className={styles.wordRating}>{wordRating}</div>
                </div>
                <div className={styles.upperMediumContainer}>
                    <div>
                        <img
                            className={styles.locationIcon}
                            src="/src/assets/img/icons/locationIcon.svg"
                            alt=""
                        />
                    </div>
                    <div className={styles.distance}>A 940 m del centro</div>
                    <Link to={navigateToDetailsPath}>
                        <div className={styles.mapUrl}>&nbsp;MOSTRAR EN EL MAPA</div>
                    </Link>
                </div>
                <div className={styles.lowerMediumContainer}>
                    {caracteristicas.map((data) => {
                        return (
                            <div key={data.id}>
                                <img
                                    className={styles.iconCharacteristic}
                                    src={data.icono}
                                    alt={data.nombre}
                                />
                            </div>
                        );
                    })}
                </div>
                <div className={styles.boxDescription}>{shortDescription}</div>
                <Link onClick={scrollToTop} to={navigateToDetailsPath}>
                    <div className={styles.btnContainer}>
                        <button className={styles.btn}>Ver&nbsp;más</button>
                    </div>
                </Link>
            </div>
        </article>
    );
};

// Takes a string and makes it shorter, will also add a "más..." at the end if the string becomes shorter
/*const descriptionShortener = (originalDescription, set) => {
    let maxCharText = 80;
    if (screen.width === 414) {
        maxCharText = 80;
    }
    let newShortString = "";
    let masWord = "";
    for (let i = 0; i <= maxCharText; i++) {
        if (originalDescription[i] === undefined) {
            break;
        } else {
            newShortString += originalDescription[i];
        }
    }
    //If the string is longer than maxCharText then '...' is added
    //at the end of the new shorter description
    if (originalDescription[maxCharText + 1] !== undefined) {
        newShortString += "...";
        masWord += " más...";
    }
    //Sets the new modified shorter description inside a variable as jsx
    set(
        <p>
            <span className={styles.description}>{newShortString}</span>
            <span className={styles.mas}>{masWord}</span>
        </p>
    );
};*/

/*//Goes through the array of objects that contains the images for each product
//and gets the first one
function obtainASingleImageForCard(arrayObjects) {
    let singleImage = "";
    if (arrayObjects !== undefined) {
        for (let i = 0; i < 1; i++) {
            singleImage += arrayObjects[i].urlImg;
        }
    } else {
        return "";
    }
    return singleImage;
}*/

//Limits the amount of icons that are shown on each card
function renderLimitedIcons(arrayObject) {
    if (arrayObject !== undefined) {
        return mapIcons(arrayObject);
    }
}

//Maps and returns each icon as an image tag that can be rendered
function mapIcons(arrayObject) {
    arrayObject.map((data) => {
        return (
            <div>
                <img
                    className={styles.locationIcon}
                    src={data.caracteristicas.icono}
                    alt={data.caracteristicas.nombre}
                />
            </div>
        );
    });
}

export default CardRecommendation;
