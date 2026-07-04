const Student = (props) => {

    const {firstName, lastName, email} = props
    return (
        <div>

        <h1>Student Details</h1>
        <p>Student First Name: {firstName}</p>
        <p>Student Last Name: {lastName}</p>
        <p>Student email: {email}</p>
        </div>
    )
    
}


export default Student;