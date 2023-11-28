// Header.js
import React, {useUser} from "react";
import { Input, Flex } from "antd";
import "./Header.css"; // Import the CSS file
import { DownOutlined } from "@ant-design/icons";
import { Dropdown, Space } from "antd";
import { Link, useLocation } from 'react-router-dom';
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";
import { setSearchValue } from "../../redux/search/actions";
import { useNavigate } from "react-router-dom";

const { Search } = Input;

const Header = ({user, isSearchVisible, categories }) => {
  const items = categories.map((category) => ({
    label: (
      <a href={`/category/${category.id}`}>{category.name}</a>
    ),
    key: category.id,
  }));

  const location = useLocation();
  const navigation = useNavigate();
  const username = useSelector((state) => state.auth.username);

  const dispatch = useDispatch();

  const onSearch = (value) => {
    dispatch(setSearchValue(value));
    navigation('/search');
  }

  return (
    <Flex justify="space-between" align="center" className="header-container">
      {/* Flex-box with links */}
      <Flex className="header-links" gap={100}>
        <Link to="/" className={location.pathname === '/' ? 'active' : ''}>Home</Link>
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
          <Search placeholder="input search text" onSearch={onSearch} enterButton />
        )}
        {username ? (
          <a href="/profile">{username}</a>
        ) : (
          <a href="/login">Sign In</a>
        )}
      </Flex>
    </Flex>
  );
};

export default Header;
