import React from 'react'

const ToolBar = (props) => {
    const { isLogin, onClickLogin, onClickLogout } = props;
  return (
    <div>
        {
            isLogin ?
            <div>
                <div style={{padding: 24}}>안녕하세요 김현준님</div>
                <button onClick={onClickLogout}>로그아웃</button>
            </div> :
            <div>
                <div style={{padding: 24}}>로그인이 필요한 서비스입니다.</div>
                <button onClick={onClickLogin}>로그인</button>
            </div>
        }
    </div>
  )
}

export default ToolBar