import React from 'react';
import { Input, Button } from 'antd';
import { SearchOutlined } from '@ant-design/icons';
import './SearchField.css';

const SearchField = () => {
  return (
    <div className="search-field-container">
      <h2 className="search-title">Search:</h2>
      <div className="search-input-container">
        <Input className="search-input" placeholder="Enter your search query" />
        <Button icon={<SearchOutlined style={{ color: 'white' }}/>} className="search-button" />
      </div>
    </div>
  );
};

export default SearchField;