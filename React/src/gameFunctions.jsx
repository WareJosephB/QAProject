import axios from 'axios';

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
    document.getElementById("NG").innerHTML+= <Fields />;
    document.getElementById("NG").innerHTML+= <input type="submit">Add Game and Update ELO</input>;
}

getScores = () => {
    var scores = "[";
    var numPlayers = document.getElementById('numPlayers');
    for (var i = 1; i<=numPlayers;i++){
        if (i != 1){
            scores += ", ";
        }
        scores+= "{ player:" + document.getElementById('player'+place+'name').value + ", score:"+document.getElementById('player'+place+'score').value +"}";
    }
    scores += "]";
    return scores;
}

export const addGame = (event) => {
        event.preventDefault();
        axios.post(base+add, {
            map : document.getElementById('NGmap'),
            P: document.getElementById('NGP'),
            C: document.getElementById('NGC'),
            V: document.getElementById('NGV'),
            generations: document.getElementById('NGGenerations'),
            scores : this.getScores()
        }).then(function(response) {
            document.getElementById('output').innerHTML = response.message
            console.log(response);
        });
    }

export const getGame = (event) => {
    event.preventDefault();
    axios.get(base+get+document.getElementById('gameId').value).then(function(response) {
        document.getElementById('output').innerHTML = response;
    });
}