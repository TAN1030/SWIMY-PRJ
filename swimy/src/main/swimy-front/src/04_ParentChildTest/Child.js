import React from "react";  
function Child(props) {


    return (
        <>
        <button onClick={() => props.setData("자식값")}>
          (자식컴포넌트의 버튼) 자식의 데이터 가져오기
        </button> 
 
      </>
        )


}
export default Child;