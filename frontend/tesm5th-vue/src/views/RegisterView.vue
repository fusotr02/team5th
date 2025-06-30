<template>

  <div class="register-container">
   <!--  ハンバーガーメニュー -->
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
