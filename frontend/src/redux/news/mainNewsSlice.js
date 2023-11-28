import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const initialState = {
  mainNews: [],
  loading: false,
  error: null,
};

export const fetchMainNews = createAsyncThunk(
  "news/fetchMainNews",
  async () => {
    return axios
      .get("https://d0a8-78-62-142-17.ngrok-free.app/api/news/main")
      .then((response) => {
        console.log(response.data);
        return response.data;
      });
  }
);

const mainNewsSlice = createSlice({
  name: "mainNews",
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
        state.mainNews = action.payload;
      })
      .addCase(fetchMainNews.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      });
  },
})

export const selectMainNews = (state) => {
  return state.mainNews
}

export default mainNewsSlice.reducer;
