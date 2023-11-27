export const toggleNewsStatus = (newsId) => ({
  type: "TOGGLE_NEWS_STATUS",
  payload: newsId,
});

export const editNews = (newsId, updatedNews) => ({
  type: "EDIT_NEWS",
  payload: { newsId, updatedNews },
});

export const deleteNews = (newsId) => ({
  type: "DELETE_NEWS",
  payload: newsId,
});
