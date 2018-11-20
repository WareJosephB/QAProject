import React, {Component} from 'react';
import Colonies from './colonies.jsx';
//import GameTable from './gameTable.jsx';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table'


export default class fields extends Component{
    constructor(props){
        super(props);
        this.state = {
            M : 0,
            C : 0,
            V : 0,
            P : 0,
            players : 2,
            player1 : "",
            player2 : "",
            player3 : "",
            player4 : "",
            player5 : ""
        };
    }

    
    

    render = () => {

        return (  
            <div>
                <BootstrapTable data={this.props.data} options={this.state.options} className="setUpTable" id='setUpTable'>
                    <TableHeaderColumn dataField='i' isKey={true}>Map</TableHeaderColumn>
                    <TableHeaderColumn dataField='M' dataFormat={this.mapButton}>Map</TableHeaderColumn>
                    <TableHeaderColumn dataField='V' dataFormat={this.trueFalse}>Venus Next?</TableHeaderColumn>
                    <TableHeaderColumn dataField='P' dataFormat={this.trueFalse}>Preludes?</TableHeaderColumn>
                    <TableHeaderColumn dataField='C' dataFormat={this.trueFalse}>Colonies?</TableHeaderColumn>
                    <TableHeaderColumn dataField='Players' dataFormat={this.dropDownPlayers}>Number of Players</TableHeaderColumn>
                </BootstrapTable>
                <br/>
                <Colonies active={this.state.C} players={this.state.players}/>
                <br/>
                {/* <GameTable colonies={this.state.C} preludes={this.state.P} players={this.state.players}/> */}
            </div>
        );
    }
}