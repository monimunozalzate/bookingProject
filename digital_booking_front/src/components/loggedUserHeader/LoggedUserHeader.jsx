import React from "react";
import { useNavigate } from "react-router-dom";
import styles from "./LoggedUserHeader.module.css";
import CloseSharpIcon from "@mui/icons-material/CloseSharp";
import FavoritesButton from "../favoritesButton/FavoritesButon";

const LoggedUserHeader = ({handleClose}) => {
  const navigate = useNavigate();

  const handleLogOut = () => {
    localStorage.removeItem("Logged");
    navigate("/");
  };

  return (
    <div className={styles.flex}>
      <section>
        <FavoritesButton handleClose={handleClose} />
      </section>
      <section className={styles.userName}>
        <div className={styles.user}>
          <p className={styles.initials}>BR</p>
        </div>
        <div className={styles.rightText}>
          <p className={styles.userTextTop}>Hola,</p>
          <p className={styles.userTextBottom}>Braian Redmond</p>
        </div>
      </section>

      <CloseSharpIcon
        style={{
          index: 50,
          position: "absolute",
          top: -8,
          right: 0,
        }}
        onClick={handleLogOut}
      />
    </div>
  );
};

export default LoggedUserHeader;
