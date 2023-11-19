// Header.js
import React from 'react';
import Header from '../components/Header/Header';
import MainNews from '../components/MainNews/MainNews';
import categories from '../mockData/categories.json';
import users from '../mockData/users.json';
import news from '../mockData/news.json';
import NewsList from '../components/NewsList/NewsList';
import Footer from '../components/Footer/Footer';

const HomePage = () => {
  return (
    <div>
      <Header user={null} isSearchVisible={false} categories={categories}/>
      <MainNews news={news[0]}/>
      <NewsList newsList={news.slice(0, 4)} category={categories[0]} />
      <NewsList newsList={news.slice(0, 4)} category={categories[1]} />
      <Footer />
    </div>
  );
};

export default HomePage;