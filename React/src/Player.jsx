import React, {Component} from 'react';
import {getPlayer, addPlayer} from './playerFunctions.jsx'

export default class Player extends Component {

    render(){
        return(
            <div>
                <div>
                    <form onSubmit={addPlayer}>
                        <input id='newName' type='text' placeholder='Player Name'/>
                        <input type='submit' value='Add Player' /><p id = 'confirm'></p>
                    </form>
                </div>
                <div>
                    <p id='playerUp'></p>
                    <form onSubmit = {getPlayer}>
                        <input id = 'playId' type = 'number' placeholder = 'Player ID Number'/><br/>
                        <input type = 'submit' value = 'Update Player' />
                    </form>
                </div>
            </div>
        );
    }
}


                    