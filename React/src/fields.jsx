import React, {Component} from 'react';
import Colonies from './colonies.jsx';

export default class fields extends Component{
    constructor(props){
        super(props);
        this.state({
            M : 0,
            C : 0,
            V : 0,
            P : 0,
            Players : 2,
            player1 : "",
            player2 : "",
            player3 : "",
            player4 : "",
            player5 : ""
        });
    }

    render = () => {

        return (  
            <div>
                <table id='metaData'>
                    <tr>Map: <input type="select" onChange={this.setState({M:this.value})} placeHolder="Map"><option value="1">Tharis (Base)</option><option value="2">Hellas</option><option value="3">Elysium</option></input></tr>
                    <tr>Venus Next? <input type="select" onChange={this.setState({V:this.value})}><option value="0" selected>No</option><option value="1">Yes</option></input></tr>
                    <tr>Preludes? <input type="select" onChange={this.setState({P:this.value})}><option value="0" selected>No</option><option value="1">Yes</option></input></tr>
                    <tr>Colonies? <input type="select" onChange={this.setState({C:this.value})}><option value="0" selected>No</option><option value="1">Yes</option></input></tr>
                    <tr>Player Count: <input type="select" onChange={this.setState({Players: this.value})} placeholder="Number of Players"><option value="2">2 Player</option><option value="3">3 Player</option><option value="4">4 Player</option><option value="5">5 Player</option></input></tr>
                </table>
                <br/>
                <Colonies active={this.state.Colonies} players={this.state.Players}/>
                <gameTable colonies={this.state.Colonies} preludes={this.state.preludes}/>
            </div>
        );
    }
}