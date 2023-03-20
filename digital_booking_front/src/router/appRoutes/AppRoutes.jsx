import React from 'react'
import Home from "../../pages/home/Home"
import { Routes, Route,  Navigate } from 'react-router-dom'
import FilterCategoryPage from "../../pages/filterCategoryPage/FilterCategoryPage"
import DetailsPage from "../../pages/detailsPage/DetailsPage"
import SignUpPage from "../../pages/signUpPage/SignUpPage"
import LoginPage from "../../pages/loginPage/LoginPage"
import FavoritesPage from "../../pages/favoritesPage/FavoritesPage"
import Layout from '../layout/Layout'
import ReservationPage from '../../pages/reservationPage/ReservationPage'
import VerifiedReservationPage from '../../pages/verifiedReservationPage/VerifiedReservationPage'

const AppRoutes = () => {
    return (
        <Routes>
            <Route path="/" element={<Layout />}>
                <Route path="/" element={<Home />} />
                <Route path="/filterCategory/:category" element={<FilterCategoryPage />} />
                <Route path="/productDetails/:id" element={<DetailsPage />} />
                <Route path="/signUp" element={<SignUpPage />} />
                <Route path="/login" element={<LoginPage />} />
                <Route path="*" element={<Navigate to="/" />} />
                <Route path="/favorites" element={<FavoritesPage />} />
                <Route path="/product/:id/reserve" element={<ReservationPage/>} />
                <Route path="/verifiedReservation" element={<VerifiedReservationPage/>} />
            </Route>
        </Routes>
    )
}

export default AppRoutes