import { combineReducers } from "redux";
import adminMenuReducer from "./adminMenu/reducers";
import adminNewsReducer from "./adminNews/reducer";

const rootReducer = combineReducers({
    adminMenu: adminMenuReducer,
    adminNews: adminNewsReducer
});

export default rootReducer;