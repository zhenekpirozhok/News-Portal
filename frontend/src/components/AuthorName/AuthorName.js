import React from 'react';
import { Avatar } from 'antd';
import { UserOutlined } from '@ant-design/icons';
import './AuthorName.css'; 

const AuthorName = ({ authorName, avatarUrl, gap }) => {
  return (
    <div className="author-container">
      <Avatar size={60} icon={<UserOutlined />}>
      </Avatar>
      <div className="author-info">
        <span className="author-name">{authorName}</span>
      </div>
    </div>
  );
};

export default AuthorName;