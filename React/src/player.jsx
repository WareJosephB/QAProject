import React, {Component} from 'react';
import {getPlayer, addPlayer, updatePlayer} from './playerFunctions.jsx'

export default class Player extends Component {

    render(){
        return(
            <div>
                <div className="APF">
                    <form id='addPlayerForm' onSubmit={addPlayer}>
                        <input className="half" id='newName' type='text' placeholder='Player Name' />
                        <input className="half" type='submit' value='Add Player' />
                        <p id = 'confirmAP'></p>
                    </form>
                </div>
                <div className="UPF">
                    <form id='updatePlayerForm' onSubmit = {updatePlayer}>
                        <input className="quarter" id = 'playId' type = 'number' placeholder = 'Player ID Number' />
                        <input className="quarter" type = 'button' value = 'Update Player' onClick={getPlayer} />
                    </form>
                </div>
            </div>
        );
    }
}                    