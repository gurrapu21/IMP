import { useState } from "react"






export default function RegistrationPage() {

    const [response,setResponse] = useState('');
    const[uname,setUname] = useState('');
    const[phone,setPhone] = useState('');
    const[email,setEmail] = useState('');
    const[dob,setDob] = useState('');
    const[role,setRole] = useState('');
    const[password, setPassword] =  useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        fetch('http://localhost:8080/register', {
            method: "post",
            headers: {'content-Type':'application/json'},
            body: JSON.stringify({
                name: uname,
                phone: phone,
                email: email,
                role: role,
                dob: dob,
                password: password
            })
        }).then(data => data.json().then(json => setResponse(json.msg)))

    };

    return <div class="r-main">
        
            <div class="r-container">
                
            <header>Registration Form</header>
      <form action="#" class="form" onSubmit={handleSubmit}>
        <div class="input-box">
          <label>Full Name</label>
          <input className="r-input" type="text" name="uname" onChange={e => setUname(e.target.value)} required/>
        </div>

        <div class="input-box">
          <label>Email Address</label>
          <input className="r-input" type="email" name = "email" onChange={e => setEmail(e.target.value)} required/>
        </div>

        <div class="column">
          <div class="input-box">
            <label>Phone Number</label>
            <input className="r-input" type="text" name = "phone" onChange={e => setPhone(e.target.value)} required/>
          </div>
          <div class="input-box">
            <label>Birth Date</label>
            <input className="r-input" type="date" name = "dob" onChange={e => setDob(e.target.value)} required/>
          </div>
        </div>
        
	<div class="input-box">
	    <label>Role</label>
            <div class="select-box">
            
              <select name='role' onChange={e => setRole(e.target.value)} required>
                    <option hidden>ROLE</option>
                    <option value='admin'>ADMIN</option>
                    <option value='user'>USER</option>
            	</select>
            </div>
	</div>
	<div class="input-box">
          <label >Password</label>
          <input className="r-input" type="password" name = "password" onChange={e => setPassword(e.target.value)} required/>
    </div>

        <button>Submit</button>
        <div id="msg">{response}</div>
      </form>
        </div>
        
        
       

    </div>
    
    


}
