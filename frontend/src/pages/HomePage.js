// Header.js
import { useEffect, React, useState } from "react";
import Header from "../components/Header/Header";
import MainNews from "../components/MainNews/MainNews";
import users from "../mockData/users.json";
import news from "../mockData/news.json";
import NewsList from "../components/NewsList/NewsList";
import Footer from "../components/Footer/Footer";
import getCategories from "../mockData/categories";
import Section from "../components/Section/Section";
import { useDispatch, useSelector } from "react-redux";
import { fetchMainNews, selectMainNews } from "../redux/news/mainNewsSlice";
import axios from "axios";

const HomePage = () => {
  const events = news.filter((news) => news.category.id === 1);
  const announcements = news.filter((news) => news.category.id === 2);
  const categories = getCategories(news);

  const [mainNews, setMainNews] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(
          "https://d0a8-78-62-142-17.ngrok-free.app/api/news/main",
          {
            headers: {
              "Content-Type": "application/json",
              "ngrok-skip-browser-warning": true,
            },
          }
        );
        console.log("[HomePage] response.data: ", response);
        setMainNews(response.data);
      } catch {
        console.log("[HomePage] error");
        setError("Failed to fetch main news");
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, [mainNews, setMainNews]);

  return (
    <div>
      <Header user={null} isSearchVisible={false} categories={categories} />
      <Section>
        {loading && <p>Loading...</p>}
        {error && <p>Error: {error}</p>}
        {!loading && !error && <MainNews news={mainNews[0]} />}
        <NewsList newsList={events} category={categories[0]} />
        <NewsList newsList={announcements} category={categories[1]} />
      </Section>
      <Footer />
    </div>
  );
};

export default HomePage;
