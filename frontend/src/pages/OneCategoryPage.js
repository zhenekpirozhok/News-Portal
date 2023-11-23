// Header.js
import React from "react";
import Header from "../components/Header/Header";
import news from "../mockData/news.json";
import Footer from "../components/Footer/Footer";
import Category from "../components/Category/Category";
import { Link, useParams } from "react-router-dom";
import NewsList from "../components/NewsList/NewsList";
import getCategories from "../mockData/categories";
import Section from "../components/Section/Section";

const OneCategoryPage = () => {
  const { categoryId } = useParams();
  const categories = getCategories(news);
  const newsList = news.filter((news) => news.category.id === +categoryId);

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        minHeight: "100vh",
        justifyContent: "space-between",
      }}
    >
      <Header user={null} isSearchVisible={false} categories={categories} />
      <Section>
        <NewsList newsList={newsList} category={categories.find((c) => c.id === +categoryId)}/>
      </Section>
      <Footer />
    </div>
  );
};

export default OneCategoryPage;
