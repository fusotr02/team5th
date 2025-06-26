<template>
  <div>
    <h2>予約フォーム</h2>
    <form @submit.prevent="goToConfirm">
      <label>ホテル名：<input v-model="form.hotelName" required /></label><br />
      <label>部屋タイプ：<input v-model="form.roomType" required /></label><br />
      <label>チェックイン：<input type="date" v-model="form.checkInDate" required /></label><br />
      <label>チェックアウト：<input type="date" v-model="form.checkOutDate" required /></label><br />
      <label>人数：<input type="number" v-model.number="form.guests" required /></label><br />
      <button type="submit">確認画面へ</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        hotelName: '',
        roomType: '',
        checkInDate: '',
        checkOutDate: '',
        guests: 1
      }
    }
  },
  methods: {
    goToConfirm() {
      this.$router.push({
        name: 'ReservationConfirm',
        state: this.form
      });
    }
  }
}
</script>
