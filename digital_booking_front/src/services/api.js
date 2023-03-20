import axios from "axios";

//Creates a new instance of axios with customized URL to connect the api and a timeout
const api = axios.create({
    baseURL: 'http://localhost:8090/api',
    timeout: 10000,
    headers: {
        'Content-Type': 'application/json'
    }
});

//Fetch function using the customized instance of axios
// Requires 2 arguments, the end point to the api for example: "/Productos"
// the setData will store the data received from the backend into a state, has to be created on each component that uses getData
export function getData(path, setData) {
    //path is the endpoint to the api
    api.get(path)
        .then(res => {
            //Check if the data is null or undefined
            if (!res.data) {
                throw new Error('Data is null or undefined');
            }
            //Process the data since it's not null or undefined
            setData(res.data);
        })
        .catch(error => {
            if (error.response) {
                // The request was made and the server responded with an error status code
                console.log(error.response.data);
                console.log(error.response.status);
                console.log(error.response.headers);
            } else if (error.request) {
                // The request was made but no response was received
                console.log(error.request);
            } else {
                // Something happened in setting up the request that triggered an Error
                console.log('Error', error.message);
            }
            console.log(error.config);
        });
}




