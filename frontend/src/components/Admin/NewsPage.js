// NewsPage.js
import React from 'react';
import { Typography } from 'antd';
import NewsLine from './NewsLine/NewsLine';
import AdminFilterPanel from './AdminFilterPanel/AdminFilterPanel';

const { Title } = Typography;

const NewsPage = ({ newsList, onEdit, onDelete }) => {
  return (
    <div>
      <AdminFilterPanel />
      {newsList.map((news) => (
        <NewsLine key={news.id} news={news} onEdit={onEdit} onDelete={onDelete} />
      ))}
    </div>
  );
};

export default NewsPage;
