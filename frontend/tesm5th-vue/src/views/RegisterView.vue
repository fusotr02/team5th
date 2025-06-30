<template>
  <div class="wrapper">
    <!-- ヘッダー -->
    <header class="header">
      <div class="menu-left">
        <p class="welcome">team5th</p>
      </div>
      <div class="menu-center">
        <h1>ホテル予約サイト</h1>
      </div>
      <div class="menu-right"></div>
    </header>

    <!-- 登録フォーム -->
    <div class="register-container">
      <h2>新規登録</h2>
      <form @submit.prevent="goToConfirm" class="register-form">
        <div class="form-group">
          <label>名前：</label>
          <input v-model="form.name" required />
        </div>
        <div class="form-group">
          <label>メールアドレス：</label>
          <input v-model="form.email" type="email" required />
        </div>
        <div class="form-group">
          <label>パスワード：</label>
          <input v-model="form.password" type="password" required />
        </div>
        <button type="submit">確認</button>

        <router-link to="/" class="back-button">トップページへ戻る</router-link>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

const form = ref({
  name: '',
  email: '',
  password: ''
})

const goToConfirm = () => {
  router.push({
    name: 'RegisterConfirm',
    query: {
      name: form.value.name,
      email: form.value.email,
      password: form.value.password
    }
  })
}
</script>

<style scoped>
.wrapper {
  padding-top: 80px;
  background-color: #f9f9f9;
  min-height: 100vh;
}

/* ヘッダー */
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #1e3a8a;
  color: white;
  padding: 16px 24px;
  position: fixed;
  top: 0;
  width: 100%;
  z-index: 1000;
}

.menu-left, .menu-right {
  width: 100px;
}

.menu-center {
  flex: 1;
  text-align: center;
}

.welcome {
  margin: 0;
  font-size: 24px;
}

.header h1 {
  margin: 0;
  font-size: 25px;
}

/* 登録フォーム */
.register-container {
  max-width: 400px;
  margin: 40px auto;
  padding: 2rem;
  background: #ffffff;
  border-radius: 8px;
  box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.register-form {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.form-group {
  display: flex;
  flex-direction: column;
  text-align: left;
}

input {
  padding: 10px;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 6px;
  box-sizing: border-box;
}

button {
  padding: 12px;
  background-color: #1976d2;
  color: white;
  border: none;
  border-radius: 6px;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
}

button:hover {
  background-color: #1259a3;
}

.back-button {
  margin-top: 1rem;
  display: inline-block;
  color: #1976d2;
  font-weight: bold;
  text-decoration: none;
  border: 1px solid #1976d2;
  padding: 0.5rem 1rem;
  border-radius: 6px;
  transition: background-color 0.3s ease;
}

.back-button:hover {
  background-color: #e3f2fd;
}
</style>
