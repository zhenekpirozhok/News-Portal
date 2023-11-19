// Header.js
import React from "react";
import { Input, Flex } from "antd";
import "./Header.css"; // Import the CSS file
import { DownOutlined } from "@ant-design/icons";
import { Dropdown, Space } from "antd";

const Header = ({ user, isSearchVisible, categories }) => {
  const items = categories.map((category) => ({
    label: (
      <a href={`/category/${category.id}`}>{category.name}</a>
    ),
    key: category.id,
  }));

  return (
    <Flex justify="space-between" align="center" className="header-container">
      {/* Flex-box with links */}
      <Flex className="header-links" gap={100}>
        <a href="/news">News</a>
        <Dropdown menu={{ items }}>
          <a href="/categories">
            <Space>
              Categories
              <DownOutlined />
            </Space>
          </a>
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
