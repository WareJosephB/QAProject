import React, {Component} from 'react';
import Player from './player.jsx';
import Game from './game.jsx';
import TopTable from './topTable.jsx';

export default class App extends Component {
    
    render() {
        return (
            <div className='CC' id='contentContainer'>
                <div id='player'>
                    <TopTable id='TopELOTable'/>
                    <Player id='add/update Player'/>
                </div>
                <div id='game' className='game'>
                    <Game id='add/update Game'/>
                </div> 
            </div>
        );
    }
}