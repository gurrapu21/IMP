import { useState } from "react"

export default function AddItems(props){

    const [item,setItem] = useState({locNum : 0, matId : '', qty : 0});

    const [msg, setMsg] = useState('');

    const addItem = () => {

        console.log(item);
        let date = new Date().toJSON().slice(0, 10);

        if(item.locNum === 0 || item.matId === '' || item.qty in [0,''] )
            setMsg('Enter Inputs')
        else
            fetch( 'http://localhost:8080/addItem', {
                method : 'POST',
                headers : {'content-type' : 'application/JSON'},
                body : JSON.stringify({

                    availableQuantity : item.qty,
                    locationNumber : item.locNum,
                    materialId : item.matId,
                    orderQuantity : 0,
                    resetQty : item.qty,
                    updateDate : date
                })
                
        }).then(data => data.json()).then(json => setMsg(json.msg))

    }

    return <div id="addItems">
        <table>
            <tr>
                <th>Location Number</th>
                <th>Material Name</th>
                <th>Quantity</th>
            </tr>
            <tr>
                <td><input className="field" required='required' type='number' name='locNum' onChange={e => setItem({locNum : e.target.value, matId : item.matId, qty : item.qty})}></input></td>
                <td><input className="field" required='required' type='text' name='matId' onChange={e => setItem({locNum : item.locNum, matId : e.target.value, qty : item.qty})}></input></td>
                <td><input className="field" required='required' type='number' name='qty' onChange={e => setItem({locNum : item.locNum, matId : item.matId, qty : e.target.value})}></input></td>
                
            </tr>
        </table>
        <button onClick={addItem}>Add</button>

        <div id="msg">{msg}</div>

    </div>

}