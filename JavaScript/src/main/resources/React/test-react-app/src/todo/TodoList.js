import React from 'react';
import TodoItem from './TodoItem.js';

export default function TodoList(args) {
    return (
        <ul>
            {args.todos.map((todo, index) => {return <TodoItem todo={todo} key={todo.id} index={index}/>} )}
        </ul>
    )
}