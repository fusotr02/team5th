<template>
  <header>
    <h1>ホテル予約サイト</h1>
    <nav>
      <router-link to="/main">ホーム</router-link>
      <router-link v-if="!isLoggedIn" to="/login">ログイン</router-link>
      <router-link v-if="!isLoggedIn" to="/register">新規登録</router-link>
      <button v-if="isLoggedIn" @click="handleLogout">ログアウト</button>
    </nav>
  </header>
</template>

<script>
import { mapState, mapMutations } from 'vuex'

export default {
  computed: {
    ...mapState(['user']),
    isLoggedIn() {
      return !!this.user
    }
  },
  methods: {
    ...mapMutations(['logout']),
    handleLogout() {
      this.logout()
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>
header {
  background-color: #f8f8f8;
  padding: 1em;
}
nav a {
  margin-right: 1em;
}
</style>
