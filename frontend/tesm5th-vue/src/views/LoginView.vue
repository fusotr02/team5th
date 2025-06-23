<template>
  <div>
    <h2>ログイン</h2>
    <form @submit.prevent="handleLogin">
      <div>
        <label>メールアドレス：</label>
        <input v-model="email" type="email" required />
      </div>
      <div>
        <label>パスワード：</label>
        <input v-model="password" type="password" required />
      </div>
      <button type="submit">ログイン</button>
    </form>
    <p v-if="error">{{ error }}</p>
  </div>
</template>

<script>
import axios from 'axios'
import { mapMutations } from 'vuex'

export default {
  data() {
    return {
      email: '',
      password: '',
      error: ''
    }
  },
  methods: {
    ...mapMutations(['setUser']),
    async handleLogin() {
      try {
        const response = await axios.post('/api/auth/login', {
          email: this.email,
          password: this.password
        })
        this.setUser(response.data)
        this.$router.push('/main')
      } catch (err) {
        this.error = 'ログインに失敗しました'
      }
    }
  }
}
</script>

