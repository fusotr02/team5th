export const state = () => ({
  user: null
})

export const mutations = {
  login(state, userData) {
    state.user = userData
  },
  logout(state) {
    state.user = null
  }
}

export const getters = {
  isLoggedIn(state) {
    return !!state.user
  },
  getUser(state) {
    return state.user
  }
}