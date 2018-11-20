import Axios from 'axios';
import React, {Component} from 'react';

const url = 'http://localhost:';
const port = '8080';
const rest = '/MultiplayerELO/access/';

const base = url+port+rest;

const colonies = 'colony/getAll';
const preludes = 'prelude/getAll';

export function getColonies(){
    Axios.get(base+colonies).then(response => {return(response.data)}).catch(function (error) {console.log(error)});
}

export function getPreludes(event){
    event.preventDefault();
    Axios.get(base+preludes).then(response => {return(response.data)}).catch(function (error) {console.log(error)});
}


export class ColonyRows extends Component{
    render(){
        return(<div id={this.props.number}>
        <select name="Colony" id={this.props.number}>
        {this.props.colonies.map((e, key) => {
        return <option key={key} value={e.colonyid}>{e.name}</option>;})}
        </select>
        <select name="Slot 1" id={this.props.number} value={this.state.data.colony}>
        <option selected="yes">---</option>
        {this.props.players.map((e, key) => {
        return <option key={key} value={e.playid}>{e.name}</option>;})}
        </select>
        <select name="Slot 2" id={this.props.number} value={this.state.data.colony}>
        <option selected="yes">---</option>
        {this.props.players.map((e, key) => {
        return <option key={key} value={e.playid}>{e.name}</option>;})}
        </select>
        <select name="Slot 3" id={this.props.number} value={this.state.data.colony}>
        <option selected="yes">---</option>
        {this.props.players.map((e, key) => {
        return <option key={key} value={e.playid}>{e.name}</option>;})}
        </select>
        </div>
        )
    }
} 

export class PreludeRows extends Component{
    render(){
        return(
        <select name="Prelude" id={this.props.number} value={this.state.data.prelude}>
        {this.props.preludes.map((e, key) => {
        return <option key={key} value={e.preludeid}>{e.name}</option>;})}
        </select>
        )
    }
} 