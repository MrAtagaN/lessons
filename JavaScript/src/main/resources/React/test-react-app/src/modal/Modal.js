import React from 'react';
import './Modal.css';


export default class Modal extends React.Component {

    state = {
        isOpen: false
    };

    render() {
        return (
            // <React.Fragment> чтобы реакт не добавлять корневых элементов
            <React.Fragment>
             <button onClick={() => {this.setState({isOpen: true})}}>Open modal</button>
                {this.state.isOpen &&  <div className='modal'>
                    <div className='modal-body'>
                        <h1> Modal title</h1>
                        <button onClick={() => {this.setState({isOpen: false})}}>Close model</button>
                    </div>
                </div>}
            </React.Fragment>
        )
    }
}