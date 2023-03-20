import React, { useState, useEffect } from 'react'
import { getData } from '../../services/api'
import { GET_ALL_CATEGORIES_ENDPOINT } from '../../services/endpoints'
import styles from './BlockCategory.module.css'
import CardCategoria from '../cardCategory/CardCategory'
import LoadingSpinner from '../loadingSpinner/LoadingSpinner'

const BlockCategorias = () => {

    const [dataCategories, setDataCategories] = useState(null);
    const [categoriesToShow, setCategoriesToShow] = useState(4);

    useEffect(() => {
        getData(GET_ALL_CATEGORIES_ENDPOINT, setDataCategories)
    }, []);

    if (!dataCategories) {
        return <LoadingSpinner/>
    }

    return (
        <section className={styles.categoriaContainer}>
            <h2 className={styles.title}>Buscar por tipo de alojamiento</h2>
            <div className={styles.flexContainer}>
                {
                    dataCategories.slice(0, categoriesToShow).map((data) => {
                        return <CardCategoria {...data} key={data.id} />
                    })
                }
            </div>
        </section>
    )
}

export default BlockCategorias