import React from "react";
import { useState } from "react";

import Child from "./Child";

function Parent(props) {
    const p_init = "부모의 초기값"
    const [data, setData] = useState(p_init);

    return (
        <>
        <div>{data}</div>
        <Child setData={setData}></Child>
        <button onClick={() => setData(p_init)}>초기화</button>
        

        </>
    )
}
export default Parent;