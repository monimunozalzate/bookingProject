export const GET_EIGHT_RANDOM_PRODUCTS_ENDPOINT = "/productos/rand";
export const GET_ALL_CATEGORIES_ENDPOINT = `/categorias`;
export const GET_ALL_PRODUCTS_ENDPOINT = `/productos`;
export const GET_PRODUCT_BY_ID_ENDPOINT = `/productos/:id`;

//const endpoint = replaceIdPlaceholder(GET_PRODUCT_BY_ID_ENDPOINT, id);
export function replaceIdPlaceholder(endpoint, id) {
    return endpoint.replace(':id', id);
  }

//import { GET_EIGHT_RANDOM_PRODUCTS_ENDPOINT } from '../../services/endpoints';
//import { GET_ALL_CATEGORIES_ENDPOINT } from '../../services/endpoints';
//import { GET_ALL_PRODUCTS_ENDPOINT } from '../../services/endpoints';
//import { GET_PRODUCT_BY_ID_ENDPOINT } from '../../services/endpoints';