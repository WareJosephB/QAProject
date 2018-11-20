import React, {Component} from 'react';
import {getPlayer, addPlayer, updatePlayer} from './playerFunctions.jsx'

export default class Player extends Component {
    constructor(props){
        super(props);
        this.state = {player : 0, playerName : "Player Name"};
    }

    handleClick = () => {
        this.setState({player : document.getElementById('Player ID').value});
        var data = getPlayer();
        this.setState({player : data.playid, playerName : data.name});
    }
    
    render(){
        return(
            <div>
                <div className="APF" id="Add Player Fields">
                    <form id='addPlayerForm' onSubmit={addPlayer}>
                        <input className="half" id='New Name' type='text' placeholder='Player Name'/>
                        <input className="half" id='Add Player' type='submit' value='Add Player'/>
                        <br/>
                        <p id = 'confirmAP'></p>
                    </form>
                </div>
                <div className="UPF" id="Update Player Fields">
                    <form id='updatePlayerForm' onSubmit = {updatePlayer}>
                        <input className="quarter" id = 'Player ID' type = 'number' placeholder = 'Player ID Number' ref='playId' />
                        <input className="quarter" id = "Get Player to Update" type = 'button' value = 'Choose Player to Update' onClick={this.handleClick} />
                        <input className="quarter" id = 'Update Name' type = 'text' placeholder={this.state.playerName}/>
                        <input className="quarter" if = "Update Player" type = 'submit' value = 'Confirm Update'/>
                    </form>
                </div>
            </div>
        );
    }
}                    