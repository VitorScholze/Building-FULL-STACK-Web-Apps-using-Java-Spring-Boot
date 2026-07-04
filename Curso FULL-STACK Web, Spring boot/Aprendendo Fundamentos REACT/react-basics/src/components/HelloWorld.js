import React from "react"

const HelloWorld = () => {

    function handleClick(){
        alert("button clicked!")
    }

    const name = "Vitor";
    const addition = 1 + 2;

    return (
        <div>
            <h1 className = "title">Title</h1>
            <h2>Sub Title</h2>
            <p>Paragraph</p>
            <p>{addition}</p>
            <p>{name}</p>
            <button onClick = {handleClick}>Click</button>
        </div>
    )
}

export default HelloWorld;