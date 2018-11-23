import React, {Component} from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import {player, all} from './const.jsx';
import {deletePlayer} from './playerFunctions.jsx';
import Axios from 'axios';

export default class topTable extends Component {

    constructor(props){
        super(props);
        this.state={
            options :{
            defaultSortName: 'ELO',
            defaultSortOrder : 'desc'
            }
        }
    }

    populateTable = () => {
        Axios.get(player+all).then(res => {
            this.setState({
                players : res.data
            }).catch((e) => {
                console.log(e);
            })
        })
    }

    cellButton(cell, row) {
        return (
           <button type="button" onClick={() => deletePlayer(row.id)}>
           Delete Player
           </button>
        )
}


    componentWillMount(){
        this.populateTable();
        this.setState({defaultSortName: 'id',
        defaultSortOrder: 'desc'});
}


    render() {
      return (  
            <div id='output'>
                <BootstrapTable data={this.state.players} options={this.state.options} className='topTable'>
                    <TableHeaderColumn dataField='id' isKey>Player ID</TableHeaderColumn>
                    <TableHeaderColumn dataField='name' dataSort={true}>Name</TableHeaderColumn>
                    <TableHeaderColumn dataField='ELO' dataSort={true}>ELO</TableHeaderColumn>
                    <TableHeaderColumn dataField='numberPlayed' dataSort={true}>Games Played</TableHeaderColumn>
                    <TableHeaderColumn dataField='button' dataFormat={this.cellButton}/>
                </BootstrapTable>
            </div>
        );
    }
}