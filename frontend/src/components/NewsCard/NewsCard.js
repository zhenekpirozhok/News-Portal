// NewsCard.js
import React from 'react';
import { Card, Tag } from 'antd';
import './NewsCard.css';

const NewsCard = ({ news }) => {
  return (
    <Card
      hoverable
      className="news-card"
      cover={<img alt={news.title} src={news.image}/>}
    >
      <h3>{news.title}</h3>
      {/* Add more details or customize as needed */}
      <a href={`/news/${news.id}`}>Read more</a>
    </Card>
  );
};

export default NewsCard;
