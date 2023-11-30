import { combineReducers } from "redux";
import adminMenuReducer from "./adminMenu/reducers";
import adminNewsReducer from "./adminNews/reducer";
import authReducer from "./auth/reducer";
import oneNewsReducer from "./news/oneNewsSlice";

const rootReducer = combineReducers({
    adminMenu: adminMenuReducer,
    adminNews: adminNewsReducer,
    auth: authReducer,
    oneNews: oneNewsReducer
});

export default rootReducer;