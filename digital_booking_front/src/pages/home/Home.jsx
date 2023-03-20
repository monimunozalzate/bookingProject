import React, { useContext, useState } from 'react'
import BlockCategory from "../../components/blockCategory/BlockCategory"
import BlockRecommendation from "../../components/blockRecommendation/BlockRecommendation"
import SearchBar from '../../components/searchBar/SearchBar'
import ResponsiveTemplate from '../../components/responsiveTemplate/ResponsiveTemplate'

const Home = () => {

    return (
        <ResponsiveTemplate>
            <SearchBar />
            <BlockCategory />
            <BlockRecommendation />
        </ResponsiveTemplate>
    )
}

export default Home
