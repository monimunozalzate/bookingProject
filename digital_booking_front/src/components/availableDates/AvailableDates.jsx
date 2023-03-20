import { useState } from "react";
import styles from "./AvailableDates.module.css";
import AddDates from "../addDates/AddDates";
import DesktopDatePicker from "../datePicker/DesktopDatePicker";
import MobileDatePicker from '../datePicker/MobileDatePicker'
import { useWindowSize } from "../../hooks/useWindowSize";

const AvailableDates = (props) => {
    // ------calendar----------------------------------
    const [isMobile, setIsMobile] = useState(false);
    const size = useWindowSize();

    return (
        <div className={styles.availableContainer}>
            <div className={styles.calendarContainer}>
                <h1>Fechas disponibles</h1>
                <div className={styles.componentsBox}>
                    <div className={styles.datePicker}>
                        {size.width < 600 ? <MobileDatePicker {...isMobile} /> : <DesktopDatePicker  {...isMobile} />}
                    </div>
                    <AddDates className={styles.datePicker} {...props} />
                </div>
            </div>
        </div>
    );
};

export default AvailableDates;
