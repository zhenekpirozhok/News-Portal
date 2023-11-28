import { combineReducers } from "redux";
import adminMenuReducer from "./adminMenu/reducers";
import adminNewsReducer from "./adminNews/reducer";
import authReducer from "./auth/reducer";
import searchReducer from "./search/reducer";
import filterReducer from "./filter/reducer";

const rootReducer = combineReducers({
    adminMenu: adminMenuReducer,
    adminNews: adminNewsReducer,
    auth: authReducer,
    search: searchReducer,
    filter: filterReducer
});

export default rootReducer;