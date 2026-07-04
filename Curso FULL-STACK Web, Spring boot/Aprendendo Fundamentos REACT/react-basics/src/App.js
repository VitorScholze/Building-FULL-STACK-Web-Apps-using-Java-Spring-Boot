import logo from './logo.svg';
import './App.css';
import Welcome from './components/Welcome';
import Greeting from './components/Greeting'
import {FirstComponent as FC, SecondComponent} from './components/MyComponent';
import MC from './components/MyComponent';
import HelloWorld from './components/HelloWorld';
import Student from './components/Student';
import Employee from './components/Employee';
import User from './components/User';
import EventHandling from './components/EventHanding';
import ConditionalRendering from './components/CondicionalRendering';

function App() {

  // const student = {
  //   firstName: "Vitor",
  //   lastName :"Scholze",
  //   email :"vitorscholze@gmail.com"
  // }


  const skills = ['HTML', 'CSS', 'JavaScript']

  return (
    <div className="App">
      {/*<Welcome name = "Vitor"/>
      <Welcome name = "Neymar"/> */}

      {/*<Greeting name = "Vitor"/>
      <Greeting name = "Neymar"/>
      <FC/>
      <SecondComponent/>
      <MC/>*/}
      
      {/*<HelloWorld/>*/}
      {/* <Student
        data = {skills}/> */}


      {/* <Student
      firstName = "Neymar"
      lastName = "Junior"
      email = "neymarjunior@gmail.com"/> */}

      {/* <Employee/> */}

      {/* <User/> */}
      {/* <EventHandling/> */}

      <ConditionalRendering/>
    </div>
    


  );
}

export default App;
