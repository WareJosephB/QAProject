import React, {Component} from 'react';
import {ColonyRows, getColonies} from './expansions.jsx';

export default class Colonies extends Component{
    constructor(props){
        super(props);
        this.state = {
            colonies : this.props.active,
            players : this.props.players,
            aridor : 0
        };
    }

    render(){
        var outputRows = "";
        if (this.state.colonies !== 0){
            const colonies = getColonies();
            for (var i = 0; i < Math.min(this.state.players+2, 5)+this.state.aridor; i++){
                outputRows += <ColonyRows number={i} colonies={colonies}/>
                if ((i === 3 && (Math.min(this.state.players+2, 5)+this.state.aridor < 7))){
                    outputRows += "<br/>";
                } 
                if ((i === 4 && (Math.min(this.state.players+2, 5)+this.state.aridor > 6))){
                    outputRows += "<br/>";
                }
        return (<div>{outputRows}</div>);
    }
}}}