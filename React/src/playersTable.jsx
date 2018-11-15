import React, {Component} from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table'
import {deletePlayer} from './playerFunctions';




export default class playersTable extends Component {
    
    cellButton(cell, row) {
        console.log(row);
        return (
           <button type="button" onClick={() => deletePlayer(row.id)}>
           Delete Player
           </button>
        )
     }


    render() {
    
        return (
            <BootstrapTable data={this.props.data}>
                <TableHeaderColumn dataField='id' isKey>Player ID</TableHeaderColumn>
                <TableHeaderColumn dataField='name'>Name</TableHeaderColumn>
                <TableHeaderColumn dataField='ELO'>ELO</TableHeaderColumn>
                <TableHeaderColumn dataField='numberPlayed'>Games Played</TableHeaderColumn>
                <TableHeaderColumn dataField='button' dataFormat={this.cellButton}/>
            </BootstrapTable>
        );
    }
}