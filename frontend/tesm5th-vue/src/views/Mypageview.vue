<template>
  <div class="container">
    <!-- ヘッダー -->
    <header class="header">
      <h1>ホテル予約サイト</h1>
      <p class="welcome">ようこそ、{{ username }} さん！</p>
    </header>

    <!-- メイン -->
    <main class="main">
      <img class="banner" :src="bannerImage" alt="旅行イメージ" />

      <div class="card-grid">
        <!-- 支払い情報 -->
        <div class="card">
          <h2>お支払関連の情報</h2>
          <RouterLink class="link" to="/payment">お支払方法 &gt;</RouterLink>
          <RouterLink class="link" to="/point">ポイント残高 &gt;</RouterLink>
        </div>

        <!-- 旅行情報 -->
        <div class="card">
          <h2>旅行</h2>
          <RouterLink class="link" to="/reservation">予約履歴 &gt;</RouterLink>
          <RouterLink class="link" to="/bookmark">お気に入り &gt;</RouterLink>
        </div>

        <!-- アカウント管理 -->
        <div class="card">
          <h2>アカウント管理</h2>
          <RouterLink class="link" to="/profile">個人情報 &gt;</RouterLink>
          <RouterLink class="link" to="/security">セキュリティ設定 &gt;</RouterLink>
          <RouterLink class="link" to="/settings">各種設定 &gt;</RouterLink>
          <RouterLink class="link" to="/inquiry">お問い合わせ &gt;</RouterLink>
        </div>
      </div>
    </main>
  </div>
</template>

<script setup>
import { RouterLink } from 'vue-router'
import { ref, onMounted } from 'vue'
import bannerImage from '@/assets/premium_photo-1661914240950-b0124f20a5c1.avif'

const username = ref('ゲスト') // 初期値

onMounted(() => {
  const userData = localStorage.getItem('user')
  if (userData) {
    try {
      const user = JSON.parse(userData)
      username.value = user.name || 'ゲスト'
    } catch (e) {
      console.error('ユーザーデータの読み込みに失敗しました', e)
    }
  }
})


</script>

<style>
/* 全体レイアウト */
.container {
  width: 100%;
  height: 100vh;
  overflow-x: hidden;
  background-color: #f9f9f9;
  display: flex;
  flex-direction: column;
  padding-left: 10px;
}

/* ヘッダー（固定）*/
.header {
  background-color: #1e3a8a;
  color: white;
  padding: 16px 40px;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 10;
}

.header h1 {
  margin: 0;
  font-size: 24px;
  text-align: left;
}

.welcome {
  text-align: center;
  font-size: 18px;
  margin: 4px 0 0;
}

.main {
  flex: 1;
  padding: 32px 24px;
  margin-top: 96px;
  box-sizing: border-box;
  width: 100%;
}

.banner {
  width: 900px;
  height: 40vh;
  object-fit: cover;
  border-radius: 12px;
  margin-bottom: 32px;
}

.card-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
  gap: 24px;
  width: 100%;
}

.card {
  background-color: white;
  border: 2px solid #1e3a8a;
  border-radius: 12px;
  padding: 20px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.06);
  transition: transform 0.2s ease;
}


.card:hover {
  transform: translateY(-4px);
}

.card h2 {
  font-size: 18px;
  color: #1e3a8a;
  margin-bottom: 12px;
}

/* リンク */
.link {
  display: block;
  text-decoration: none;
  color: #1e3a8a;
  margin: 6px 0;
}

.link:hover {
  text-decoration: underline;
  background-color: transparent !important;
}
</style>
