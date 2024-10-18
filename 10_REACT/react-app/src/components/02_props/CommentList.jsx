import React from 'react'
import Comment from './Comment'

const comments = [
    {
        id: 1,
        name: "김현준",
        comment: "안녕하세요. 김현준입니다. 잘부탁드립니다",
        path: "https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"
    },
    {
        id: 2,
        name: "이현준",
        comment: "안녕하세요. 이현준입니다. 잘부탁드립니다",
        path: "https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"
    },
    {
        id: 3,
        name: "최현준",
        comment: "안녕하세요. 최현준입니다. 잘부탁드립니다",
        path: "https://image.utoimage.com/preview/cp872722/2022/12/202212008462_500.jpg"
    },
]

/*
    js에서
    (배열, 리스트).map(반복시 실행할 함수)

    map() => 배열의 요소를 전부 사용하여 동일한 길이의 새로운 배열을 리턴
*/

const CommentList = () => {
  return (
    <div>
        {/* <Comment name={comments[0].name} comment={comments[0].comment} path={comments[0].path} />
        <Comment name={comments[1].name} comment={comments[1].comment} path={comments[1].path} />
        <Comment name={comments[2].name} comment={comments[2].comment} path={comments[2].path} /> */}

        {
            comments.map(c => {
                return <Comment key={c.id} name={c.name} comment={c.comment} path={c.path} />
            })
        }
    </div>
  )
}

export default CommentList