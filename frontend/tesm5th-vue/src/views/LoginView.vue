<template>
  <div class="login">
    <h2>ログイン</h2>
    <form @submit.prevent="handleLogin">
      <input v-model="email" type="email" placeholder="メールアドレス" required />
      <input v-model="password" type="password" placeholder="パスワード" required />
      <button type="submit">ログイン</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
import { mapMutations } from 'vuex'

export default {
  data() {
    return {
      email: '',
      password: ''
    }
  },
  methods: {
    ...mapMutations(['login']),
    async handleLogin() {
      try {
        const res = await axios.post('/api/auth/login', {
          email: this.email,
          password: this.password
        })
        this.login(res.data)
        this.$router.push('/main')
      } catch (err) {
        alert('ログインに失敗しました')
      }
    }
  }
}
</script>
