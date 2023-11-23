import React from "react";
import Header from "../components/Header/Header";
import MainNews from "../components/MainNews/MainNews";
import users from "../mockData/users.json";
import news from "../mockData/news.json";
import NewsList from "../components/NewsList/NewsList";
import Footer from "../components/Footer/Footer";
import getCategories from "../mockData/categories";
import SearchField from "../components/SearchField/SearchField";
import Section from "../components/Section/Section";
import SignInForm from "../components/SignInForm/SignInForm";

const HomePage = () => {
  return (
    <div className="signin-container">
      <SignInForm />
    </div>
  );
};

export default HomePage;