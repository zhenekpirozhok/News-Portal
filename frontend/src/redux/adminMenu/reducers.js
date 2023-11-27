const initialState = {
  selectedMenuItem: "1", // Initial selected menu item
};

const adminMenuReducer = (state = initialState, action) => {
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



export default adminMenuReducer;
