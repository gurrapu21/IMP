import { useEffect, useState } from "react";

export default function Orders(props){

    const login = sessionStorage.getItem('login');

    const [orders,setOrders] = useState();

    const [msg, setMsg] = useState('');

    useEffect(() => {
        console.log('http://localhost:8080/getOrders/'+sessionStorage.getItem('userID'));
        fetch('http://localhost:8080/getOrders/'+sessionStorage.getItem('userID'),
           {method : 'get'}
        ).then(data => {
            if(data.ok){
                setMsg('');
                data.json().then(data => displayOrders(data));
            } else 
                setMsg("No Orders");
        })
    },[])


    const displayOrders = (data) => {
        setOrders(
            data.map((data) => 
                <tr>
                    <td>{data.orderId}</td>
                    <td>{data.localDate.slice(0,10)}</td>
                    <td>{data.localTime}</td>
                    <td>{data.locationNumber}</td>
                    <td>{data.materialId}</td>
                    <td>{data.orderQuantity}</td>
                    <td>{data.orderStatus}</td>
                </tr>
            )
        )
    }


    return login ? 
        
        <div className="orders">
            <table>
                <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Location Number</th>
                    <th>Material Name</th>
                    <th>Order Quantity</th>
                    <th>Order Status</th>
                </tr>
                </thead>
                <tbody>
                    {orders}
                </tbody>
            </table>
            <br/><br/>
        <div id="msg">{msg}</div>
            </div> :
                window.location.href = '/login';

}