import Axios from 'axios';
import {prelude, colony, corporation, all} from './const.jsx';

export const getAllPreludes = (event) => {
    event.preventDefault();
    Axios.get(prelude+all).then(response => {
        return (response.data)
        }).catch(function (error) {
            console.log(error)
        })
}

export const getAllColonies = (event) => {
    event.preventDefault();
    Axios.get(colony+all).then(response => {
        return (response.data)
        }).catch(function (error) {
            console.log(error)
        })
}

export const getAllCorporations = (event) => {
    event.preventDefault();
    Axios.get(corporation+all).then(response => {
        return (response.data)
        }).catch(function (error) {
            console.log(error)
        })
}