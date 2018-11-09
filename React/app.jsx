import React, {Component} from 'react';
import axios from 'axios';


const url = 'localhost:';
const port = '8080';
const gameroot = url+port+'/game/';
const playroot = url+port+'/player/'
const scoreroot = url+port+'/score/'

class App extends Component {
        
    findPlayer = (event) => {
        event.preventDefault();
        axios.get(playroot+document.getElementById("playId").value)
          .then(function(response) {
            document.getElementById('output').src = playerParse(response);
            console.log(response);
            }
        )
    }

    findGame = (event) => {
        event.preventDefault();
        axios.get(gameroot+document.getElementById("gameId").value)
          .then(function(response) {
            document.getElementById('output').src = gameParse(response);
            console.log(response);
            }
        )
    }

    render() {
        return (
            <div>
                <form onSubmit={this.findPlayer}>
                    <input id="playId" type="number" placeholder="Find Player"/><br/>
                    <input type="submit" value="Submit" />
                </form>
                <form onSubmit={this.findPlayer}>
                    <input id="gameId" type="number" placeholder="Find Game"/><br/>
                    <input type="submit" value="Submit" />
                </form>

                <div id = 'output'></div>
            </div>
        )
    }
}

export default App
