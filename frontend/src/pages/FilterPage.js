// Header.js
import React from "react";
import Header from "../components/Header/Header";
import MainNews from "../components/MainNews/MainNews";
import users from "../mockData/users.json";
import news from "../mockData/news.json";
import NewsList from "../components/NewsList/NewsList";
import Footer from "../components/Footer/Footer";
import getCategories from "../mockData/categories";
import FilterPanel from "../components/FilterPanel/FilterPanel";
import Section from "../components/Section/Section";
import { Button } from "antd";

const FilterPage = () => {
  const categories = getCategories(news);

  const onDateFilterChange = (date) => {
    alert(`Date: ${date}`);
  };

  const onNewsPerPageChange = (newsPerPage) => {
    alert(`News per page: ${newsPerPage}`);
  };

  const style = {
    backgroundColor: "black",
    color: "white",
    padding: "0 70px",
    margin: "0 auto",
  };

  const styleContainer = {
    display: 'flex',
    justifyContent: 'center'
  }

  return (
    <div>
      <Header user={null} isSearchVisible={false} categories={categories} />
      <Section>
        <FilterPanel
          onDateFilterChange={onDateFilterChange}
          onNewsPerPageChange={onNewsPerPageChange}
        />
        <NewsList newsList={news} />
        <div style={styleContainer}><Button style={style}> See more </Button></div>
      </Section>
      <Footer />
    </div>
  );
};

export default FilterPage;
