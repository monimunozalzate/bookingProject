import {  useContext } from "react";
import IconButton from '@mui/material/IconButton';
import FavoriteSharpIcon from "@mui/icons-material/FavoriteSharp";
import { FavoritesContext } from "../../context/Favorites.context";

const FavoriteIconComponent = ({data, heartColor, shadow}) => {
  const { favorites, handleFavorites, isInFavorites } = useContext(
    FavoritesContext
  );

  const isInFavs = isInFavorites(data.id);
  // console.log(isInFavs)

  return (
    <>
      <IconButton
        value={favorites}
        onClick={() => handleFavorites(data)}
      >
        {isInFavs ? <FavoriteSharpIcon color="error" /> : <FavoriteSharpIcon style={{ color: heartColor, filter: shadow}} />}
      </IconButton>
    </>
  );
};

export default FavoriteIconComponent;
