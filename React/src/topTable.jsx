import React, {Component} from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import {player, all, del} from './const.jsx';
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
            console.log(res);
            this.setState({
                players : res.data
            }).catch((e) => {
                console.log(e);
            })
        })
    }

    deletePlayer = (rowid) => {
        console.log(player);
        console.log(del);
        console.log(rowid);
        console.log(player+del+rowid);
        Axios.delete(player+del+rowid).then((res) => {
            window.location.reload()}).catch((e) => {
                console.log(e);
            });
    }

    cellButton(cell, row) {
        return (
           <button type="button" onClick={() => this.deletePlayer(row.id)}>
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