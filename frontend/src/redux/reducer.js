import { combineReducers } from "redux";
import adminMenuReducer from "./adminMenu/reducers";
import adminNewsReducer from "./adminNews/reducer";
import authReducer from "./auth/reducer";

const rootReducer = combineReducers({
    adminMenu: adminMenuReducer,
    adminNews: adminNewsReducer,
    auth: authReducer
});

export default rootReducer;