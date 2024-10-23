import React, { useMemo } from 'react'

const getNumber = (num) => {
    console.log('숫자변경')
    return num;
}

const getText = (text) => {
    console.log('문자변경')
    return text;
}

const ViewState = ({num, text}) => {
    // const viewNum = getNumber(num);
    // const viewText = getText(text);

    const viewNum = useMemo(() => getNumber(num), [num])
    const viewText = useMemo(() => getText(text), [text])

  return (
    <div>
        {viewNum} <br />
        {viewText}
    </div>
  )
}

export default ViewState