import ReactTable from 'react-table'
import React, {Component} from 'react';

class tablePlayer extends Component{
  render() {
    const columns = [{
      Header: 'Name',
      accessor: 'name'
    }, {
      Header: 'ELO',
      accessor: 'elo',
    }, {
      Header: 'Games Played',
      accessor: 'gamesPlayed'
    }]
    <ReactTable data={data}/>
  }
}
