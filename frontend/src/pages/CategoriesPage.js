// Header.js
import React from "react";
import Header from "../components/Header/Header";
import news from "../mockData/news.json";
import Footer from "../components/Footer/Footer";
import Category from "../components/Category/Category";

const CategoriesPage = () => {
  const categories = news
    .map((news) => news.category)
    .filter(
      (category, index, self) =>
        self.findIndex((c) => c.id === category.id) === index
    );

  return (
    <div>
      <Header user={null} isSearchVisible={false} categories={categories} />
      {categories.map((category) => (
        <Category
          key={category.id}
          category={category}
          newsList={news.filter((news) => news.category.id === category.id)}
        />
      ))}
      <Footer />
    </div>
  );
};

export default CategoriesPage;
