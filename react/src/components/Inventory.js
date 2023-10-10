import {  useState } from "react"

export default function Inventory(props){

    const [locNum, setLocNum]  = useState('');
    const [matID, setMatID]  = useState('');
    const [inv, setInv] = useState();
    const [msg, setMsg] = useState('');  

    const setInvenotory= (data)=>{
        if(matID === ''){
            setInv(data.map((data) => <tr>
                <td>{data.locationNumber}</td>
                <td>{data.materialNumber}</td>
                <td>{data.availableQuantity}</td>
                <td><input className="field" type='number' id={'qnt'+data.materialNumber} onChange={(e)=>data.availableQuantity = e.target.value} required/></td>
                <td><button onClick={() => handleOrder(data.locationNumber,data.materialNumber,'qnt'+data.materialNumber)}>Order</button></td>
            </tr>))
        }else
        setInv(
            <tr>
                <td>{data.locationNumber}</td>
                <td>{data.materialNumber}</td>
                <td>{data.availableQuantity}</td>
                <td><input className="field" type='number' id={'qnt'+data.materialNumber} onChange={(e)=>data.availableQuantity = e.target.value}  required/></td>
                <td><button onClick={() => handleOrder(data.locationNumber,data.materialNumber,'qnt'+data.materialNumber)}>Order</button></td>
            </tr>
        )
    }

    const getInv = () => {

        if(matID === '')
            fetch('http://localhost:8080/getInventorys/'+locNum)
            .then(data => {
                if(data.ok) {
                    data.json().then(data => setInvenotory(data));
                    
                    }
                else{
                    setInv('');
                    setMsg("No Data Found");
            }})
        else    
            fetch('http://localhost:8080/getInventory/'+locNum+'/'+matID)
            .then(data => {
                if(data.ok) {
                    data.json().then(data => setInvenotory(data));
                    }
                else{
                    setInv('');
                    setMsg("No Data Found");
            }})

    }
    
    const handleOrder = (l,m,id) => {

        var q = document.getElementById(id).value;
        fetch('http://localhost:8080/order/'+sessionStorage.getItem('userID')+'/'+l+'/'+m+'/'+q,{
            method:'post'
        })
        .then(data => data.json()
        .then(data => {setMsg(data.msg + ' *** '+ m + ', Quantity ' + q + ' *** ');
                        getInv();}));
        
    }
    
    

    const handleSubmit = () => {
        getInv();
    }

   
    return <div>
        <label>Location ID :</label>
        <input className="field" type='text' name='locID' onChange={(e) => setLocNum(e.target.value)} required='required'/>
        <label>Material ID :  </label>
       <input className="field" type='text' name='matID' onChange={(e) => setMatID(e.target.value)}/><br/><br/>
       <button onClick={()=>handleSubmit()}>Get Inventory</button><br/><br/><br/>

       <table>
            <thead>
            <tr>
                <th>Location Number</th>
                <th>Material Name</th>
                <th>Available Quantity</th>
            </tr>
            </thead>
            <tbody>
                {inv}
            </tbody>
        </table>
        <br/><br/>
        <div id="msg">{msg}</div>
    </div>
}


