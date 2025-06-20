<template>
  <div>
    <h2>登録内容の確認</h2>
    <ul>
      <li>名前：{{ name }}</li>
      <li>メール：{{ email }}</li>
    </ul>
    <button @click="submit">登録</button>
    <button @click="$router.back()">戻る</button>
  </div>
</template>

<script>
export default {
  computed: {
    name() {
      return this.$route.query.name
    },
    email() {
      return this.$route.query.email
    },
    password() {
      return this.$route.query.password
    }
  },
  methods: {
    async submit() {
      try {
        await this.$axios.post('/api/auth/register', {
          name: this.name,
          email: this.email,
          password: this.password
        })
        this.$router.push({ name: 'RegisterComplete' })
      } catch (e) {
        alert('登録に失敗しました')
      }
    }
  }
}
</script>
