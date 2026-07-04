import {useState} from 'react'

const ConditionalRendering = () => {

    const [isLoggedIn, setIsLoggedIn] = useState(false)

    function handleLogin(){
        setIsLoggedIn(true)
    }
    
    let message;
    if(isLoggedIn){
        message = <p>Welcome, User</p>
    }else{
        message = <p>Plese Login</p>
               
    }

    return(
        <div>
            {
                isLoggedIn && <p>Welcome, User</p>
            }

            <br/>

            <button onClick = {handleLogin}>Login</button>
        </div>
    )

}

export default ConditionalRendering