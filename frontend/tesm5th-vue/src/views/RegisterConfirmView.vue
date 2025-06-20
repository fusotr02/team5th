<template>
  <div class="register">
    <h2>新規登録</h2>
    <form @submit.prevent="confirm">
      <input v-model="form.name" placeholder="名前" required />
      <input v-model="form.email" type="email" placeholder="メールアドレス" required />
      <input v-model="form.password" type="password" placeholder="パスワード" required />
      <button type="submit">確認へ</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        name: '',
        email: '',
        password: ''
      }
    }
  },
  methods: {
    confirm() {
      this.$router.push({ name: 'RegisterConfirm', query: this.form })
    }
  }
}
</script>

