// Header.js
import React from 'react';
import Header from '../components/Header/Header';
import MainNews from '../components/MainNews/MainNews';

const HomePage = () => {
  const user = {
    username: 'Username',
    password: 'admin',
  }

  const categories = [
    {
      name: 'Category 1',
      id: 1
    },
    {
      name: 'Category 2',
      id: 2
    },
    {
      name: 'Category 3',
      id: 3
    }
  ]

  const mainNews = {
    title: 'Global Summit Boosts Tech Innovation',
    category: 'Events',
    image: '/images/syrniki.jfif',
  }

  return (
    <div>
      <Header user={user} isSearchVisible={false} categories={categories}/>
      <MainNews news={mainNews}/>
    </div>
  );
};

export default HomePage;