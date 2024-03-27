import './App.css'
import React from 'react';
import ListFilmsComponent from "./components/ListFilmsComponent.jsx";
import HeaderComponent from "./components/HeaderComponent.jsx";
import FooterComponent from "./components/FooterComponent.jsx";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import App from "./App.jsx";
import Login from "./login/Login.jsx";
import Signup from "./login/Signup.jsx";
import FilmSelection from "./FilmSelection.jsx";

function LoginPage() {

  return (
    <BrowserRouter>
        <Routes>
            <Route path='/' element={<Login/>}></Route>
            <Route path='/signup' element={ <Signup/>}></Route>
            <Route path='/films/*' element={<FilmSelection/>}></Route>
        </Routes>
        <FooterComponent />
    </BrowserRouter>
  )
}

export default LoginPage
