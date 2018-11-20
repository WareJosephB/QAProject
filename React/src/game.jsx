import React, {Component} from 'react';
import {getGame, addGame, generateFields} from './gameFunctions.jsx'

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
                <form onSubmit = {addGame}>
                    <input type = 'button' value='Add Game' id = 'begin adding game' onClick={generateFields}/>
                    <div id='NG'></div>
                </form>
            </div>
        )
    }
}