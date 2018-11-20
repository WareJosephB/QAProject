import React, {Component} from 'react';
import Player from './player.jsx';
import Game from './game.jsx';
import TopTable from './topTable.jsx';

export default class App extends Component {

    render() {
        return (
            <div className="CC">
                <div id="player">
                    <TopTable />
                    <Player />
                </div>
                <div id="game" className="game">
                    <Game />
                </div> 
            </div>
        );
    }
}