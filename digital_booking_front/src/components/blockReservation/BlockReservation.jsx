import React, { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
import { getData } from "../../services/api";
import {
    GET_PRODUCT_BY_ID_ENDPOINT,
    replaceIdPlaceholder,
} from "../../services/endpoints";
import { useWindowSize } from "../../hooks/useWindowSize";
import styles from "./BlockReservation.module.css";
import DescriptionBar from "../descriptionBar/DescriptionBar";
import FormReservation from "../formReservation/FormReservation";
import DesktopDatePicker from "../datePicker/DesktopDatePicker";
import MobileDatePicker from "../datePicker/MobileDatePicker";
import BlockTimePicker from "../blockTimePicker/BlockTimePicker";
import UsagePolitics from '../usagePolitics/UsagePolitics'
import CardReservation from "../cardReservation/CardReservation";

const BlockReservation = () => {
    const { id } = useParams();
    const [isMobile, setIsMobile] = useState(false);
    const [dataProductDetails, setDataProductDetails] = useState(null);
    const endpoint = replaceIdPlaceholder(GET_PRODUCT_BY_ID_ENDPOINT, id);

    useEffect(() => {
        getData(endpoint, setDataProductDetails);
    }, []);

    // calendar
    const size = useWindowSize();
    if (!dataProductDetails) {
        return <div>Cargando</div>;
    }

    return (
        <>
            <div className={styles.backgroundContainer}>

                <div className={styles.containerReservation}>

                    <DescriptionBar {...dataProductDetails} />
                    <h1 className={styles.userData}>Completá tus datos</h1>

                    <section className={styles.bodyContainer}>
                        <div className={styles.formContainer}>
                            <FormReservation />
                        </div>
                        <div className={styles.dateContainer}>
                            <h2 className={styles.reserveDateTitle}>Seleccioná tu fecha de reserva</h2>
                            {size.width < 600 ? (
                                <MobileDatePicker {...isMobile} />
                            ) : (
                                <DesktopDatePicker {...isMobile} />
                            )}
                        </div>
                        <div className={styles.timeContainer}>
                            <h2>Tu horario de llegada</h2>
                            <BlockTimePicker />
                        </div>
                        <div className={styles.cardContainer}>
                            <CardReservation {...dataProductDetails} />
                        </div>
                    </section>
                </div>
            </div>
            <UsagePolitics {...dataProductDetails} />

        </>
    );
};

export default BlockReservation;
