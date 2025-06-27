<template>
  <div class="container">
     <!-- ヘッダー -->
     <header class="header">
          <h1>ホテル予約サイト</h1>
          <p>
          <router-link to="/mypage" class="link">マイアカウント</router-link> ＞ 予約内容の編集
          </p>
     </header>

     <!-- 本文エリア -->
     <div class="body">
         <h1>予約内容の変更</h1>

         <div class="reservation-card">
             <h2>{{ reservation.hotelName }}</h2>

             <form class="form" @submit.prevent="submitUpdate">
                 <label>チェックイン日:</label>
                 <input type="date" v-model="reservation.checkInDate" />

                 <label>チェックアウト日:</label>
                 <input type="date" v-model="reservation.checkOutDate" />

                 <label>宿泊人数:</label>
                 <input type="number" min="1" v-model="reservation.numberOfGuests" />

                 <div class="button-group">
                     <button type="submit" class="update-button">予約を更新</button>
                     <button type="button" @click="cancelReservation" class="cancel-button">予約をキャンセル</button>
                 </div>
              </form>
          </div>
          <!-- 予約履歴に戻るボタン -->
          <div class="back-button-wrapper">
             <router-link to="/reservation" class="back-button">
             ← 予約履歴に戻る
             </router-link>
          </div>
      </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import axios from 'axios'

const route = useRoute()
const reservationId = route.params.id

const reservation = ref({
  reservationId: null,
  hotelId: null,
  hotelName: '',
  checkInDate: '',
  checkOutDate: '',
  numberOfGuests: 1
})

// APIから予約詳細取得
onMounted(async () => {
  try {
    const response = await axios.get(`/api/reservation/id/${reservationId}`)
    const data = response.data
    reservation.value = {
      reservationId: data.id,
      hotelId: data.hotel.id,
      hotelName: data.hotel.name,
      checkInDate: data.checkin_date.slice(0, 10), // yyyy-mm-dd形式に変換
      checkOutDate: data.checkout_date.slice(0, 10),
      numberOfGuests: data.people
    }
  } catch (error) {
    console.error('予約情報の取得に失敗しました', error)
  }
})

function submitUpdate() {
  console.log('更新データ:', reservation.value)
  // ここで POST /api/reservation/update/${reservationId} などで送信予定
}

function cancelReservation() {
  console.log('キャンセル処理:', reservation.value.reservationId)
  // ここで予約キャンセルの処理もAPI接続で行う
}
</script>

<style scoped>
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
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2); /* ← 影をつけると浮き出る */
}

.header h1 {
  margin: 0;
  font-size: 24px;
  margin-bottom: 24px;
}

.header p {
  font-size: 14px;
  margin-top: 4px;
}

.link {
  text-decoration: underline;
  color: #bbdefb;
}

.nav-link:hover {
  text-decoration: underline;
  background-color: transparent;
}

.body {
  display: flex;
  padding: 24px;
  margin-top: 96px;
  flex-direction: column;
}

.reservation-card {
  border: 1px solid #ccc;
  border-radius: 12px;
  padding: 24px;
  background-color: #f9f9f9;
}

h1 {
  font-size: 24px;
  margin-bottom: 24px;
}

h2 {
  margin-bottom: 16px;
}

.form label {
  display: block;
  margin-top: 12px;
  font-weight: bold;
}

.form input {
  width: 100%;
  padding: 8px;
  margin-top: 4px;
  border-radius: 4px;
  border: 1px solid #ccc;
}

.button-group {
  margin-top: 24px;
  display: flex;
  gap: 16px;
}

.update-button {
  background-color: #1e3a8a;
  color: white;
  padding: 10px 16px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
}

.cancel-button {
  background-color: #ccc;
  color: #333;
  padding: 10px 16px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
}

.back-button-wrapper {
  margin-top: 32px;
  text-align: center;
}

.back-button {
  display: inline-block;
  padding: 10px 20px;
  background-color: #e0e0e0;
  color: #333;
  border-radius: 6px;
  text-decoration: none;
}

.back-button:hover {
  background-color: #d5d5d5;
}

</style>
