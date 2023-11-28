// Header.js
import React from 'react';
import Header from '../components/Header/Header';
import MainNews from '../components/MainNews/MainNews';
import users from '../mockData/users.json';
import news from '../mockData/news.json';
import NewsList from '../components/NewsList/NewsList';
import Footer from '../components/Footer/Footer';
import getCategories from '../mockData/categories';
import Section from "../components/Section/Section";
import MyComponent from '../components/MyComponent';

const HomePage = () => {
  const events = news.filter((news) => news.category.id === 1);
  const announcements = news.filter((news) => news.category.id === 2);
  const categories = getCategories(news);

  return (
    <div>
      <MyComponent />
      <Header user={null} isSearchVisible={true} categories={categories}/>
      <Section>
        <MainNews news={news[0]}/>
        <NewsList newsList={events} category={categories[0]} />
        <NewsList newsList={announcements} category={categories[1]} />
      </Section>
      <Footer />
    </div>
  );
};

export default HomePage;