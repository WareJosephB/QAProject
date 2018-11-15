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


export const addGame = (event) => {
        event.preventDefault();
        axios.post(base+add, {
        }).then(function(response) {
            document.getElementById('output').innerHTML = response.message
            console.log(response);
        });
    }

export const getGame = (event) => {
    event.preventDefault();
    axios.get(base+get+document.getElementById('gameId').value).then(function(response) {
        document.getElementById('output').innerHTML = response;
    })
}