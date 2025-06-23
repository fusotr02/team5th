<template>
  <div>
    <h2>登録内容確認</h2>
    <p>名前：{{ form.name }}</p>
    <p>メール：{{ form.email }}</p>
    <button @click="handleRegister">登録</button>
    <button @click="$router.back()">戻る</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      form: history.state
    }
  },
  methods: {
    async handleRegister() {
      await axios.post('/api/auth/register', this.form)
      this.$router.push('/register/complete')
    }
  }
}
</script>
