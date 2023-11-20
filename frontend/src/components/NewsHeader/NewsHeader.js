import React from 'react';
import AuthorName from '../AuthorName/AuthorName.js';
import './NewsHeader.css'; 

const NewsHeader = ({ date, title, authorName, avatarUrl }) => {
  return (
    <div className="news-header-container">
        <span className="news-date">{date}</span>
        <h1 className="news-title">{title}</h1>
        <AuthorName authorName={authorName} avatarUrl={avatarUrl} />
    </div>
  );
};

export default NewsHeader;