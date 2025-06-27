<template>
  <div class="register-container">
    <!-- ハンバーガーメニュー -->
    <div class="menu-icon" @click="toggleSidebar">☰</div>

    <!-- サイドバー -->
    <div class="sidebar" :class="{ open: isSidebarOpen }">
      <router-link to="/login"><button>ログイン</button></router-link>
      <router-link to="/register"><button>新規登録</button></router-link>
      <div class="sidebar-footer">
        <button class="back-button" @click="toggleSidebar">戻る</button>
      </div>
    </div>

    <h2>新規登録</h2>

    <form @submit.prevent="handleConfirm" class="register-form">
      <input
        type="text"
        v-model="name"
        placeholder="名前"
        required
        class="input-compact"
      />
      <input
        type="email"
        v-model="email"
        placeholder="メールアドレス"
        required
        class="input-compact"
      />
      <input
        type="password"
        v-model="password"
        placeholder="パスワード"
        required
        class="input-compact"
      />
      <div class="center-button-wrapper">
        <button type="submit" class="btn-compact">確認</button>
      </div>
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
.register-container {
  position: relative;
  width: 100vw;
  height: 100vh;
  padding: 30px;
  box-sizing: border-box;
  font-family: sans-serif;
  text-align: center;
  overflow: hidden;
}

/* ハンバーガー */
.menu-icon {
  text-align: left;
  font-size: 24px;
  cursor: pointer;
  margin-bottom: 10px;
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
  padding: 5px;
  margin-bottom: 10px;
  font-size: 12px;
  background-color: white;
  border: 1px solid #333;
  cursor: pointer;
}
.sidebar-footer {
  margin-top: calc(auto - 40px); /* 通常の auto より少し上に */
}
.back-button {
  width: 100%;
}

/* 入力フォーム */
h2 {
  margin-bottom: 20px;
  font-size: 24px;
}
.input-compact {
  display: block;
  width: 25%;
  padding: 4px;
  margin: 10px auto;
  border: 1px solid #233;
  font-size: 10px;
}

/* ボタンを中央に */
.center-button-wrapper {
  display: flex;
  justify-content: center;
}
.btn-compact {
  width: 25%;
  padding: 5px;
  margin-top: 10px;
  font-size: 10px;
  border: 1px solid #233;
  background-color: white;
  cursor: pointer;
}
</style>
