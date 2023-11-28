// newsSlice.js
import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const initialState = {
  news: [],
  loading: false,
  error: null,
};

// Fetch top 25 news
export const fetchTop25News = createAsyncThunk(
  "news/fetchTop25News",
  async () => {
    return axios
      .get("https://d0a8-78-62-142-17.ngrok-free.app/api/news/top25")
      .then((response) => response.data);
  }
);

// Fetch top 4 news for today
export const fetchTopTodayNews = createAsyncThunk(
  "news/fetchTopTodayNews",
  async () => {
    return axios
      .get("https://d0a8-78-62-142-17.ngrok-free.app/api/news/top-today")
      .then((response) => response.data);
  }
);

// Fetch news by author for today
export const fetchAuthorTopTodayNews = createAsyncThunk(
  "news/fetchAuthorTopTodayNews",
  async (authorUserId) => {
    return axios
      .get(`https://d0a8-78-62-142-17.ngrok-free.app/api/news/author/${authorUserId}/top-today`)
      .then((response) => response.data);
  }
);

// Fetch main news
export const fetchMainNews = createAsyncThunk(
  "news/fetchMainNews",
  async () => {
    return axios
      .get("https://d0a8-78-62-142-17.ngrok-free.app/api/news/main")
      .then((response) => response.data);
  }
);

// Fetch news by date
export const fetchNewsByDate = createAsyncThunk(
  "news/fetchNewsByDate",
  async (date) => {
    return axios
      .get(`https://d0a8-78-62-142-17.ngrok-free.app/api/news/date/${date}`)
      .then((response) => response.data);
  }
);

// Fetch news by id
export const fetchNewsById = createAsyncThunk(
  "news/fetchNewsById",
  async (id) => {
    return axios
      .get(`https://d0a8-78-62-142-17.ngrok-free.app/api/news/${id}`)
      .then((response) => response.data);
  }
);

// Fetch more news (button-more)
export const fetchMoreNews = createAsyncThunk(
  "news/fetchMoreNews",
  async () => {
    return axios
      .get("https://d0a8-78-62-142-17.ngrok-free.app/api/news/button-more")
      .then((response) => response.data);
  }
);

// Add news
export const addNews = createAsyncThunk("news/addNews", async (newsData) => {
  return axios
    .post("https://d0a8-78-62-142-17.ngrok-free.app/api/news/create", newsData)
    .then((response) => response.data);
});

// Search news by keyword
export const searchNewsByKeyword = createAsyncThunk(
  "news/searchNewsByKeyword",
  async (keyword) => {
    return axios
      .get(`https://d0a8-78-62-142-17.ngrok-free.app/api/news/search/${keyword}`)
      .then((response) => response.data);
  }
);

// Delete news by id
export const deleteNewsById = createAsyncThunk(
  "news/deleteNewsById",
  async (id) => {
    return axios
      .delete(`https://d0a8-78-62-142-17.ngrok-free.app/api/news/delete/${id}`)
      .then((response) => response.data);
  }
);

// Update news
export const updateNews = createAsyncThunk(
  "news/updateNews",
  async (newsData) => {
    return axios
      .put("https://d0a8-78-62-142-17.ngrok-free.app/api/news/update", newsData)
      .then((response) => response.data);
  }
);

// Fetch all news (admin)
export const fetchAllNews = createAsyncThunk("news/fetchAllNews", async () => {
  return axios
    .get("https://d0a8-78-62-142-17.ngrok-free.app/api/news/all")
    .then((response) => response.data);
});

// Fetch news by admin date
export const fetchAdminNewsByDate = createAsyncThunk(
  "news/fetchAdminNewsByDate",
  async (date) => {
    return axios
      .get(`https://d0a8-78-62-142-17.ngrok-free.app/api/news/admin_date/${date}`)
      .then((response) => response.data);
  }
);

// Fetch news by admin author
export const fetchAdminNewsByAuthor = createAsyncThunk(
  "news/fetchAdminNewsByAuthor",
  async (authorId) => {
    return axios
      .get(`https://d0a8-78-62-142-17.ngrok-free.app/api/news/admin_author/${authorId}`)
      .then((response) => response.data);
  }
);

// Fetch news by tag
export const fetchNewsByTag = createAsyncThunk(
  "news/fetchNewsByTag",
  async (tag) => {
    return axios
      .get(`https://d0a8-78-62-142-17.ngrok-free.app/api/news/searchPageTag/${tag}`)
      .then((response) => response.data);
  }
);

// Fetch categories with 4 news each
export const fetchCategoriesWithNews = createAsyncThunk(
  "news/fetchCategoriesWithNews",
  async () => {
    return axios
      .get("https://d0a8-78-62-142-17.ngrok-free.app/api/news/searchTags")
      .then((response) => response.data);
  }
);

const newsSlice = createSlice({
  name: "news",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchTop25News.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchTop25News.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(fetchTop25News.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(fetchTopTodayNews.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchTopTodayNews.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(fetchTopTodayNews.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(fetchAuthorTopTodayNews.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchAuthorTopTodayNews.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(fetchAuthorTopTodayNews.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(fetchMainNews.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchMainNews.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(fetchMainNews.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(fetchNewsByDate.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchNewsByDate.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(fetchNewsByDate.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(fetchNewsById.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchNewsById.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(fetchNewsById.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(fetchMoreNews.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchMoreNews.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(fetchMoreNews.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(addNews.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(addNews.fulfilled, (state, action) => {
        state.loading = false;
        state.news.push(action.payload);
      })
      .addCase(addNews.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(searchNewsByKeyword.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(searchNewsByKeyword.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(searchNewsByKeyword.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(deleteNewsById.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(deleteNewsById.fulfilled, (state, action) => {
        state.loading = false;
        state.news = state.news.filter((news) => news.id !== action.payload);
      })
      .addCase(deleteNewsById.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(updateNews.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(updateNews.fulfilled, (state, action) => {
        state.loading = false;
        state.news = state.news.map((news) =>
          news.id === action.payload.id ? action.payload : news
        );
      })
      .addCase(updateNews.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(fetchAllNews.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchAllNews.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(fetchAllNews.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(fetchAdminNewsByDate.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchAdminNewsByDate.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(fetchAdminNewsByDate.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(fetchAdminNewsByAuthor.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchAdminNewsByAuthor.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(fetchAdminNewsByAuthor.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(fetchNewsByTag.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchNewsByTag.fulfilled, (state, action) => {
        state.loading = false;
        state.news = action.payload;
      })
      .addCase(fetchNewsByTag.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(fetchCategoriesWithNews.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchCategoriesWithNews.fulfilled, (state, action) => {
        state.loading = false;
        state.categories = action.payload;
      })
      .addCase(fetchCategoriesWithNews.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      });
  },
});

export const selectNewsById = (state, newsId) => {
  return state.news.news.find((news) => news.id === newsId);
}

export default newsSlice.reducer;
