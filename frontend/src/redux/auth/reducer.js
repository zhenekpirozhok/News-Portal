const initialState = {
  username: "",
};

const authReducer = (state = initialState, action) => {
  switch (action.type) {
    case "SET_USERNAME":
      return {
        ...state,
        username: action.payload,
      };
    case "LOGOUT":
      return {
        ...state,
        username: "",
      };

    default:
      return state;
  }
};

export default authReducer;
