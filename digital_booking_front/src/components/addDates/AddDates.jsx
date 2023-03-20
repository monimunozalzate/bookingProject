import React, {useState} from 'react'
import { Link, useNavigate } from 'react-router-dom'
import styles from './AddDates.module.css'
import { scrollToTop } from '../../utils/utils';

const AddDates = (props) => {
  const { id } = props || {};
  // console.log(props)
  const [navigateToReservationPath, setNavigateToReservationPath] = useState(`/product/${props.id}/reserve`)

  // logged???
  const loggedIn = JSON.parse(localStorage.getItem("Logged")); 
  
  return (
    <div className={styles.addDatesContainer}>
        <p>Agregá tus fechas de viaje para obtener precios exactos</p>
        {loggedIn ? 
         <Link to={navigateToReservationPath} onClick={scrollToTop} ><button className={styles.reservationButton}>Iniciar Reserva</button></Link>
        :
        <Link to='/login' ><button className={styles.reservationButton} >Iniciar Reserva</button></Link>
        }       
    </div>
  )
}

export default AddDates