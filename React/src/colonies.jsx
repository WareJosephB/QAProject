import React, {Component} from 'react';
import {ColonyRows, getColonies} from './expansions.jsx';

export default class colonies extends Component{
    constructor(props){
        super(props);
        this.state({
            colonies : this.props.active,
            players : this.props.players
        });
    }

    render(){
        var outputRows = "";
        if (this.state.colonies != 0){
            const colonies = getColonies();
            for (var i = 0; i < this.props.players+1; i++){
                outputRows += <ColonyRows number={i} colonies={colonies}/>
                if (i == 3){
                    outputRows += "<br/>";
                }
            }
        }
        return (<div>{outputRows}</div>);
    }
}