import React, {Component} from 'react';
import {addGame} from './gameFunctions.jsx'
import GameForm from './gameForm.jsx'

export default class Game extends Component {
    constructor(props){
        super(props);
        this.state = {numPlayers : 2};
    }
    
    getPlayers = () => {
        this.setState({numPlayers : this.value});
    }

    render(){
        return(
            <div>
                <select id='numPlayers' onSelect={this.getPlayers}>
                    <option value='2'>2 Player</option>
                    <option value='2'>3 Player</option>
                    <option value='2'>4 Player</option>
                    <option value='2'>5 Player</option>
                </select>
                <GameForm players={this.state.numPlayers} onSubmit={addGame}/>
                <div id = 'gamePlaceholder'></div>
                <p id = 'Confirm Game'></p>
            </div>
        )
    }
}