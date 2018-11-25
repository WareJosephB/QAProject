import React, {Component} from 'react';
import GameForm from './gameForm.jsx';
import {addGame} from './gameFunctions.jsx';

export default class Game extends Component {
    render(){
        return(
            <div>
                <GameForm onSubmit={addGame}/>
                <p id = 'Confirm Game'></p>
            </div>
        )
    }
}
