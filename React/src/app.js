import React, {Component} from 'react';
import Player from './Player.jsx';
import Game from './Game.jsx';
import TopTable from './topTable.jsx';

export default class App extends Component {

    render() {
        return (
            <div>
                <div id="player">
                    <TopTable />
                    <Player />
                </div>
                <div id="game">
                    <Game />
                </div> 
            </div>
        );
    }
}
