import React from 'react';
import { Avatar } from 'antd';
import './AuthorName.css'; 

const AuthorName = ({ authorName, avatarUrl }) => {
  return (
    <div className="author-container">
      <Avatar src={avatarUrl} size={64} />
      <div className="author-info">
        <span className="author-name">{authorName}</span>
      </div>
    </div>
  );
};

export default AuthorName;