
import Axios from 'axios';
import React from 'react';
import ReactDOM from 'react-dom';
import Fields from './fields.jsx';

const url = 'http://localhost:';
const port = '8080';
const rest = '/MultiplayerELO/access/game/';

const base = url+port+rest;

export const add = 'add/';
export const get = 'get/';
export const All = 'getAll/';
export const up = 'update/';
export const del = 'delete/';

export const generateFields = () => {
    ReactDOM.render(<Fields data=''/>, document.getElementById('NG'));
    document.getElementById('NG').innerHTML+= "<input type='submit' value='Add Game and Update ELO'/>";
}

// getScores = () => {
//     var scores = "[";
//     var numPlayers = document.getElementById('numPlayers');
//     for (var place = 1; place <= numPlayers; place++){
//         if (place != 1){
//             scores += ", ";
//         }
//         scores+= "{ player:" + document.getElementById('player'+place+'name').value + ", score:"+document.getElementById('player'+place+'score').value +"}";
//     }
//     scores += "]";
//     return scores;
// }

// this.getScores = () => {
//     var scores = "[";
//     var numPlayers = document.getElementById('numPlayers').value;
//     for (var place = 1; place<=numPlayers; place++){
//         if (place !== 1){
//             scores += ", ";
//         }
//         scores += "{player:" + {document.getElementById('player'+place).getState.Player} + ", " + this.getEtc(place) + "}";
//     }
//     scores += "]";
//     return scores;
// }

// this.getEtc = (place) => {



// }

export const addGame = (event) => {
        event.preventDefault();
        Axios.post(base+add, {
            map : document.getElementById('NGmap'),
            P: document.getElementById('NGP'),
            C: document.getElementById('NGC'),
            V: document.getElementById('NGV'),
            generations: document.getElementById('NGGenerations'),
            scores : this.getScores(),
            colonies : this.getColonies()
        }).then(function(response) {
            document.getElementById('output').innerHTML = response.message
            console.log(response);
        });
    }

export const getGame = (event) => {
    event.preventDefault();
    Axios.get(base+get+document.getElementById('gameId').value).then(function(response) {
        document.getElementById('output').innerHTML = response;
    });
}