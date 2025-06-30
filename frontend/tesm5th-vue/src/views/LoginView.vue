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
        <!-- 空：バランス調整用 -->
      </div>
    </header>

    <!-- ログインフォーム -->
    <div class="register-container">
      <h2>ログイン</h2>
      <form @submit.prevent="handleLogin" class="register-form">
        <div class="form-group">
          <label>メールアドレス：</label>
          <input v-model="email" type="email" required />
        </div>
        <div class="form-group">
          <label>パスワード：</label>
          <input v-model="password" type="password" required />
        </div>
        <button type="submit">ログイン</button>

        <router-link to="/" class="back-button">トップページへ戻る</router-link>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'

const router = useRouter()
const email = ref('')
const password = ref('')

const handleLogin = async () => {
  try {
    const response = await axios.post('http://localhost:8080/auth/login', {
      email: email.value,
      password: password.value
    })
    // ログイン成功時の処理（トークン保存やページ遷移など）
    router.push('/mypage')
  } catch (error) {
    alert('ログインに失敗しました。メールアドレスとパスワードを確認してください。')
    console.error(error)
  }
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

/* フォーム */
.register-container {
  max-width: 400px;
  margin: 40px auto;
  padding: 2.5rem 2rem;
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

label {
  font-weight: bold;
  margin-bottom: 4px;
}

input {
  padding: 10px 12px;
  border: 1px solid #ccc;
  border-radius: 6px;
  font-size: 1rem;
  line-height: 1.4;
  box-sizing: border-box;
}

button[type="submit"] {
  padding: 12px;
  background-color: #1976d2;
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  font-weight: bold;
  font-size: 1.1rem;
  transition: background-color 0.3s ease;
}

button[type="submit"]:hover {
  background-color: #1259a3;
}

/* トップページに戻るリンク */
.back-button {
  display: inline-block;
  margin-top: 1.8rem;
  color: #1976d2;
  font-weight: bold;
  text-decoration: none;
  border: 1px solid #1976d2;
  padding: 0.6rem 1.2rem;
  border-radius: 6px;
  transition: background-color 0.3s ease;
}

.back-button:hover {
  background-color: #e3f2fd;
}
</style>
