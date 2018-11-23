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
                <GameForm onSubmit={addGame}/>
                <p id = 'Confirm Game'></p>
            </div>
        )
    }
}