import {Route,Link,BrowserRouter as Router, Routes} from 'react-router-dom';
import Navbar from './Navbar';
import LoginPage from './Pages/LoginPage';
import RegistrationPage from './Pages/RegistrationPage';
import UserPage from './Pages/UserPage';
import AdminPage from './Pages/AdminPage';
import { useState } from 'react';
import Orders from './components/Orders';
import AddItems from './components/AddItems';
import ForgotPassword from './Pages/ForgotPassword';
import HelpPage from './Pages/HelpPage';


export default function Starting(props) {

    const login = Boolean(sessionStorage.getItem('login'));
    const role = sessionStorage.getItem('role');

    if (login === null){
      sessionStorage.setItem('login',false);
    }

    return <div className="App">

    <Router>
      <Navbar login={login} role={role}></Navbar>
      <Routes>
        <Route path="/" element={login ? (role === 'user' ? <UserPage/> : <AdminPage/>) : (<LoginPage />) } />
        <Route path='/login' element={<LoginPage />}></Route>
        <Route path='/register' element={<RegistrationPage />}></Route>
        <Route path='/orders' element={<Orders></Orders>}></Route>
        <Route path='/AddItems' element={<AddItems></AddItems>}></Route>
        <Route path='/forgotPassword' element={<ForgotPassword></ForgotPassword>}></Route>
        <Route path='/help' element={<HelpPage></HelpPage>}></Route>
      </Routes>
    </Router>

  </div>

}


