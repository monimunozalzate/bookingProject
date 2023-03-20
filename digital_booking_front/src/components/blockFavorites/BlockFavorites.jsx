import React, { useContext, useEffect } from 'react'
import styles from '../../components/blockRecommendation/BlockRecommendation.module.css'
import { FavoritesContext } from "../../context/Favorites.context";
import CardRecommendation from '../../components/cardRecommendation/CardRecommendation'

const BlockFavorites = () => {

    const { setFavorites, favorites } = useContext(FavoritesContext);
    useEffect(() => {
        const favorites = localStorage.getItem("favorites");
        if (favorites) {
            setFavorites(JSON.parse(favorites))
        }
        // console.log(favorites);
    }, []);

    //style={{height:'100vh'}}

  return (
    <div className={styles.backgroundContainer}
            // onClick={() => isShownLocation && setIsShownLocation(false)}
            style={{flexGrow:'1'}}
        >
            <div >
                <section className={styles.recomendacionContainer}>
                    <h1 className={styles.title}>Mis favoritos</h1>
                    <div className={styles.gridContainer}>
                        {favorites.map((data) => {
                            return <CardRecommendation {...data} key={data.id} />
                        })}
                    </div>
                </section>
            </div>
        </div>
  )
}

export default BlockFavorites