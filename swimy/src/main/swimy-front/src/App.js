import React, {useState, useEffect} from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    fetch('/test/hello')
        .then(response => response.text())
        .then(message => {
            setMessage(message);
        });
  },[])
  return (
    <div className="App">
       <header className="App-header">
              <img src={logo} className="App-logo" alt="logo"/>
              <h1 className="App-title">{message}</h1>
      </header>
      <p className="App-intro">
              To get started, edit <code>src/App.js</code> and save to reload.
      </p>
 
        <button className='btn btn-primary' onClick={()=>{
          axios.get('https://jsonplaceholder.typicode.com/posts').then((result)=>{
            console.log(result.data);
          })
          .catch(()=>{
            console.log('fail');
          })
        }}>더보기</button> 


    </div>
  );
}

export default App;
