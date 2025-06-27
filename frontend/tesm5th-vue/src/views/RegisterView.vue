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
      <div class="menu-right">
        <!-- 右側は空（バランス調整用） -->
      </div>
    </header>

    <!-- 新規登録フォーム -->
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

        <router-link to="/" class="back-home-link">トップページへ戻る</router-link>
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
  router.push({ name: 'RegisterConfirm', state: form.value })
}
</script>

<style scoped>
.wrapper {
  position: relative;
  min-height: 100vh;
  background-color: #ffffff;
  padding-top: 80px;
}

/* ヘッダー */
.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #1e3a8a;
  color: white;
  padding: 16px 24px;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000;
}

.menu-left {
  width: 100px;
  text-align: left;
}

.menu-center {
  flex: 1;
  text-align: center;
}

.menu-right {
  width: 100px;
}

.header h1 {
  margin: 0;
  font-size: 25px;
}

.welcome {
  margin: 0;
  font-size: 24px;
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
  gap: 1rem;
}

.form-group {
  display: flex;
  flex-direction: column;
  text-align: left;
}

label {
  font-weight: bold;
  margin-bottom: 4px;
}

input {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button[type="submit"] {
  padding: 10px;
  background-color: #1976d2;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-weight: bold;
}

button[type="submit"]:hover {
  background-color: #1259a3;
}

/* メインページに戻るリンク */
.back-button {
  display: inline-block;
  margin-top: 1.5rem;
  color: #1976d2;
  font-weight: bold;
  text-decoration: none;
  border: 1px solid #1976d2;
  padding: 0.5rem 1rem;
  border-radius: 4px;
  transition: background-color 0.3s;
}

.back-button:hover {
  background-color: #e3f2fd;
}
</style>
