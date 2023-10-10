import EditInventory from "../components/EditInventory";


export default function AdminPage(props) {
    
    const login = sessionStorage.getItem('login');
    return login ? <div>

                <h1>Welcome {sessionStorage.getItem('name')}!!!</h1>
                <EditInventory></EditInventory>
                
            </div> :
                window.location.href = '/login';

            
}