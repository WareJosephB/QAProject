import React, {Component} from 'react';
import {game} from './const.jsx';
import Axios from 'axios';

export default class GameForm extends Component {

    changeELO = (event) => {
        event.preventDefault();
        console.log({
            player1 : parseInt(document.getElementById('player1').value),
            player2 : parseInt(document.getElementById('player2').value)
        })
        Axios.post(game+"match", {
                player1 : parseInt(document.getElementById('player1').value),
                player2 : parseInt(document.getElementById('player2').value)
            }).then(response => {
                console.log(response);
                document.getElementById('Confirm Player').innerHTML = response.data.message;
            })
            window.location.reload();
        }
    
    render(){
        return (
            
            <form onSubmit={this.changeELO}>
                <input type='number' id='player1' placeholder='Winner ID'/>
                <input type='number' id='player2' placeholder='Loser ID'/>
                <br/> <input type='submit' value='Add Match'/>
            </form>

        );
    }
}