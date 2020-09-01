import React from 'react';

export default function TodoItem ({todo, index}) { // {} в аргументах сразу забирают значение из переданного объекта по указанному ключу (todo)
    return <li>{index + 1} {todo.title}</li>
}