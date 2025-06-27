<template>
  <div class="register-container">
    <!-- ハンバーガーメニュー -->
    <div class="menu-icon" @click="toggleSidebar">☰</div>

    <!-- サイドバー -->
    <div class="sidebar" :class="{ open: isSidebarOpen }">
      <button @click="navigateTo('/login')">ログイン</button>
      <button @click="navigateTo('/register')">新規登録</button>
      <button @click="toggleSidebar" class="back-button">戻る</button>
    </div>

    <!-- メイン登録フォーム -->
    <h2>新規登録</h2>
    <form @submit.prevent="handleConfirm">
      <input type="text" v-model="name" placeholder="名前" required />
      <input type="email" v-model="email" placeholder="メールアドレス" required />
      <input type="password" v-model="password" placeholder="パスワード" required />
      <button type="submit">確認</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const name = ref('')
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

const handleConfirm = () => {
  router.push({
    name: 'RegisterConfirm',
    query: {
      name: name.value,
      email: email.value,
      password: password.value
    }
  })
}
</script>

<style scoped>
:global(html, body) {
  margin: 0;
  padding: 0;
  height: 100%;
}

.register-container {
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
  margin-top: calc(100% - 45px); /* 戻るボタンの位置を少し下へ */
}

/* 入力欄とボタンのサイズ調整（1/2サイズ） */
input {
  display: block;
  width: 25%; /* ログイン画面と同様 */
  padding: 10px;
  margin: 10px auto;
  border: 1px solid #233;
  font-size: 16px;
  box-sizing: border-box;
}
button {
  width: 25%;
  padding: 10px;
  margin: 10px auto;
  font-size: 16px;
  border: 1px solid #233;
  background-color: white;
  cursor: pointer;
}
</style>
