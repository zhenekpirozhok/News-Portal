import React from 'react';
import AuthorName from '../AuthorName/AuthorName'; 
import './CommentItem.css'; 

const CommentItem = ({ authorName, avatarUrl, date, text }) => {
  return (
    <div className="comment-item">
      <div className="comment-header">
        <AuthorName authorName={authorName} avatarUrl={avatarUrl} />
        <span className="comment-date">{date}</span>
      </div>
      <p className="comment-text">{text}</p>
      <div className="comment-line"></div>
    </div>
  );
};

export default CommentItem;