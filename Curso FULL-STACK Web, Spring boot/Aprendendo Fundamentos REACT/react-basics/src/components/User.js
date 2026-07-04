import { useState } from "react"

const User = () => {

    // const [firstName, setFirstName] = useState('Neymar')
    // const [lastName, setLastName] = useState('Junior')
    // const [email, setEmail] = useState('neymarjunior@gmail.com')

    const [user,setUser] = useState({
        firstName: "Vitor",
        lastName: "Scholze",
        email: "vitorscholze@gmail.com"
    })

    function updateUser(){
        // setFirstName('Ney')
        // setLastName('Santos')
        // setEmail('ney@gmail.com')
        setUser({
            firstName: 'Vi',
            lastName: 'Scholze',
            email: 'vischolze@gmail.com'
        })
    }

    return (
        <div>
            <h1>User Details</h1>
            <p>{user.firstName}</p>
            <p>{user.lastName}</p>
            <p>{user.email}</p>

            <button onClick={updateUser}>Upadte User</button>
        </div>
    )
}

export default User