// reducers.js
// IMPORTANT! The logic will be different. It will interact with server.

const initialState = {
  newsList: [], // Your news data structure
};

const newsReducer = (state = initialState, action) => {
  switch (action.type) {
    case "TOGGLE_NEWS_STATUS":
      // Toggle the status of a specific news item
      return {
        ...state,
        newsList: state.newsList.map((news) =>
          news.id === action.payload ? { ...news, status: !news.status } : news
        ),
      };

    case "EDIT_NEWS":
      // Edit a specific news item
      return {
        ...state,
        newsList: state.newsList.map((news) =>
          news.id === action.payload.newsId
            ? { ...news, ...action.payload.updatedNews }
            : news
        ),
      };

    case "DELETE_NEWS":
      // Delete a specific news item
      return {
        ...state,
        newsList: state.newsList.filter((news) => news.id !== action.payload),
      };

    // Handle other actions...

    default:
      return state;
  }
};

export default newsReducer;
