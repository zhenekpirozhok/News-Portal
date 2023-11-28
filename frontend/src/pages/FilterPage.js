// Header.js
import React, { useState } from "react";
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
  const [newsPerPage, setNewsPerPage] = useState(10);
  const [selectedDate, setSelectedDate] = useState(null);

  const onDateFilterChange = (date) => {
    setSelectedDate(date);
  };

  const handleNewsPerPageChange = (newsPerPage) => {
    setNewsPerPage(newsPerPage);
  };

  const loadMoreNews = () => {
    setNewsPerPage(newsPerPage * 2);
  };

  let filteredNews = [];
  if (selectedDate) {
    filteredNews = news.filter((item) => {
      return item.date === selectedDate.split("-").reverse().join(".");
    });
  } else {
    filteredNews = news.slice(0, newsPerPage);
  }

  const style = {
    backgroundColor: "black",
    color: "white",
    padding: "0 70px",
    margin: "0 auto",
  };

  const styleContainer = {
    display: "flex",
    justifyContent: "center",
  };

  return (
    <div>
      <Header user={null} isSearchVisible={false} categories={categories} />
      <Section>
        <FilterPanel
          onDateFilterChange={onDateFilterChange}
          setNewsPerPage={handleNewsPerPageChange}
        />
        <NewsList newsList={filteredNews.slice(0, newsPerPage)} />
        <div style={styleContainer}>
          <Button style={style} onClick={loadMoreNews}>
            {" "}
            See more{" "}
          </Button>
        </div>
      </Section>
      <Footer />
    </div>
  );
};


export default FilterPage;
