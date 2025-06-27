<template>
  <div class="login-container">
    <!-- ハンバーガーメニュー -->
    <div class="menu-icon" @click="toggleSidebar">☰</div>

    <!-- サイドバー -->
    <div class="sidebar" :class="{ open: isSidebarOpen }">
      <button @click="navigateTo('/login')">ログイン</button>
      <button @click="navigateTo('/register')">新規登録</button>
      <button @click="toggleSidebar" class="back-button">戻る</button>
    </div>

    <!-- メインログインフォーム -->
    <h2>ログイン</h2>
    <form @submit.prevent="handleLogin">
      <input type="email" v-model="email" placeholder="メールアドレス" required />
      <input type="password" v-model="password" placeholder="パスワード" required />
      <button type="submit">ログイン</button>
    </form>

    <p class="signup-text">アカウントをまだ作成していない方はこちら</p>
    <router-link to="/register">
      <button class="signup-button">新規登録</button>
    </router-link>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const email = ref('')
const password = ref('')
const isSidebarOpen = ref(false)

const toggleSidebar = () => {
  isSidebarOpen.value = !isSidebarOpen.value
}

const navigateTo = (path) => {
  router.push(path)
  isSidebarOpen.value = false
}

const handleLogin = async () => {
  try {
    const response = await fetch('/api/auth/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      credentials: 'include',
      body: JSON.stringify({ email: email.value, password: password.value })
    })

    if (response.ok) {
      router.push('/mypage')
    } else {
      alert('ログインに失敗しました')
    }
  } catch (err) {
    console.error(err)
    alert('エラーが発生しました')
  }
}
</script>

<style scoped>
:global(html, body) {
  margin: 0;
  padding: 0;
  height: 100%;
}

.login-container {
  position: relative;
  width: 100vw;
  height: 100vh;
  padding: 40px;
  box-sizing: border-box;
  text-align: center;
  font-family: sans-serif;
  overflow: hidden;
  background-color: #f9f9f9;
}

/* ハンバーガーアイコン */
.menu-icon {
  text-align: left;
  font-size: 24px;
  margin-bottom: 20px;
  cursor: pointer;
}

/* サイドバー */
.sidebar {
  position: absolute;
  top: 0;
  left: -220px;
  width: 200px;
  height: 100%;
  background-color: #999;
  padding: 20px;
  transition: left 0.3s ease;
  z-index: 100;

  display: flex;
  flex-direction: column;
}

.sidebar.open {
  left: 0;
}

.sidebar button {
  width: 100%;
  padding: 10px;
  margin-bottom: 10px;
  background-color: white;
  border: 1px solid #333;
  cursor: pointer;
}

.back-button {
  margin-top: calc(100% - 45px); /* 0.4cm(≒15px) 下にずらす */
}

/* 入力欄とボタンのサイズ調整（1/2に） */
input {
  display: block;
  width: 25%; /* ← 元の50%の半分 */
  padding: 10px;
  margin: 10px auto;
  border: 1px solid #233;
  font-size: 16px;
  box-sizing: border-box;
}

button {
  width: 25%; /* ← ボタンサイズを1/2に縮小 */
  padding: 10px;
  margin: 10px auto;
  font-size: 16px;
  border: 1px solid #233;
  background-color: white;
  cursor: pointer;
}

.signup-text {
  margin-top: 30px;
  font-size: 14px;
}

.signup-button {
  width: 25%;
  margin-top: 10px;
}
</style>
