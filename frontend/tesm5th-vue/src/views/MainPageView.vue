<template>
  <div>
    <!-- サイドメニュー -->
    <div v-if="showMenu" class="side-menu">
      <button class="close-btn" @click="toggleMenu">☰</button>
      <nav>
        <router-link to="/login" @click="toggleMenu">ログイン</router-link>
        <router-link to="/register" @click="toggleMenu">新規登録</router-link>
      </nav>
    </div>

    <!-- 全体ラッパー -->
    <div class="container">
      <!-- ヘッダー -->
      <header class="header">
        <button class="menu-btn" @click="toggleMenu">☰</button>
        <h1>team5th</h1>
        <p class="welcome">ホテル予約サイト</p>
      </header>

      <!-- メイン -->
      <main class="main">
        <!-- 検索エリア -->
        <section class="search-area">
          <h2>ホテルを探す</h2>
          <label>エリアで探す</label>
          <select v-model="location">
            <option value="">選択してください</option>
            <option v-for="pref in prefectures" :key="pref">{{ pref }}</option>
          </select>

          <label>チェックイン日</label>
          <input type="date" v-model="checkIn" />

          <label>チェックアウト日</label>
          <input type="date" v-model="checkOut" />

          <label>予約人数</label>
          <input type="number" v-model.number="guests" min="1" placeholder="人数を入力" />

          <button @click="searchHotels">検索</button>
        </section>

        <!-- おすすめホテル -->
        <section class="recommend-area">
          <h2>おすすめホテル</h2>
          <div class="recommend-list">
            <HotelCard v-for="hotel in recommendedHotels" :key="hotel.id" :hotel="hotel" />
          </div>
          <router-link to="/hotels" class="more-link">もっと見る</router-link>
        </section>
      </main>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import HotelCard from '../components/HotelCard.vue'

const router = useRouter()

const location = ref('')
const checkIn = ref('')
const checkOut = ref('')
const guests = ref(1)

const showMenu = ref(false)
const toggleMenu = () => {
  showMenu.value = !showMenu.value
}

const prefectures = [
  '北海道', '青森県', '岩手県', '宮城県', '秋田県', '山形県', '福島県',
  '茨城県', '栃木県', '群馬県', '埼玉県', '千葉県', '東京都', '神奈川県',
  '新潟県', '富山県', '石川県', '福井県', '山梨県', '長野県',
  '岐阜県', '静岡県', '愛知県', '三重県',
  '滋賀県', '京都府', '大阪府', '兵庫県', '奈良県', '和歌山県',
  '鳥取県', '島根県', '岡山県', '広島県', '山口県',
  '徳島県', '香川県', '愛媛県', '高知県',
  '福岡県', '佐賀県', '長崎県', '熊本県', '大分県', '宮崎県', '鹿児島県', '沖縄県'
]

const recommendedHotels = ref([
  { id: 1, name: '東京リゾート', location: '東京都', price: 15000, image: '/images/hokkaido.jpg' },
  { id: 2, name: '大阪グランドホテル', location: '大阪府', price: 12000, image: '/images/hokkaido.jpg' },
  { id: 3, name: '沖縄ビーチホテル', location: '沖縄県', price: 18000, image: '/images/hokkaido.jpg' },
])

const searchHotels = () => {
  router.push({
    path: '/hotels',
    query: {
      location: location.value,
      checkIn: checkIn.value,
      checkOut: checkOut.value,
      guests: guests.value
    }
  })
}
</script>

<style scoped>
.container {
  width: 100%;
  min-height: 100vh;
  background-color: #ffffff;
  display: flex;
  flex-direction: column;
  padding-left: 10px;
}

.banner {
  width: 900px;
  height: 40vh;
  object-fit: cover;
  border-radius: 12px;
  margin-bottom: 32px;
}

/* ヘッダー */
.header {
  background-color: #1e3a8a;
  color: white;
  padding: 16px 24px; /* 横padding調整 */
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 10;
  display: flex;
  align-items: center;
  gap: 12px; /* ボタンとタイトルの隙間 */
}

.header h1 {
  margin: 0;
  font-size: 24px;
  text-align: left;
}

.header p {
  margin: 0;
  font-size: 25px;
}

.welcome {
  font-size: 18px;
  margin: 4px 0 0;
  flex-grow: 1;  
  text-align: center; 

}

.main {
  flex: 1;
  padding: 32px 24px;
  margin-top: 96px; /* ヘッダー高さ分 */
  box-sizing: border-box;
  width: 100%;
  max-width: 1200px;
  margin-left: auto;
  margin-right: auto;
  background-color: #ffffff;
}

.search-area {
  background: white;
  padding: 2rem;
  border-radius: 8px;
  max-width: 900px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  gap: 1.2rem;
  box-shadow: 0 4px 10px rgba(0,0,0,0.06);
}

.search-area h2 {
  color: #1e3a8a;
  text-align: center;
  font-size: 20px;
  font-weight: bold;
}

label {
  font-weight: bold;
}

input, select {
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  background-color: #1976d2;
  color: white;
  padding: 0.6rem;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-weight: bold;
  transition: background-color 0.3s ease;
}

button:hover {
  background-color: #1259a3;
}

.recommend-area {
  margin-top: 3rem;
  max-width: 900px;
  margin-left: auto;
  margin-right: auto;
}

.recommend-area h2 {
  color: #1e3a8a;
  margin-bottom: 1rem;
  font-size: 20px;
}

.recommend-list {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
  justify-content: center;
}

.more-link {
  display: inline-block;
  margin-top: 1.5rem;
  color: #1976d2;
  font-weight: bold;
  text-align: center;
  width: 100%;
}

.more-link:hover {
  text-decoration: underline;
  background-color: transparent;
}

/* メニューボタン */
.menu-btn {
  background: none;
  border: none;
  font-size: 24px;
  color: white;
  cursor: pointer;
  margin-right: 16px;
  position: relative;
  z-index: 11;
}

/* サイドメニュー */
.side-menu {
  position: fixed;
  top: 0;
  left: 0;
  width: 220px;
  height: 100vh;
  background-color: #1e3a8a;
  color: white;
  padding: 2rem 1rem;
  z-index: 1000;
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  box-shadow: 2px 0 10px rgba(0,0,0,0.2);
}

.side-menu .close-btn {
  background: none;
  border: none;
  color: white;
  font-size: 24px;
  align-self: flex-end;
  cursor: pointer;
}

.side-menu a {
  color: white;
  text-decoration: none;
  font-weight: bold;
  font-size: 18px;
}

.side-menu a:hover {
  text-decoration: underline;
}

.side-menu nav {
  display: flex;
  flex-direction: column;
  gap: 12px; /* リンク間の上下の余白 */
  padding-left: 16px;
}

.side-menu nav a {
  color: white;
  text-decoration: none;
  font-weight: bold;
  font-size: 18px;
  padding-bottom: 8px;
}
</style>
