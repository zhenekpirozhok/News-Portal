// Header.js
import React from 'react';
import Header from '../components/Header/Header';

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

  return (
    <div>
      <Header user={user} isSearchVisible={false} categories={categories}/>
    </div>
  );
};

export default HomePage;