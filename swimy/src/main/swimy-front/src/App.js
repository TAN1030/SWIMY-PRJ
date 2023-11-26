import React, { useState, useEffect } from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';
//import TodoReact from './TodoReact.js'
import TodoReact from './01_Component/Todo'
import AwesomeGreeting from './01_Component/Awesome'
import ClickCounter from './01_Component/ClickCounter'
import Parent from './04_ParentChildTest/Parent'
import Layout from './05_Layout/Layout';
 

import { Routes, Route, BrowserRouter, useNavigate, Link } from "react-router-dom"



function App() {
  const [message, setMessage] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [lives, setLives] = useState([]);
  const [page, setPage] = useState(1);

    /* 
  const navigate = useNavigate(); 


  const LinkToPage =(uri) => {
    navigate(uri);
  }
*/

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
        1. 컴포넌트 분리하기 1 : TodoReact
        <TodoReact></TodoReact>
      </div>


      <div>
        2. 컴포넌트 분리하기 2 : props 를 전달하기 (부모→자식)
         - props 는 파라미터성
        <AwesomeGreeting username="Kim K"/>
        <AwesomeGreeting username="You H"/>
        <AwesomeGreeting username="Hong O"/>
      </div>


      <div>
        3. 컴포넌트 분리하기 3: ClcikCounter 만들기
        <ClickCounter/>
      </div>

      <div>
        4. 부모자식간의 데이터 전달하기
        <Parent />
      </div>

      <div>
        5. 페이지를 이동해서 Layout 처리 테스트하기 <br/>
        1) url에 /Layout 을 입력하면 이동하기
        <hr/>
        
        2) 버튼 이동 2
 
        3) props 나 state 넘겨보기
    

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
