import React from "react";
import styles from "./FavoritesButton.module.css";
import { Link} from "react-router-dom";

const FavoritesButon = ({handleClose}) => {
  return (
    <>
      <Link to="/favorites">
        <button className={styles.toFavButton} onClick={handleClose}>Favoritos</button>
      </Link>
    </>
  );
};

export default FavoritesButon;
