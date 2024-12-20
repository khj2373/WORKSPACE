import React from 'react'
import { UserOutlined, LoadingOutlined } from '@ant-design/icons';
import { Space, Avatar, Card } from 'antd'
import styled from 'styled-components';

const ChatDisplay = ({chatDataList, isLoading}) => {
  return (
    <ChatContainer>
        {chatDataList.map((chat, index) => (
            <div key={chat.date}>
                <Space
                    style={{
                        float: 'right'
                    }}
                >
                    <Card
                        style={{
                            width: 300,
                        }}
                    >
                        {chat.question}
                    </Card>
                    <Avatar size={40}>
                        <UserOutlined />
                    </Avatar>
                </Space>
                <Space
                    style={{
                        float: 'left',
                        margin: "12px 0"
                    }}
                > 
                    <Avatar 
                        size={40}
                        src={"https://photutorial.com/wp-content/uploads/2023/04/Featured-image-AI-image-generators-by-Midjourney.png"}
                    />
                    <Card
                        style={{
                            width: 400,
                        }}
                    >
                        {chat.message}
                    </Card>
                </Space>
            </div>
        ))}
        {
            isLoading &&
            <LoadingArea>
                AI 응답 작성중....
                <LoadingOutlined />
            </LoadingArea>
        }
    </ChatContainer>
  )
}

export default ChatDisplay

const ChatContainer = styled.div`
    display: flex;
    flex-direction: column;
`

const LoadingArea = styled.div`
    padding: 12px 0 24px;
`