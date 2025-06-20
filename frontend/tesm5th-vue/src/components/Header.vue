<template>
  <header>
    <nav>
      <router-link to="/">ログイン</router-link>
      <router-link to="/register">新規登録</router-link>
    </nav>
  </header>
</template>

<script>
export default {
  name: 'Header'
}
</script>

<style scoped>
header {
  background-color: #f8f8f8;
  padding: 1em;
  text-align: center;
}
nav a {
  margin: 0 1em;
  text-decoration: none;
  color: #333;
}
</style>
