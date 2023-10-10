
import { useState } from 'react';
import {Link, useNavigate} from 'react-router-dom';


export default function Navbar(props) {

  const navigate = useNavigate();
  const [navElem, setNavElem] = useState();

  const handleLogout = () => {
    sessionStorage.clear();
    window.location.href = '/'

  }

   console.log(sessionStorage.getItem('role'));
   
    return <nav className="navbar">
    <div className="container">

      <p class="logo" href="#">Inventory Management System</p>

      <div className="navbar-header">
        
        
      </div>
      <ul className="nav-links">
      
      {props.login ? (
          props.role == 'user' ?
            <li><a  href="http://localhost:3000">Inventory</a> </li>:
            <li><a  href="http://localhost:3000">Edit Inventory</a></li>
          ) : (
              ""
          )}

      {props.login ? (
        props.role == 'user' ?
            <li className="active"><Link to="/orders">Orders</Link></li> : <li className="active"><Link to="/AddItems">Add Items</Link></li>
          ) : (
              ""
          )}
        
        
        {props.login ? (
            <li> <Link onClick={handleLogout}>Logout</Link> </li>
          ) : (
              <li> <Link to="/login">Login</Link> </li>
          )}
          

        {props.login? (
            ""
          ) : (
              <li> <Link to="/register">Register</Link> </li>
              
          )}
        <li><Link to="/help">Help</Link></li>

        
      </ul>
    </div>
  </nav>
}