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

const FilterPage = () => {
  const categories = getCategories(news);

  const onDateFilterChange = (date) => {
      alert(`Date: ${date}`);
  }

  const onNewsPerPageChange = (newsPerPage) => {
      alert(`News per page: ${newsPerPage}`);
  }

  return (
    <div>
      <Header user={null} isSearchVisible={false} categories={categories} />
      <Section>
      <FilterPanel onDateFilterChange={onDateFilterChange} onNewsPerPageChange={onNewsPerPageChange}/>
      <NewsList newsList={news} />
      </Section>
      <Footer />
    </div>
  );
};

export default FilterPage;
