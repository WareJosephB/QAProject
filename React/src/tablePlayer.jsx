import ReactTable from 'react-table';
import "react-table/react-table.css";
import React, {Component} from 'react';

export default class tablePlayer extends Component {
  render = () => {
    const columns = [{
      Header: 'Name',
      accessor: 'name'
    }, {
      Header: 'ELO',
      accessor: 'ELO',
    }, {
      Header: 'Games Played',
      accessor: 'numberPlayed'
    }];

  const data = this.props.data;
  return(
    <div>
      <ReactTable data={data} columns={columns}/>
    </div>
  )
  }
}