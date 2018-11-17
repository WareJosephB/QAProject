import React, {Component} from 'react';
import {ColonyRow, getColonies} from './expansions.jsx';

export default class Colonies extends Component{
    constructor(props){
        super(props);
        this.state({
            colonies : this.props.active,
            players : this.props.players
        });
    }

    render(){
        var colonyRows = "";
        if (this.state.colonies !== 0){
            const colonies = getColonies();
            for (var i = 0; i < this.props.players+1; i++){
                colonyRows += <ColonyRow number={i} colonies={colonies}/>
                if (i === 3){
                    colonyRows += "<br/>";
                }
            }
        }
        return (<div>{colonyRows}</div>);
    }
}