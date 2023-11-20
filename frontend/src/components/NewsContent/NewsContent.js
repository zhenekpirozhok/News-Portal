import {React, useState} from 'react';
import { Button, Tag, Space } from 'antd';
import { LikeFilled, EyeFilled } from '@ant-design/icons';
import './NewsContent.css';

const NewsContent = ({ category, text, likes, views }) => {
  const [likeCount, setLikeCount] = useState(+likes);

  const handleButtonClick = () => {
    setLikeCount(likeCount + 1);
  };

  return (
    <div>
      <Tag className='tag' color="blue">{category.name}</Tag>
      <p className='news-text'>{text}</p>
      <Space>
        <span>
          <Button className='like-button' onClick={handleButtonClick}> <LikeFilled className='likes-icon' /> </Button>
          <p className='likes-number'>{likeCount}</p>
        </span>
        <span >
          <EyeFilled className='views-icon'/> <p className='views-number'>{views}</p>
        </span>
      </Space>
    </div>
  );
};

export default NewsContent;