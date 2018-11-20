import React, {Component} from 'react';
import {getGame, addGame} from './gameFunctions.jsx'

export default class Game extends Component {
    
    render(){
        return(
            <div>
                <form id = "NG">
                    {/* <input type = 'button' className = "leftButton" id = 'initAddGame' onClick={generateFields()}>Add Game</input>; */}
                </form>
                <form onSubmit = {getGame}>
                    <input id = 'gameId' type = 'number' placeholder = 'Game ID Number'/>
                    <input type = 'submit' value = 'Find Game by ID'/>
                </form>
                    <div id = 'output'>
                    </div>
            </div>
        )
    }
}