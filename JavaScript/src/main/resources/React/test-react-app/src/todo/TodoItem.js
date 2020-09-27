import React, {useContext} from 'react';
import PropTypes from 'prop-types';
import Context from '../context';

function TodoItem({todo, index, onToggle}) { // {} в аргументах сразу забирают значение из переданного объекта по указанному ключу (todo)
    console.log('todo', todo);

    // const classes = [];

    let done;

    // if (todo.completed) {
    //     classes.push('done');
    // }

    if(todo.completed) {
        done = 'done'
    }

    const {removeTodo} = useContext(Context); // получаем из ранее созданного контекста переданную функцию

    return <li>
        <span className={done}>
            <input type='checkbox' checked={todo.completed} onChange={() => {
                onToggle(todo.id)
            }}/>
            <strong>{index + 1}</strong>
            {todo.title}
            <button className='rm' onClick={() => removeTodo(todo.id)}>&times;</button>
        </span>
    </li>
}

TodoItem.propTypes = {
    todo: PropTypes.object.isRequired,
    index: PropTypes.number,
    onToggle: PropTypes.func.isRequired
};

export default TodoItem;