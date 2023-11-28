export const login = (username) => ({
    type: "SET_USERNAME",
    payload: username
});

export const logout = () => ({
    type: "LOGOUT",
    payload: null
})