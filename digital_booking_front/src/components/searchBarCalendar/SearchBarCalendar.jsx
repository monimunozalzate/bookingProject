import React from "react"
import styles from "./SearchBarCalendar.module.css"
import MobileCalendar from "../dropdownCalendar/MobileCalendar"
import DesktopCalendar from "../dropdownCalendar/DesktopCalendar"
import { useWindowSize } from "../../hooks/useWindowSize"

const SearchBarCalendar = () => {

    const size = useWindowSize();

    return (
        <section className={styles.inputCalendar}>
            <div className={styles.iconDiv}>
                {size.width < 600 ? (
                    <MobileCalendar />
                ) : (
                    <DesktopCalendar />
                )}
            </div>
        </section>
    )
}

export default SearchBarCalendar