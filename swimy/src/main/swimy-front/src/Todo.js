import React, { useState } from "react";


function Todo() {
    const [todos, setTodos] = useState([
        {
            id: 1,
            text: 'React 공부하기',
            isCompeted: false
        },
        {
            id: 2,
            text: 'React 복습하기',
            isCompeted: false
        },
        {
            id: 3,
            text: 'React 토이프로젝트',
            isCompeted: false
        }
    ]);
    const handleClick = (index) => {
        const nextTodos = [...todos]
        //nextTodos[index].isCompeted = true
        nextTodos[index].isCompeted = !nextTodos[index].isCompeted // true

        setTodos(nextTodos)
    }

    return (
        <div className="Todo"> 
            <ul>
                {todos.map((todo, i) => (
                    <li key={todo.id} onClick={() => handleClick(i)}>
                        {todo.isCompeted ? '💚' : ''} {todo.text}
                    </li>
                ))}
            </ul>
        </div>
    );
                 
}
export default Todo;
