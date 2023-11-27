const initialState = {
  selectedMenuItem: "/news", // Initial selected menu item
};

const rootReducer = (state = initialState, action) => {
  switch (action.type) {
    case "SET_SELECTED_MENU_ITEM":
      return {
        ...state,
        selectedMenuItem: action.payload,
      };
    default:
      return state;
  }
};

export default rootReducer;
