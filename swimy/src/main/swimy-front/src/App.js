import React, {useState, useEffect} from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

function App() {
  const [message, setMessage] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [lives, setLives] = useState([]);
  const [page, setPage] = useState(1);

  const [todos, setTodos] = useState([
    {
      id :1,
      text: 'React 공부하기',
      isCompeted: false
    },
    {
      id :2,
      text: 'React 복습하기',
      isCompeted: false
    },
    {
      id :3,
      text: 'React 토이프로젝트',
      isCompeted: false
    }
  ]);



  useEffect(() => {
    fetch('/test/hello')
        .then(response => response.text())
        .then(message => {
            setMessage(message); //  {message} 
        });
  },[])

  const handleClick = (index) => {
    const nextTodos = [...todos]
    //nextTodos[index].isCompeted = true
    nextTodos[index].isCompeted  = !nextTodos[index].isCompeted // true

    setTodos(nextTodos)
  }
  return (
    <div className="App">

      Hello React!
      <ul>
        {todos.map((todo, i) => (
          <li key={todo.id} onClick={() => handleClick(i)}>
               {todo.isCompeted ? '💚': ''} {todo.text}
          </li>
        ))}
      </ul>
    
  

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
