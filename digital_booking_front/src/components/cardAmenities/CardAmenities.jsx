import React from 'react'
import styles from "./CardAmenities.module.css"

const CardAmenities = (caracteristicas) => {

    const { icono, nombre } = caracteristicas;

    if (!caracteristicas) {
        return <div>Cargando</div>
    }

    return (
        <div className={styles.amenityContainer}>
            <div className={styles.iconContainer}>
                <img className={styles.icon} src={icono} alt="" />
            </div>
            <div className={styles.nombreContainer}>{nombre}</div>
        </div>
    )
}
export default CardAmenities