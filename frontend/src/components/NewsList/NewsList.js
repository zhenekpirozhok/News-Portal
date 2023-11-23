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
      <Flex className="news-row" justify='space-between' wrap='wrap'>
        {newsList.map((news) => (
          <div key={news.id}>
            <NewsCard news={news} />
          </div>
        ))}
      </Flex>
    </div>
  );
};

export default NewsList;
