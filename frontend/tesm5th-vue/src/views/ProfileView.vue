<template>
  <div class="container">
    <!-- ヘッダー（上固定） -->
    <header class="header">
      <h1>ホテル予約サイト</h1>
      <p>
        <router-link to="/mypage" class="link">マイアカウント</router-link> ＞個人情報
      </p>
    </header>

    <!-- 本文エリア（左右2分割） -->
    <div class="body">
      <!-- 左側メニュー -->
      <aside class="sidebar">
          <router-link to="/profile" class="nav-link" :class="{ active: $route.path === '/profile' }">個人情報</router-link>
          <router-link to="/security" class="nav-link" :class="{ active: $route.path === '/security' }">セキュリティ設定</router-link>
          <router-link to="/reservation" class="nav-link" :class="{ active: $route.path === '/reservation' }">予約履歴</router-link>
          <router-link to="/bookmark" class="nav-link" :class="{ active: $route.path === '/bookmark' }">お気に入り</router-link>
          <router-link to="/payment" class="nav-link" :class="{ active: $route.path === '/payment' }">支払方法</router-link>
          <router-link to="/settings" class="nav-link" :class="{ active: $route.path === '/settings' }">各種設定</router-link>
          <router-link to="/logout" class="nav-link" :class="{ active: $route.path === '/logout' }">ログアウト</router-link>
      </aside>


      <!-- 右側内容 -->
      <main class="content">
        <h1>個人情報</h1>
        <p>個人情報の更新や、情報がどのように使用されているかの確認が行えます</p>
        <hr />
        <div class="card-section">
          <span>氏名　{{ userName }}</span>
          <button class="button">編集</button>
        </div>
        <hr />
        <div class="card-section">
          <span>メールアドレス　{{ userEmail }}</span>
          <br>
          <!--ログイン時に使用するメールアドレスです。予約完了メールもこちらのアドレス宛てに送信されます。-->
          <button class="button">編集</button>
        </div>
        <hr />
        <div class="card-section">
          <span>電話番号　電話番号を登録してください</span>
          <!--ご予約した宿泊施設の提供者が、必要時にこちらの番号におかけします。-->
          <button class="button">編集</button>
        </div>
        <hr />
        <div class="card-section">
          <span>生年月日　生年月日を登録してください</span>
          <button class="button">編集</button>
        </div>
        <hr />
        <div class="card-section">
          <span>性別　性別を選択してください</span>
          <button class="button">編集</button>
        </div>
        <hr />
        <div class="card-section">
          <span>住所　住所を登録してください</span>
          <button class="button">編集</button>
        </div>
        <hr />
      </main>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const userName = ref('')
const userEmail = ref('')

const email = localStorage.getItem('email')

onMounted(async () => {
  try {
    const response = await axios.get(`/auth/me?email=${email}`)
    userName.value = response.data.name
    userEmail.value = response.data.email
  } catch (error) {
    console.error('ユーザー情報の取得に失敗しました', error)
  }
})
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

/* 全体の画面制御 */
.container {
  width: 100vw;
  max-width: 1200px; /* ← 上限を設定 */
  height: 100vh;
  overflow: hidden;
  display: flex;
  flex-direction: column;
  background-color: #ffffff;
}

/* ヘッダー部分 */
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
  color: #ffffff;
}

.link {
  text-decoration: underline;
  color: #bbdefb;
}

.link:hover {
  background-color: transparent; /* 背景色を透明に */
}

.nav-link.active {
  color: #1e3a8a;
  font-weight: bold;
}

/* メイン部分（2分割） */
.body {
  display: flex;
  flex: 1;
  margin: 0;
  padding: 0;
  margin-top: 73px; /* ヘッダー分のスペース */
  height: calc(100vh - 96px);
  background-color: #ffffff;
}

/* 左側メニュー */
.sidebar {
  width: 25%;
  background-color: #f3f4f6;
  padding: 24px 16px 24px 20px; /* ← 左側の余白を増やす */ 
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  height: 330vh; /* 高さを親に合わせる */
  gap: 16px;
}

.nav-link {
  text-decoration: none;
  color: #333;
  font-size: 16px;
}

.nav-link:hover {
  text-decoration: underline;
  background-color: transparent;
}

.nav-link.active {
  color: #1e3a8a;
  font-weight: bold;
}

/* 右側メイン表示 */
.content {
  width: 75%;
  padding: 32px;
  overflow-y: auto;
}

.content h1 {
  font-size: 22px;
  margin-bottom: 8px;
}

.content p {
  color: #555;
  margin-bottom: 16px;
}

hr {
  margin: 16px 0;
  border: none;
  border-top: 1px solid #ccc;
}

/* カード登録セクション */
.card-section {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  background-color: #1e3a8a;
  color: white;
  padding: 8px 16px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
}

.button:hover {
  background-color: #374bbf;
}

/* 画面外スクロールを防止 */
body {
  overflow: hidden;
}
</style>
