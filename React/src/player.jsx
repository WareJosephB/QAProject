import React, {Component} from 'react';
import {getPlayer, addPlayer, updatePlayer} from './playerFunctions.jsx'

export default class Player extends Component {
    constructor(props){
        super(props);
        this.state = {player : 0, playerName : 'Player Name', buttonWorks : false};
    }

    handleClick = () => {
        var data = getPlayer(document.getElementById('Player ID').value);
        this.setState({player : data.playid, playerName : data.name, buttonWorks : true});
    }
    
    render(){
        return(
            <div id = 'playerfields'>
                <form id='addPlayerForm' onSubmit={addPlayer}>
                    <input className='half' id='New Name' type='text' placeholder='Player Name'/>
                    <input className='half' id='Add Player' type='submit' value='Add Player'/>
                </form>
                <form id='updatePlayerForm' onSubmit = {updatePlayer}>
                    <input className='quarter' id = 'Player ID' type = 'number' placeholder = 'Player ID Number' ref='playId' />
                    <input className='quarter' id = 'Update Name' type = 'text' placeholder={this.state.playerName}/>
                    <input className='quarter' id = 'Update Player' type = 'submit' value = 'Change name of Player' disabled={this.state.buttonWorks}/>
                </form>
                <br/>
                <p id = 'Confirm Player'></p>
            </div>
        );
    }
}