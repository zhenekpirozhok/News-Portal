// Header.js
import React from "react";
import { Input, Flex } from "antd";
import "./Header.css"; // Import the CSS file
import { DownOutlined } from "@ant-design/icons";
import { Dropdown, Space } from "antd";
import { Link, useLocation } from 'react-router-dom';

const Header = ({ user, isSearchVisible, categories }) => {
  const items = categories.map((category) => ({
    label: (
      <a href={`/category/${category.id}`}>{category.name}</a>
    ),
    key: category.id,
  }));

  const location = useLocation();

  return (
    <Flex justify="space-between" align="center" className="header-container">
      {/* Flex-box with links */}
      <Flex className="header-links" gap={100}>
        <Link to="/news" className={location.pathname === '/news' ? 'active' : ''}>News</Link>
        <Dropdown menu={{ items }}>
          <Link to="/categories" className={location.pathname === '/categories' ? 'active' : ''}>
            <Space>
              Categories
              <DownOutlined />
            </Space>
          </Link>
        </Dropdown>
      </Flex>

      {/* Flex-box with search field and login link */}
      <Flex className="header-links" gap={40} align="center">
        {isSearchVisible && (
          <Input placeholder="Search" className="search-input" />
        )}
        {user ? (
          <a href="/profile">{user.username}</a>
        ) : (
          <a href="/login">Log In</a>
        )}
      </Flex>
    </Flex>
  );
};

export default Header;
