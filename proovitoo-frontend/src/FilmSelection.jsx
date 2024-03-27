import HeaderComponent from "./components/HeaderComponent.jsx";
import ListFilmsComponent from "./components/ListFilmsComponent.jsx";
import React from "react";
import { useParams } from 'react-router-dom';

function FilmSelection() {
    const { username } = useParams();
    return (
        <div>
            <HeaderComponent />
            <ListFilmsComponent/>
        </div>
    );
}

export default FilmSelection;
