import PropTypes from 'prop-types'
import React, { Component } from 'react'

/*
    class Component
    state(필드대체)를 가지고 있고 이를 수정할 수 있다
    라이프사이클에 따른 생명주기 메서드를 사용할 수 있다.

    state값이 변경되면 리액트는 변화를 인식하고 그에 맞는 화면을 출력하기 위해
    component를 리렌더링 한다. 그러므로 state값을 변경할 경우에는 state에 어떤 숫자를 넣어서 변경하는 것이 아닌
    this.setState() 함수를 이용하여 새로운 state값을 넘겨주면 된다.

    react의 component 라이프사이클은 생성(mount), 업데이트(update), 제거(unmount) 단계로 나뉘어
    각 단계마다 componentDidMount, componentDidUpdate, componentWillUnmount같은 메소드를 사용해
    DOM을 조작하거나 리소스를 정리할 수 있는 기능을 말함
*/

const styles = {
  wrapper : {
      margin: 8,
      padding: 8,
      display: "flex",
      flexDirection: "row",
      border: "1px solid gray",
      borderRadius: 16
  },
  commentText: {
    fontSize: 18,
  }
}

class Comment extends Component {
  constructor(props){
    super(props)

    //js에서는 class에 필드영역이 없기 때문에
    //저장하고 싶은 데이터를 state라는 객체에 key-value형태로 저장한다.
    this.state = {}
  }

  componentDidMount(){
    console.log(`${this.props.id} componentDidMount 실행됨`)
  }

  componentDidUpdate(){
    console.log(`${this.props.id} componentDidUpdate 실행됨`)
  }

  componentWillUnmount(){
    console.log(`${this.props.id} componentWillUnmount 실행됨`)
  }

  render() {
    return (
      <div style={styles.wrapper}>
        <span style={styles.commentText}>
          {this.props.message}
        </span>
      </div>
    )
  }
}

export default Comment
