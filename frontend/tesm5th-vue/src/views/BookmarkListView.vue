<template>
  <div class="container">
    <!-- ヘッダー -->
    <header class="header">
      <h1>ホテル予約サイト</h1>
      <p>
        <router-link to="/mypage" class="link">マイアカウント</router-link> ＞ お気に入り
      </p>
    </header>

    <!-- 本文エリア -->
    <div class="body">
      <!-- 左メニュー -->
      <aside class="sidebar">
        <router-link to="/profile" class="nav-link" :class="{ active: $route.path === '/profile' }">個人情報</router-link>
        <router-link to="/security" class="nav-link" :class="{ active: $route.path === '/security' }">セキュリティ設定</router-link>
        <router-link to="/reservation" class="nav-link" :class="{ active: $route.path === '/reservation' }">予約履歴</router-link>
        <router-link to="/bookmark" class="nav-link" :class="{ active: $route.path === '/bookmark' }">お気に入り</router-link>
        <router-link to="/payment" class="nav-link" :class="{ active: $route.path === '/payment' }">支払方法</router-link>
        <router-link to="/settings" class="nav-link" :class="{ active: $route.path === '/settings' }">各種設定</router-link>
        <router-link to="/logout" class="nav-link">ログアウト</router-link>
      </aside>

      <!-- ブックマーク一覧 -->
      <main class="content">
        <h1>お気に入りホテル</h1>
        <p>ブックマークしたホテルの一覧です</p>
        <hr>

        <div class="bookmark-list">
          <div v-for="bookmark in bookmarks" :key="bookmark.bookmarkId" class="bookmark-item">
            <img :src="bookmark.imageUrl || '/assets/no-image.jpg'" class="hotel-image" alt="ホテル画像">
            <div class="hotel-info">
              <h3>{{ bookmark.hotelName || 'ホテル名未取得' }}</h3>
              <button @click="toggleBookmark(bookmark.bookmarkId)" class="heart-button">❤️</button>
              <router-link :to="`/hotel/${bookmark.hotelId}`" class="detail-button">詳細を表示 ➡</router-link>
            </div>
          </div>
        </div>
      </main>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const bookmarks = ref([])
const userId = ref(null)

onMounted(async () => {
  const userData = localStorage.getItem('user')
  if (userData) {
    const user = JSON.parse(userData)
    userId.value = user.id

  try {
    const response = await axios.get(`/api/bookmark/user/${userId.value}`)
    bookmarks.value = response.data
  } catch (error) {
    console.error('ブックマーク取得エラー:', error)
    }
  } else {
    console.warn('ログインユーザー情報が見つかりません')
  }
})

async function toggleBookmark(bookmarkId) {
  try {
    await axios.delete(`/api/bookmark/${bookmarkId}`)
    bookmarks.value = bookmarks.value.filter(b => b.bookmarkId !== bookmarkId)
  } catch (error) {
    console.error('削除失敗:', error)
  }
}
</script>

<style scoped>
/* ヘッダー、ボディなど全体レイアウトは省略（PaymentViewと共通） */

.container {
  width: 100vw;
  max-width: 1200px;
  height: 100vh;
  overflow: hidden;
  display: flex;
  flex-direction: column;
  background-color: #ffffff;
}

.header {
  background-color: #1e3a8a;
  color: white;
  padding: 16px;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 10;
}

.header h1 {
  margin: 0;
  font-size: 24px;
}

.header p {
  margin: 4px 0 0 0;
  font-size: 14px;
  white-space: nowrap !important; 
  display: flex !important;        
  align-items: center !important;  
  gap: 4px !important;  
  width: fit-content;
}

.link {
  text-decoration: underline;
  color: #bbdefb;
  background-color: transparent;
}

.body {
  display: flex;
  margin-top: 80px;
  height: calc(100vh - 96px);
}

/* サイドバー */
.sidebar {
  width: 25%;
  height: 300vh;
  background-color: #f3f4f6;
  padding: 24px 20px;
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.nav-link {
  text-decoration: none;
  color: #333;
}

.nav-link:hover {
  text-decoration: underline;
  background-color: transparent;
}

.nav-link.active {
  color: #1e3a8a;
  font-weight: bold;
}

/* メイン */
.content {
  width: 75%;
  padding: 32px;
  overflow-y: auto;
  background-color: #ffffff;
}

.bookmark-list {
  display: flex;
  flex-direction: column;
  gap: 24px;
  margin-top: 16px;
}

.bookmark-item {
  display: flex;
  align-items: center;
  gap: 16px;
  border-bottom: 1px solid #ccc;
  padding-bottom: 16px;
}

.hotel-image {
  width: 160px;
  height: 10vh;
  object-fit: cover;
  border-radius: 8px;
}

.hotel-info {
  flex: 1;
}

.heart-button {
  border: none;
  background: none;
  font-size: 20px;
  cursor: pointer;
  margin-right: 16px;
}

.detail-button {
  display: inline-block;
  background-color: #1e3a8a;
  color: white;
  padding: 8px 12px;
  border-radius: 4px;
  text-decoration: none;
}

.detail-button:hover {
  background-color: #374bbf;
}
</style>
