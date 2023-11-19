// NewsSection.js
import React from 'react';
import { Row, Col, Tag } from 'antd';
import NewsCard from '../NewsCard/NewsCard'; // Adjust the path based on your project structure
import './NewsList.css';


const NewsList = ({ category, newsList }) => {
  return (
    <div className='news-list'>
      <h2 className='news-list-title'>
        {category && <Tag color="blue">{category.name}</Tag>}
      </h2>
      <Row className='news-row'>
        {newsList.map(news => (
          <Col key={news.id} xs={24} sm={12} md={6} span={8}>
            <NewsCard news={news} />
          </Col>
        ))}
      </Row>
    </div>
  );
};

export default NewsList;
