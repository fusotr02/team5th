<template>
  <div>
    <h2>予約確認</h2>
    <div>
      <p>ホテル名: {{ form.hotelName }}</p>
      <p>部屋タイプ: {{ form.roomType }}</p>
      <p>チェックイン: {{ form.checkInDate }}</p>
      <p>チェックアウト: {{ form.checkOutDate }}</p>
      <p>人数: {{ form.guests }}</p>
    </div>
    <button @click="submitReservation">予約を確定</button>
    <button @click="$router.back()">戻る</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: history.state || {}  // 前画面から受け取る
    }
  },
  methods: {
    submitReservation() {
      // 通常はAPI呼び出し → 成功したら完了画面へ
      this.$router.push({ name: 'ReservationComplete' });
    }
  }
}
</script>
