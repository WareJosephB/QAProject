import Axios from 'axios';
import React, {Component} from 'react';

const url = 'http://localhost:';
const port = '8080';
const rest = '/MultiplayerELO/access/expansion/';

const base = url+port+rest;

const colonies = 'getColonies/';
const preludes = 'getPreludes/';

export function getColonies(event){
    event.preventDefault();
    Axios.get(base+colonies).then(response => {return(response.data)}).catch(function (error) {console.log(error)});
}

export class ColonyRow extends Component{

    render(){
        return(
            
            <div>hahabutts</div>
        
        )
    }
} 