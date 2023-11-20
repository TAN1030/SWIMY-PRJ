import React from "react";
import { useState } from "react";

function ClickCounter(){
    
    const [cc, setCc] = useState(0);


    // 보통의 state
    //this.state = { clickCounter: 0 } 
    // 함수형 state
    //this.setState((state,props) => ({count: state.count+1}))

    /*function handleClick () {
        // 보통의 setState
        this.setState({ clickCounter: this.state.clickCounter +1 })
        // 함수형 setState
        this.setState((state,props) => ({clickCounter: state.clickCounter+1}))
    }*/
    return (
        <div className="ClickCounter">
            <div>클릭한 횟수 : {cc}</div> 
            <button onClick={() => setCc(cc+1)}>클릭</button>
        </div>
    )
}

export default ClickCounter;

