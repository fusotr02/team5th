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

    <!-- 確認フォーム -->
    <div class="confirm-container">
      <h2>登録内容確認</h2>
      <div class="confirm-info">
        <p><strong>名前：</strong>{{ form.name }}</p>
        <p><strong>メール：</strong>{{ form.email }}</p>
      </div>
      <div class="button-group">
        <button @click="handleRegister">登録</button>
        <button @click="$router.back()">戻る</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      form: history.state
    }
  },
  methods: {
    async handleRegister() {
      await axios.post('/api/auth/register', this.form)
      this.$router.push('/register/complete')
    }
  }
}
</script>

<style scoped>
.wrapper {
  position: relative;
  min-height: 100vh;
  background-color: #f8f9fa;
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

/* 確認フォーム */
.confirm-container {
  max-width: 400px;
  margin: 40px auto;
  padding: 2rem;
  background: #ffffff;
  border-radius: 8px;
  box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.confirm-info {
  text-align: left;
  margin: 1rem 0;
}

.confirm-info p {
  margin: 0.5rem 0;
  font-size: 16px;
}

.button-group {
  display: flex;
  justify-content: space-between;
  gap: 1rem;
  margin-top: 1.5rem;
}

button {
  flex: 1;
  padding: 10px;
  background-color: #1976d2;
  color: white;
  border: none;
  border-radius: 4px;
  font-weight: bold;
  cursor: pointer;
}

button:hover {
  background-color: #1259a3;
}
</style>
