import React from "react";

export default class ClickCounter extends React.Component{
    constructor(props){
       super(props)
       
       this.setState = {
            clcickCounter: 0 
       }
    }

    render() {
        return (
            <div className="ClickCounter">
               <div>클릭한횟수: {this.state.ClickCounter} </div> 
               <button>클릭</button>
            </div>
        )
    }
}