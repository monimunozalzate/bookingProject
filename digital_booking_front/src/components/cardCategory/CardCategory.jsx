import React, { useState } from 'react'
import { Link } from 'react-router-dom';
import { scrollToTop } from '../../utils/utils';
import styles from './CardCategory.module.css'

const CardCategoria = (props) => {

    const [filteredCategoryPath, setFilteredCategoryPath] = useState(`/filterCategory/${props.titulo}`)

    if (!props) {
        return <div>Cargando</div>
    }
    
    return (
        <Link className={styles.card} onClick={scrollToTop} to={filteredCategoryPath}>
            <div className={styles.imageContainer}>
                <img className={styles.placeImage} src={props.urlImagen} alt={props.descripcion} />
            </div>
            <div className={styles.lowerTextContainer}>
                <p className={styles.category}>{props.titulo}</p>
                <p className={styles.placeAmount}>2 {props.titulo}</p>
            </div>
        </Link>
    );
}

export default CardCategoria
