import React from 'react';
import axios from 'axios';
import {render} from 'react-dom';
import TopTable from './topTable.jsx';

const url = 'http://localhost:';
const port = '8080';
const rest = '/MultiplayerELO/access/player/';

const base = url+port+rest;

export const add = 'add/';
export const get = 'get/';
export const All = 'getAll/';
export const up = 'update/';
export const del = 'delete/';

export const addPlayer = (event) => {
        event.preventDefault();
        axios.post(base+add, {
            name : document.getElementById('newName').value
        }).then(response => {
            document.getElementById('confirmAP').innerHTML = response.data.message;
        }).catch(function (error) {
            console.log(error)
        })
    window.location.reload();
    }

export const getPlayer = (event) => {
    event.preventDefault();
    document.getElementById('updatePlayerForm').innerHTML+="<input id = 'updateName' type = 'text'/><input type = 'submit' value = 'Confirm Update'/><p id = 'confirmUP'></p>";
    axios.get(base+get+document.getElementById('playId').value).then(response => {
        document.getElementById('updatedName').placeholder=(response.data.name);
        }).catch(function (error) {
            console.log(error)
        })
    }

export const getAll = (event) => {
    axios.get(base+All).then(response => {
        render(<TopTable data={response.data}/>, document.getElementById('output'));
        }).catch(function (error) {
            console.log(error)
        })
    }

export const deletePlayer = (event) => {
    axios.delete(base+del+event).then(response => {
        document.getElementById('confirm').innerHTML = response.data.message;
        }).catch(function (error) {
            console.log(error)
        })
    window.location.reload();
    }

export const updatePlayer = (event) => {
    event.preventDefault();
    axios.post(base+up+document.getElementById('playId').value, {
        name : document.getElementById('updateName').value
    }).then(response => {
        document.getElementById('confirmUP').innerHTML = response.data.message;
    }).catch(function (error) {
        console.log(error)
    })
    window.location.reload();
    }