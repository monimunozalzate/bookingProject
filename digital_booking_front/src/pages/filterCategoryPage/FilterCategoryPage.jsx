import React from 'react'
import BlockCategory from "../../components/blockCategory/BlockCategory"
import SearchBar from '../../components/searchBar/SearchBar'
import BlockFilteredByCategory from '../../components/blockFilteredByCategory/BlockFilteredByCategory'
import ResponsiveTemplate from '../../components/responsiveTemplate/ResponsiveTemplate'

const FilterCategoryPage = () => {

    return (
        <ResponsiveTemplate>
            <SearchBar />
            <BlockCategory />
            <BlockFilteredByCategory />
        </ResponsiveTemplate>
    )
}

export default FilterCategoryPage
