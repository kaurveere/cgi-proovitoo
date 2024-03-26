import './App.css'
import ListFilmsComponent from "./components/ListFilmsComponent.jsx";
import HeaderComponent from "./components/HeaderComponent.jsx";
import FooterComponent from "./components/FooterComponent.jsx";
import {BrowserRouter, Route, Routes} from "react-router-dom";

function App() {

  return (
    <>
        <BrowserRouter>
            <HeaderComponent />
            <Routes>
                <Route path='/' element = { <ListFilmsComponent />}></Route>
                <Route path='/films' element = { <ListFilmsComponent /> }></Route>
            </Routes>
            <FooterComponent />
        </BrowserRouter>
    </>
  )
}

export default App
