import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const initialState = {
  topNews: [],
  loading: false,
  error: null,
};

export const fetchMainNews = createAsyncThunk(
  "news/fetchTopNews",
  async () => {
    return axios
      .get("http://127.0.0.1:8000/api/news/top-today/")
      .then((response) => response.data);
  }
);

const mainNewsSlice = createSlice({
  name: "topNews",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchMainNews.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchMainNews.fulfilled, (state, action) => {
        state.loading = false;
        state.topNews = action.payload;
      })
      .addCase(fetchMainNews.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      });
  },
})

export const selectTopNews = (state) => {
  return state.news.topNews;
}

export default mainNewsSlice.reducer;
