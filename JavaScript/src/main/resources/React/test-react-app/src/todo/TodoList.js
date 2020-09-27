import React from 'react';
import TodoItem from './TodoItem.js';
import PropTypes from 'prop-types';


const styles = {
    ul: {listStyle: 'none', margin: 0, padding: 0}
};

function TodoList(args) {
    return (
        <ul style={styles.ul}>
            {args.todos.map((todo, index) => {
                return <TodoItem
                    todo={todo}
                    key={todo.id} // добавляем рекомендуемое значения key для итерируемых объектов в react
                    index={index}
                    onToggle={args.onToggle}/>
            })}
        </ul>
    )
}

TodoList.propTypes = {
    todos: PropTypes.arrayOf(PropTypes.object).isRequired,
    onToggle: PropTypes.func.isRequired
};

export default TodoList;

