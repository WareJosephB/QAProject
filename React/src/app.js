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
        axios.post(playroot + 'add',
          {
            name : document.getElementById('newName').value,
          }).then(function(response) {
            document.getElementById('output').src = response.message;
            console.log(response);
            }
        )
    }

    addPlayer = (event) => {
        event.preventDefault();
        axios.get(playroot+document.getElementById('playId').value)
          .then(function(response) {
            document.getElementById('output').src = response.message;
            console.log(response);
            }
        )
    }

    parsePlayer(JSON){

    }

    findGame = (event) => {
        event.preventDefault();
        axios.get(gameroot+document.getElementById('gameId').value)
          .then(function(response) {
            document.getElementById('output').src = response;
            console.log(response);
            }
        )
    }

    render() {
        return (
            <div>
                <div>
                    <form onSubmit={this.addPlayer}>
                        <input id='newName' type='text' placeholder='Player Name'/><br/>
                        <input type='submit' value='Add Player' />
                    </form>
                </div>
                <br/><br/><br/><br/><br/>
                <div>
                    <form onSubmit = {this.findPlayer}>
                        <input id = 'playId' type = 'number' placeholder = 'Player ID Number'/><br/>
                        <input type = 'submit' value = 'Find Player by ID' />
                    </form>

                    <form onSubmit = {this.findGame}>
                        <input id = 'gameId' type = 'number' placeholder = 'Game ID Number'/><br/>
                        <input type = 'submit' value = 'Find Game by ID'/>
                    </form>

                    <div id = 'output'>
                    </div>

                </div>
            </div>

        )
    }
}

export default App
