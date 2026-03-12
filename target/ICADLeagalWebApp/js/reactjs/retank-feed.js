 


const rootElement = document.getElementById('react-container');

  //const element = React.createElement('div',{className:''},'Hello World' );

     //ReactDOM.render(element, rootElement);
  const  el =  React.createElement;

  function Button(props){
    return  <button onClick={props.handleClick}>{props.name}</button>
  }

  class Counter extends React.Component{

    state= {
         num: 0
    }

    handleIncrement = () =>{ this.setState({ num: this.state.num + 1 }); }

     handleDecrement = () =>{ this.setState({ num: this.state.num - 1 }); }

    render(){return <div>  <p>{this.state.num}</p>
    <Button name="Increment" handleClick={this.handleIncrement} />
    <Button name="Decrement" handleClick={this.handleDecrement} />
    		    </div>
    }
  }

  ReactDOM.render(<Counter />,rootElement);