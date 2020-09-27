import React, {useEffect} from 'react';
import './App.css';
import TodoList from './todo/TodoList';
import Context from './context';
import Loader from './Loader';
import Modal from './modal/Modal'

function App() {
    // React.useState используется для ререндера объекта в React, возвращает массие из 2х элементов
    // первый объект у которого будет менятся состояние, второй функция которая будет менять состояние,
    // функция возвращает новый объект (обновлённый) и объект перерисовывается
    const [todos, setTodos] = React.useState([]);
    const [loading, setLoadng] = React.useState(true);

    const AddTodo = React.lazy(() => import('./AddTodo')); // ленивая загрузка компонента,
                                                                  // компонент должен быть внутри React.Suspense

    useEffect(() => {fetch('https://jsonplaceholder.typicode.com/todos?_limit=5')
        .then(response => response.json())
        // setTimeout эмитируем задержку загрузки данных
        .then(todos => {setTimeout(() => {setTodos(todos); setLoadng(false)}, 2000)})} ,[]);

    function todoToggle(id) {
        setTodos(todos.map(todo => {
            if (id === todo.id) {
                todo.completed = !todo.completed;
            }
            return todo;
        }));
    }

    function removeTodo(id) {
       setTodos(todos.filter(todo => todo.id !== id));
    }

    function onCreate(title) {
        setTodos(todos.concat({id: Date.now(), completed: false, title: title}));
    }

    return (
        // кладём в контекст 'Context' функцию
        <Context.Provider value={{removeTodo}}>
        <div className="wrapper">
            <h1>React App</h1>
            <Modal/>
            <React.Suspense fallback={<p>Loading...</p>}>
                <AddTodo onCreate={onCreate}/>
            </React.Suspense>
            {loading && <Loader/>}
            {todos.length === 0 ? (loading ? null : 'No todos') : <TodoList todos={todos} onToggle={todoToggle}/> }
        </div>
        </Context.Provider>
    );
}

export default App;
