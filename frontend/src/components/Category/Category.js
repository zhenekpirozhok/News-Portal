// Category.js
import React from "react";
import { Link } from "react-router-dom";
import NewsList from "../NewsList/NewsList"; // Adjust the path based on your project structure
import "./Category.css"; // Import the CSS file
import { Flex } from "antd";

const Category = ({ category, newsList }) => {
  return (
    <Flex className="category" vertical align="flex-end">
      <div className="news-content">
        <NewsList category={category} newsList={newsList} />
      </div>
      <Link to={`/category/${category.id}`} className="view-more-link">
        View more...
      </Link>
    </Flex>
  );
};

export default Category;
