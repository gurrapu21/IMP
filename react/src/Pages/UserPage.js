import Inventory from "../components/Inventory";
import Orders from "../components/Orders";
import {Route,Routes} from 'react-router-dom';



export default function UserPage() {
    const login = Boolean(sessionStorage.getItem('login'));
    return login ? <div>
                <h1>Welcome {sessionStorage.getItem('name')}!!!</h1>
                <Routes>
                  <Route path='/' element={<Inventory></Inventory>}></Route>
                  <Route path='/orders' element={<Orders></Orders>}></Route>
                </Routes>

            </div> :
                window.location.href = '/login';
}