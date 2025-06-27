<template>
  <div>
    <!-- 共通ヘッダー -->
    <header class="header">
      <h1>team5th</h1>
      <p class="welcome">ホテル予約サイト</p>
    </header>

    <!-- フォーム -->
    <div class="form-container">
      <h2>予約フォーム</h2>
      <form @submit.prevent="submitForm" class="reservation-form">
        <div class="form-group">
          <label>ホテル名</label>
          <input v-model="form.hotelName" required />
        </div>
        <div class="form-group">
          <label>部屋タイプ</label>
          <input v-model="form.roomType" required />
        </div>
        <div class="form-group">
          <label>チェックイン日</label>
          <input type="date" v-model="form.checkInDate" required />
        </div>
        <div class="form-group">
          <label>チェックアウト日</label>
          <input type="date" v-model="form.checkOutDate" required />
        </div>
        <div class="form-group">
          <label>人数</label>
          <input type="number" min="1" v-model.number="form.guests" required />
        </div>
        <button type="submit">確認へ進む</button>
      </form>
    </div>
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
    submitForm() {
      this.$router.push({ name: 'ReservationConfirm', state: this.form })
    }
  }
}
</script>

<style scoped>
/* 共通ヘッダー */
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

.header p {
  margin: 0;
  font-size: 25px;
}

.welcome {
  text-align: center;
  font-size: 18px;
  margin: 4px 0 0;
}

/* フォーム本体 */
.form-container {
  max-width: 500px;
  margin: 120px auto 0; /* ヘッダー分の余白 */
  padding: 2rem;
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
  text-align: left;
}

h2 {
  text-align: center;
  margin-bottom: 1.5rem;
}

.reservation-form {
  display: flex;
  flex-direction: column;
  gap: 1.2rem;
}

.form-group {
  display: flex;
  flex-direction: column;
}

label {
  font-weight: bold;
  margin-bottom: 4px;
}

input {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 10px;
  background-color: #1976d2;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-weight: bold;
}

button:hover {
  background-color: #1259a3;
}
</style>
