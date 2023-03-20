import React from "react";
import styles from "./SearchBar.module.css";
import SearchBarCalendar from "../searchBarCalendar/SearchBarCalendar";
import SearchBarLocationInput from "../searchBarLocationInput/SearchBarLocationInput";

const SearchBar = () => {
 
  return (
    <form
      className={styles.searchBar}
      data-testid="search-bar"
      >
      <h1>Busca ofertas en hoteles, casas y mucho más</h1>
      <div className={styles.inputs}>
        <SearchBarLocationInput/>
        <SearchBarCalendar/>
        <div>
          <button
            className="formButton"
            type="submit"
            style={{
              backgroundColor: "var(--orange)",
              color: "white",
              border: "none",
              borderRadius: "5px",
              height: "3rem",
              minWidth: "12.5rem",
              width: "100%",
              fontSize: "1rem",
            }}
          >
            Buscar
          </button>
        </div>
      </div>
    </form>
  );
};

export default SearchBar;

