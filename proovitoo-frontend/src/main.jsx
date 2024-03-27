import React from 'react'
import ReactDOM from 'react-dom/client'
import LoginPage from './LoginPage.jsx'
import './index.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from "./login/Login.jsx";
import App from "./App.jsx";

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <LoginPage />
  </React.StrictMode>,
)
