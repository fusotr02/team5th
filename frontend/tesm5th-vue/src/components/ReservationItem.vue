<template>
  <div class="reservation-item">
    <img :src="reservation.hotelImageUrl || '/assets/no-image.jpg'" alt="ホテル画像" class="hotel-image" />
    <div class="info">
      <h3>{{ reservation.hotelName || 'ホテル名未取得' }}</h3>
      <p>チェックイン：{{ formattedCheckIn }}</p>
      <p>チェックアウト：{{ formattedCheckOut }}</p>
      <p>人数：{{ reservation.numberOfGuests }} 名</p>
      <router-link :to="`/reservationedit/${reservation.reservationId}`" class="edit-button">
        予約を変更
      </router-link>
    </div>
  </div>
</template>

<script setup>
// import { format } from 'date-fns'
// import ja from 'date-fns/locale/ja'

// definePropsは1回だけでOK
const props = defineProps({
  reservation: Object
})

// 整形済み日付を作成
const formattedCheckIn = format(new Date(props.reservation.checkInDate), 'yyyy年M月d日（EEE）', { locale: ja })
const formattedCheckOut = format(new Date(props.reservation.checkOutDate), 'yyyy年M月d日（EEE）', { locale: ja })
</script>

<style scoped>
.reservation-item {
  display: flex;
  gap: 16px;
  padding: 16px;
  border-bottom: 1px solid #ccc;
  align-items: center;
}
.hotel-image {
  width: 160px;
  height: 100px;
  object-fit: cover;
  border-radius: 8px;
}
.info h3 {
  margin-bottom: 4px;
  font-size: 18px;
}
.edit-button {
  display: inline-block;
  background-color: #1e3a8a;
  color: white;
  padding: 6px 12px;
  border-radius: 4px;
  text-decoration: none;
  margin-top: 8px;
}
.edit-button:hover {
  background-color: #374bbf;
}
</style>
