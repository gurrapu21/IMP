
import { useDebugValue, useState, useEffect}  from "react";
import { Link, useNavigate } from "react-router-dom";

export default function ForgotPassword(props) {


    const [userid,setUserid] = useState('');
    const [password, setPassword] = useState('');
    const [msg,setMsg] = useState('');
    const [otp,setOTP] = useState('');
    const [userOTP,setUserOTP] = useState('');
    const [newPw,setNewPw] = useState('');

    const handleChange = (e,change) => {
        change(e.target.value);
    }
    

    const getOTP = (e) => {
        e.preventDefault();
        fetch('http://localhost:8080/forgotPassword/' + userid,{
            method : 'POST'

    }).then(data => data.json()).then(data => setOTP(data.msg));
        console.log(otp);
        setMsg("Check Your Email");
    }

    const handleChangePassword = (e) => {
        e.preventDefault();
        if(otp === userOTP)
        fetch('http://localhost:8080/changePassword/' + userid +"/"+newPw,{
            method : 'POST'

    }).then(data => data.json()).then(data => setMsg(data.msg));
        else
        setMsg('OTP is Incorrect');
    }


    return <div class="main">
        <div class="login-container">
                                <div class="form-container login-container">
                                    <form onSubmit={handleChangePassword} id="login-form">
                                        <h2>Forgot Password</h2><br/>
                                        {/* <label>Username : </label> */}
                                        <input className="loginInput" placeholder="username" type="text" name="uname" onChange={(e) =>  handleChange(e,setUserid)} required='required'/><br/>
                                        {/* <label>Password : </label> */}
                                        
                                        <button className="loginButton"  onClick={getOTP}>Get OTP</button><br/>
                                        <div id="msg"></div>
                                        <input className="loginInput" placeholder="Enter OTP" type="text" name="uname" onChange={(e) =>  handleChange(e,setUserOTP)} required='required'/><br/>
                                        <input className="loginInput" placeholder="New Password" type="password" name="uname" onChange={(e) =>  handleChange(e,setNewPw)} required='required'/><br/>
                                        <button className="loginButton"  name="submit">Change Password</button>
                                        <div id="msg">{msg}</div>
                                        <Link to = '/login' >Login</Link>

                                    </form>
                                </div>
                            </div>

    </div>
}