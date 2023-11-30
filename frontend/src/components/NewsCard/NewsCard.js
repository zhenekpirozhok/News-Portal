// NewsCard.js
import React from 'react';
import { Card } from 'antd';
import './NewsCard.css';

const NewsCard = ({ news }) => {
  return (
    <a href={`/news/${news.id}`}>
    <Card
      hoverable
      className="news-card"
      cover={<img alt={news.title} src={news.imageUrl}/>}
    >
      <h3>{news.title}</h3>
      {/* Add more details or customize as needed */}
      <a href={`/news/${news.id}`}>Read more</a>
    </Card>
    </a>
  );
};

export default NewsCard;
