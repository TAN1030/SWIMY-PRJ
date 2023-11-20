import React, { useState, useEffect } from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';
//import TodoReact from './TodoReact.js'
import TodoReact from './Todo'
import AwesomeGreeting from './Awesome'
import ClickCounter from './ClickCounter'

function App() {
  const [message, setMessage] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [lives, setLives] = useState([]);
  const [page, setPage] = useState(1);




  useEffect(() => {
    fetch('/test/hello')
      .then(response => response.text())
      .then(message => {
        setMessage(message); //  {message} 
      });
  }, [])


  return (
    <div className="App"> 
      Hello React!
      <div>
        컴포넌트 분리하기 1 : TodoReact
        <TodoReact></TodoReact>
      </div>


      <div>
        컴포넌트 분리하기 2 : props 를 전달하기
         - props 는 파라미터성
        <AwesomeGreeting username="Kim K"/>
        <AwesomeGreeting username="You H"/>
        <AwesomeGreeting username="Hong O"/>
      </div>


      <div>
        컴포넌트 분리하기 3: ClcikCounter 만들기 + 리액트 렌더링 순서그려보기
        <ClickCounter/>
         - 보완점 확인하기 (40:00)
      </div>

      <button className='btn btn-primary' onClick={() => {
        axios.get('https://jsonplaceholder.typicode.com/posts').then((result) => {
          console.log(result.data);
        })
          .catch(() => {
            console.log('fail');
          })
      }}>더보기</button>

    </div>
  );
}

export default App;
