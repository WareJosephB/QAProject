import Axios from 'axios';
import {game, add} from './const.jsx';

export const addGame = (event) => {
    event.preventDefault();
    Axios.post(game+add, {
        scores : this.getScores(),
    }).then(function(response) {
        document.getElementById('Confirm Game').innerHTML = response.message
        console.log(response)});
}

// export const getGame = (gameNumber) => {
//     Axios.get(game+get+gameNumber).then(response => {
//         return(response.data);
//     }).catch(function (error) {
//         console.log(error)})
// }