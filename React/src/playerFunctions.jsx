import Axios from 'axios';
import {player, add, get, upd, del} from './const.jsx';

export const addPlayer = (event) => {
    event.preventDefault();
    Axios.post(player+add, {
        name : document.getElementById('New Name').value
    }).then(response => {
        document.getElementById('Confirm Player').innerHTML = response.data.message;
    }).catch(function (error) {
        console.log(error)
    })
    window.location.reload();
}

export function getPlayer(playerNumber){
    Axios.get(player+get+playerNumber).then(response => {
        return(response.data);
    }).catch(function (error) {
        console.log(error)
    })
}

export function deletePlayer(playerNumber){
    Axios.delete(player+del+playerNumber).then(response => {
        document.getElementById('Confirm Player').innerHTML = response.data.message;
    }).catch(function (error) {
        console.log(error)
    })
    window.location.reload();
}

export function updatePlayer(event){
    event.preventDefault();
    Axios.put(player+upd+document.getElementById('Player ID').value, {
        name : document.getElementById('Update Name').value
    }).then(response => {
        document.getElementById('Confirm Player').innerHTML = response.data.message;
    }).catch(function (error) {
        console.log(error)
    })
    window.location.reload();
}