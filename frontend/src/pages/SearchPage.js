import { React, useState } from "react";
import Header from "../components/Header/Header";
import MainNews from "../components/MainNews/MainNews";
import users from "../mockData/users.json";
import news from "../mockData/news.json";
import NewsList from "../components/NewsList/NewsList";
import Footer from "../components/Footer/Footer";
import getCategories from "../mockData/categories";
import SearchField from "../components/SearchField/SearchField";
import Section from "../components/Section/Section";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";
import { setSearchValue } from "../redux/search/actions";
import { setFilteredNews } from "../redux/filter/actions";

const SearchPage = () => {
  const filteredNews = useSelector((state) => state.filter.filteredNews);
  const dispatch = useDispatch();

  const filterNews = (news, searchValue) => {
    return searchValue
      ? news.filter((n) =>
          n.title.toLowerCase().includes(searchValue.toLowerCase())
        )
      : news;
  };

  const onSearch = (value) => {
    dispatch(setSearchValue(value.value));
    const filtered = filterNews(news, value.value);
    dispatch(setFilteredNews(filtered));
  };

  const categories = getCategories(news);
  return (
    <div style={{ display: "flex", flexDirection: "column", minHeight: "100vh", justifyContent: "space-between" }}>
      <Header user={null} isSearchVisible={false} categories={categories} />
      <Section>
        <SearchField onSearch={onSearch} />
        {filteredNews.length > 0 ? <NewsList newsList={filteredNews} /> :
        (<p>Nothing found</p>)}
      </Section>
      <Footer />
    </div>
  );
};

export default SearchPage;
