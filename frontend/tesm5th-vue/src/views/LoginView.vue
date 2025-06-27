<template>
  <div class="login-container">
    <!-- ハンバーガーメニュー -->
    <div class="menu-icon" @click="toggleSidebar">☰</div>

    <!-- サイドバー -->
    <div class="sidebar" :class="{ open: isSidebarOpen }">
      <router-link to="/login"><button>ログイン</button></router-link>
      <router-link to="/register"><button>新規登録</button></router-link>
    </div>

    <!-- メインログインフォーム -->
    <h2>ログイン</h2>

    <form @submit.prevent="handleLogin">
      <input
        type="email"
        v-model="email"
        placeholder="メールアドレス"
        required
      />
      <input
        type="password"
        v-model="password"
        placeholder="パスワード"
        required
      />
      <button type="submit">ログイン</button>
    </form>

    <p class="signup-text">
      アカウントをまだ作成していない方はこちら
    </p>

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

const handleLogin = async () => {
  try {
    const response = await fetch('/api/auth/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      credentials: 'include',
      body: JSON.stringify({ email: email.value, password: password.value })
    })

    if (response.ok) {
      router.push('/mypage') // ログイン成功後にマイページへ
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
.login-container {
  position: relative;
  max-width: 400px;
  margin: 50px auto;
  padding: 30px;
  border: 1px solid #233;
  text-align: center;
  font-family: sans-serif;
  overflow: hidden;
}

/* ハンバーガーアイコン */
.menu-icon {
  text-align: left;
  font-size: 24px;
  margin-bottom: 10px;
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

/* 入力フォームなど */
h2 {
  margin-bottom: 20px;
}
input {
  display: block;
  width: 100%;
  padding: 10px;
  margin: 10px auto;
  border: 1px solid #233;
  font-size: 16px;
}
button {
  width: 100%;
  padding: 10px;
  margin-top: 10px;
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
  margin-top: 10px;
}
</style>
