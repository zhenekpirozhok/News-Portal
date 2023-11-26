// Header.js
import React from "react";
import Header from "../components/Header/Header";
import news from "../mockData/news.json";
import Footer from "../components/Footer/Footer";
import Category from "../components/Category/Category";
import Section from "../components/Section/Section";
import getCategories from "../mockData/categories";

const CategoriesPage = () => {
  const categories = getCategories(news);

  return (
    <div>
      <Header user={null} isSearchVisible={false} categories={categories} />
        <Section>
          {categories.map((category) => (
          <Category
            key={category.id}
            category={category}
            newsList={news.filter((news) => news.category.id === category.id)}
          />
        ))}
        </Section>
      <Footer />
    </div>
  );
};

export default CategoriesPage;
