// NewsPage.js
import React from 'react';
import { Typography, Divider } from 'antd';
import NewsLine from './NewsLine/NewsLine';

const { Title } = Typography;

const NewsPage = ({ newsList, onEdit, onDelete }) => {
  return (
    <div>
      <Title level={2}>Latest News</Title>
      <Divider />

      {newsList.map((news) => (
        <NewsLine key={news.id} news={news} onEdit={onEdit} onDelete={onDelete} />
      ))}
    </div>
  );
};

export default NewsPage;
