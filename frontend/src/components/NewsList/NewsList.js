import React from 'react';
import { Flex, Tag } from 'antd';
import NewsCard from '../NewsCard/NewsCard';
import './NewsList.css';


const NewsList = ({ category, newsList }) => {
  return (
    <div className="news-list">
      <h2 className="news-list-title">
        {category && <Tag color="blue">{category.name}</Tag>}
      </h2>
      <Flex className="news-row" justify='space-between'>
        {newsList.map((news) => (
          <div key={news.id} xs={24} sm={12} md={6} span={8}>
            <NewsCard news={news} />
          </div>
        ))}
      </Flex>
    </div>
  );
};

export default NewsList;
