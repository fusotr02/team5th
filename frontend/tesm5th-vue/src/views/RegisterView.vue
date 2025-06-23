<template>
  <div>
    <h2>新規登録</h2>
    <form @submit.prevent="goToConfirm">
      <div>
        <label>名前：</label>
        <input v-model="form.name" required />
      </div>
      <div>
        <label>メールアドレス：</label>
        <input v-model="form.email" type="email" required />
      </div>
      <div>
        <label>パスワード：</label>
        <input v-model="form.password" type="password" required />
      </div>
      <button type="submit">確認</button>
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
    goToConfirm() {
      this.$router.push({ name: 'RegisterConfirm', state: this.form })
    }
  }
}
</script>
