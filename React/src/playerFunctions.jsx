import React from 'react';
import axios from 'axios';
import {render} from 'react-dom';
import TopTable from './topTable.jsx';
import TablePlayer from './tablePlayer.jsx';

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
            document.getElementById('confirm').innerHTML = response.data.message;
        }).catch(function (error) {
            console.log(error)
        })
    window.location.reload();
    }


export const getPlayer = (event) => {
    event.preventDefault();
    axios.get(base+get+document.getElementById('playId').value).then(response => {
        render(<TablePlayer data={response.data}/>, document.getElementById('output'));
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