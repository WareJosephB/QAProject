import React, {Component} from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table'
import {getAll, deletePlayer} from './playerFunctions.jsx'



export default class topTable extends Component {
    
    componentWillMount(){
        getAll();
        this.setState({defaultSortName: 'id',
        defaultSortOrder: 'desc'});
    }

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
            <div id='output'>
                <BootstrapTable data={this.props.data} options={this.state.options}>
                    <TableHeaderColumn dataField='id' isKey dataSort="true">Player ID</TableHeaderColumn>
                    <TableHeaderColumn dataField='name' dataSort="true">Name</TableHeaderColumn>
                    <TableHeaderColumn dataField='ELO' dataSort="true">ELO</TableHeaderColumn>
                    <TableHeaderColumn dataField='numberPlayed' dataSort>Games Played</TableHeaderColumn>
                    <TableHeaderColumn dataField='button' dataFormat={this.cellButton}/>
                </BootstrapTable>
            </div>
      );
    }
  }