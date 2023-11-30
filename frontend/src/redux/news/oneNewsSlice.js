import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const initialState = {
  oneNews: [],
  loading: false,
  error: null,
};

export const fetchNewsById = createAsyncThunk(
  "news/fetchNewsById",
  async (id) => {
    return axios
      .get(`https://d0a8-78-62-142-17.ngrok-free.app/api/news/${id}`)
      .then((response) => {
        console.log(response.data);
        return response.data;
      });
  }
);

export const giveLike = createAsyncThunk(
  "news/giveLike",
  async (id, likes) => {
    return axios
      .put(`https://d0a8-78-62-142-17.ngrok-free.app/api/news/${id}`, {
        likes,
      })
      .then((response) => {
        console.log(response.data);
        return response.data;
      });
  }
)

const oneNewsSlice = createSlice({
  name: "oneNews",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchNewsById.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchNewsById.fulfilled, (state, action) => {
        state.loading = false;
        state.mainNews = action.payload;
      })
      .addCase(fetchNewsById.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      .addCase(giveLike.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(giveLike.fulfilled, (state, action) => {
        state.loading = false;
        state.mainNews = action.payload;
      })
      .addCase(giveLike.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      });
  },
})

export const selectOneNews = (state) => {
  return state.oneNews
}

export default oneNewsSlice.reducer;
