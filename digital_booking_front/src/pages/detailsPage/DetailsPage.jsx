import React, { useState, useEffect, useContext } from "react";
import { useParams } from "react-router-dom";
import { getData } from "../../services/api";
import { useWindowSize } from "../../hooks/useWindowSize";
import ProductDescription from "../../components/productDescription/ProductDescription";
import AvailableDates from "../../components/availableDates/AvailableDates";
import UsagePolitics from "../../components/usagePolitics/UsagePolitics";
import ShareButton from "../../components/shareButton/ShareButton";
import BlockImages from "../../components/blockImages/BlockImages";
import ImageCarousel from "../../components/imageCarousel/ImageCarousel";
import BlockMap from "../../components/blockMap/BlockMap";
import BlockDetailsDescription from "../../components/blockDetailsDescription/BlockDetailsDescription";
import BlockAmenities from "../../components/blockAmenities/BlockAmenities";
import FavoriteIconComponent from "../../components/favoriteIconComponent/FavoriteIconComponent";
import styles from "./DetailsPage.module.css";
import FavoritesButon from "../../components/favoritesButton/FavoritesButon";
import { GET_PRODUCT_BY_ID_ENDPOINT, replaceIdPlaceholder } from "../../services/endpoints";
import { FavoritesContext } from "../../context/Favorites.context";
import ResponsiveTemplate from "../../components/responsiveTemplate/ResponsiveTemplate";

const DetailsPage = () => {
    const { id } = useParams();
    const [dataProductDetails, setDataProductDetails] = useState(null);
    const endpoint = replaceIdPlaceholder(GET_PRODUCT_BY_ID_ENDPOINT, id);

    useEffect(() => {
        getData(endpoint, setDataProductDetails);
    }, []);

    const size = useWindowSize();

    let propsContainerFav = {
        data: dataProductDetails,
        heartColor: "black",
        shadow: "none",
    }

    if (!dataProductDetails) {
        return <div>Cargando</div>;
    }

    return (
        <ResponsiveTemplate>
            <ProductDescription {...dataProductDetails} />
            <section className={styles.buttonsBar}>
                <div className={styles.shareContainer}>
                    <ShareButton
                        dataProductDetails={dataProductDetails}
                        productDetailsPath={endpoint} />
                    <FavoriteIconComponent {...propsContainerFav} />
                </div>
                {/* <FavoritesButon /> */}
            </section>
            {size.width < 900 ? (
                <ImageCarousel {...dataProductDetails} />
            ) : (
                <BlockImages {...dataProductDetails} />
            )}
            <BlockDetailsDescription {...dataProductDetails} />
            <BlockAmenities {...dataProductDetails} />
            <AvailableDates {...dataProductDetails} />
            <BlockMap {...dataProductDetails} />
            <UsagePolitics {...dataProductDetails} />
        </ResponsiveTemplate>
    );
};

export default DetailsPage;
