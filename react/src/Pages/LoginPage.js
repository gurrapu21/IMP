import { useDebugValue, useState, useEffect}  from "react";
import Login from "../Login";
import { keyboard } from "@testing-library/user-event/dist/keyboard";
import UserPage from "./UserPage";
import { Link, useNavigate } from "react-router-dom";
// import {setPage} from "./App";

function login(userid , password){

    return fetch('http://localhost:8080/login',{
        method : "post",
        headers : { 'content-Type' : 'application/json'},
        body: JSON.stringify({userId: userid, password: password})
    }).then(data => data.json()).then(data => data.msg);

}

function LoginPage(props) {


    

    const [userid,setUserid] = useState('');
    const [password, setPassword] = useState('');
    const [msg,setMsg] = useState('');
    var name;
    
    
    const navigate = useNavigate();

    const handleSubmit = (e) => {

        e.preventDefault();
        const response = login(userid, password);
        response.then((d) => {

            if(d.includes('@')){
                [d,name] = d.split('@');
                sessionStorage.setItem('name',name);
            }

            if(d === 'admin' || d === 'user') {

                sessionStorage.setItem('userID',userid);
                sessionStorage.setItem('login',true);
                sessionStorage.setItem('role',d);
                window.location.href = '/';
                
            }
            else setMsg(d);
        });
        
        
    }

    const handleChange = (e,change) => {
        change(e.target.value);
    }
    
    

    
  

   

    

    return <div class="main">
        
                            <div class="login-container">
                        <div class="form-container login-container">
                            <form onSubmit={handleSubmit} id="login-form">
                                <h2>Login</h2><br/>
                                {/* <label>Username : </label> */}
                                <input className="loginInput" placeholder="username" type="text" name="uname" onChange={(e) =>  handleChange(e,setUserid)} required='required'/><br/>
                                {/* <label>Password : </label> */}
                                <input className="loginInput" placeholder="password" type="password" name = "password" onChange={(e) => handleChange(e,setPassword)} required='required'/><br/><br/>
                                <button className="loginButton" type="submit" name="submit">Login</button><br/>
                                <div id="msg">{msg}</div>
                                <Link to = '/forgotPassword' >Forgot Password</Link>
                            </form>
                            
                        </div>
                    </div>

    </div>
}

export default LoginPage