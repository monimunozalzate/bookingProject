import React from "react";
import styles from "./FormReservation.module.css";

const FormReservation = () => {
  return (
    <div className={styles.formContainer}>
      <form action="none" className={styles.form}>
        <section className={styles.formInfo}>
          <div className={styles.formDivisions}>
            <label htmlFor="name">Nombre</label>
            <input type="readonly" name="name" disabled placeholder='Nombre'/>
          </div>
          <div className={styles.formDivisions}>
            <label htmlFor="lastName">Apellido</label>
            <input type="readonly" name="lastName" disabled placeholder='Apellido'/>
          </div>
        </section>
        <section className={styles.formInfo}>
        <div className={styles.formDivisions}>
            <label htmlFor="email">Correo electrónico</label>
            <input type="readonly"name="email" disabled placeholder='Email'/>
          </div>
          <div className={styles.formDivisions}>
            <label htmlFor="city">Ciudad</label>
            <input type="text" name="city"/>
          </div>
        </section>
      </form>
    </div>
  );
};

export default FormReservation;
