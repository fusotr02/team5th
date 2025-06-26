<template>
 <div class="container">
     <!-- ヘッダー -->
     <header class="header">
         <h1>ホテル予約サイト</h1>
         <p>
         <router-link to="/mypage" class="link">マイアカウント</router-link> ＞予約履歴
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


         <div class="reservation-view">
             <h1>予約履歴</h1>
             <p>あなたの予約一覧を確認できます。</p>
             <hr />
             <div v-if="reservations.length === 0">予約が見つかりません。</div>
             <div v-else>
                 <ReservationItem
                      v-for="res in reservations"
                      :key="res.reservationId"
                      :reservation="res"
                    />
              </div>      
         </div>
      </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import ReservationItem from '@/components/ReservationItem.vue'

const reservations = ref([])


onMounted(async () => {
  const userData = localStorage.getItem('user')
  if (!userData) {
    console.error('ログインユーザー情報がありません')
    return
  }
  const user = JSON.parse(userData)
  const userId = user.id 

  try {
    const res = await axios.get(`/api/reservation/user/${userId}`)

    reservations.value = res.data.map(r => ({
      reservationId: r.id,
      hotelId: r.hotel.id,
      hotelName: r.hotel.name,
      hotelImageUrl: r.hotel.imageUrl || '/assets/no-image.jpg',
      checkInDate: r.checkin_date?.slice(0, 10), // "2025-07-01"
      checkOutDate: r.checkout_date?.slice(0, 10),
      numberOfGuests: r.people
    }))   
  } catch (e) {
    console.error('予約データ取得エラー:', e)
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
  max-width: 1200px;
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

.body {
  display: flex;
  margin-top: 73px;
  height: calc(100vh - 96px);
  background-color: #ffffff;
}

/* サイドバー */
.sidebar {
  width: 25%;
  height: 350vh;
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

.reservation-view {
  max-width: 960px;
  margin: 40px auto;
  padding: 0 20px;
}
h1 {
  font-size: 24px;
  margin-bottom: 16px;
}
p {
  margin-bottom: 12px;
  color: #555;
}
hr {
  width: 800px;
  margin: 16px 0;
  border-top: 1px solid #ccc;
}
</style>
