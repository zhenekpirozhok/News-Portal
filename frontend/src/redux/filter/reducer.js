import news from "../../mockData/news.json"

const initialState = {
    filteredNews: news,
}

const filterReducer = (state = initialState, action) => {
    switch (action.type) {
        case "SET_FILTERED_NEWS":
            return {
                ...state,
                filteredNews: action.payload
            }
        default:
            return state
    }
}

export default filterReducer;