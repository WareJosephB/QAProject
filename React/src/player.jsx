import React, {Component} from 'react';
import {getPlayer, addPlayer, updatePlayer} from './playerFunctions.jsx'

export default class Player extends Component {

    render(){
        return(
            <div>
                <div>
                    <form id='addPlayerForm' onSubmit={addPlayer}>
                        <input id='newName' type='text' placeholder='Player Name'/>
                        <input type='submit' value='Add Player' />
                        <p id = 'confirmAP'></p>
                    </form>
                </div>
                <div>
                    <form id='updatePlayerForm' onSubmit = {updatePlayer}>
                        <input id = 'playId' type = 'number' placeholder = 'Player ID Number'/>
                        <input type = 'button' value = 'Update Player' onClick={getPlayer}/>
                    </form>
                    <br/>
                </div>
            </div>
        );
    }
}                    