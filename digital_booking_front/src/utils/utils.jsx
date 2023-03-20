import axios from "axios";

//Using the array of objects that has the ratings from each product
//maps through each value to calculate an average value
export function calculateRating(arrayRatings) {
    if (arrayRatings !== undefined) {
        let finalRating = 0;
        let amountRated = 0;
        //console.log(arrayRatings);
        arrayRatings.map((data) => {
            finalRating += data.valor;
            amountRated++;
        })
        /*console.log(finalRating);
        console.log(amountRated);*/
        return Math.round(finalRating / amountRated) * 2;
    } else {
        return ""
    }
}

// Takes the star number amount and turns it into a string of star icons
export function createStarRatingString(star) {
    if (star) {
        //console.log(star)
        let singleStar = "★";
        let newStarRatingString = "";
        for (let i = 0; i <= star / 2 - 1; i++) {
            newStarRatingString += singleStar;
        }
        return newStarRatingString;
    } else {
        return ""
    }
}

//Takes a number from 1 to 10 and returns a word that defines what that number means
export function transformNumberRatingToTextEquivalent(number) {
    if (number) {
        switch (number) {
            case 1:
            case 2:
            case 3:
                return "Malo"
            case 4:
                return "Aceptable"
            case 5:
            case 6:
                return "Bueno"
            case 7:
            case 8:
                return "Muy bueno"
            case 9:
            case 10:
                return "Excelente"
            default:
                break;
        }
    } else {
        return ""
    }
}

//Will scroll the window to the coordinates (0, 0) 
export function scrollToTop() {
    window.scrollTo(0, 0)
}

//Goes through the array of objects that contains the images for each product
//and gets the first one
export function obtainASingleImageForCard(arrayObjects) {
    let singleImage = "";
    if (arrayObjects) {
        for (let i = 0; i < 1; i++) {
            singleImage += arrayObjects[i].urlImg;
        }
    } else {
        return "";
    }
    return singleImage;
}

//Does an axios call to nominatim, an api that allows you to do reverse geocoding 
//(give a latitude and longitude and the api returns the actual adress of those coordinates if there is one)
export function getDirectionFromCoordinates(latitude, longitude, set, event) {
    const lat = latitude;
    const lng = longitude; //event.latlng;
    axios.get(`https://nominatim.openstreetmap.org/reverse?format=json&lat=${lat}&lon=${lng}`)
        .then((response) => {
            set(response.data.display_name);
        })
        .catch((error) => {
            console.log(error);
            set("Error fetching address");
        });
};


// Takes a string and makes it shorter, will also add a "más..." at the end if the string becomes shorter
export function textShortener(originalDescription, set, maxChar, classText, classMas) {
    if (originalDescription) {
        let maxCharText = maxChar;
        /*if (screen.width === 414) {
            maxCharText = maxCharSmallScreen;
        }*/
        let newShortString = "";
        let masWord = "";
        for (let i = 0; i <= maxCharText; i++) {
            if (originalDescription[i] === undefined) {
                break;
            } else {
                newShortString += originalDescription[i];
            }
        }
        //If the string is longer than maxCharText then '...' is added
        //at the end of the new shorter description
        if (originalDescription[maxCharText + 1] !== undefined) {
            newShortString += "...";
            masWord += " más...";
        }
        //Sets the new modified shorter description inside a variable as jsx
        set(
            <>
                <span className={classText}>{newShortString}</span>
                <span className={classMas}>{masWord}</span>
            </>
        );
    } else {
        return undefined;
    }
};






/*export function cutCategories(arrayCategories, cutNumber) {
    let newArray = []
    console.log(arrayCategories);
    for (let i = 0; i < cutNumber; i++) {
        //newArray.push(arrayCategories[i]);
        console.log(arrayCategories[i])
    }
    return newArray;
}*/