<template>
  <div>
    <!-- 共通ヘッダー -->
    <header class="header">
      <h1>team5th</h1>
      <p class="welcome">ホテル予約サイト</p>
    </header>

    <!-- 内容本体 -->
    <div class="confirm-container">
      <h2>ご予約内容の確認</h2>
      <div class="confirm-details">
        <p><strong>ホテル名：</strong> {{ form.hotelName }}</p>
        <p><strong>部屋タイプ：</strong> {{ form.roomType }}</p>
        <p><strong>チェックイン：</strong> {{ form.checkInDate }}</p>
        <p><strong>チェックアウト：</strong> {{ form.checkOutDate }}</p>
        <p><strong>人数：</strong> {{ form.guests }} 名</p>
      </div>
      <div class="button-group">
        <button class="confirm-btn" @click="submitReservation">予約を確定</button>
        <button class="back-btn" @click="$router.back()">戻る</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: history.state || {
        hotelName: '',
        roomType: '',
        checkInDate: '',
        checkOutDate: '',
        guests: 1
      }
    }
  },
  methods: {
    submitReservation() {
      // ここで API 送信処理などを書く
      alert('予約が確定されました')
      this.$router.push('/main') // 完了後メインに遷移など
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

/* 本体コンテナ */
.confirm-container {
  max-width: 500px;
  margin: 120px auto 0; /* ヘッダー分の余白含む */
  padding: 2rem;
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
  text-align: left;
}
.confirm-container h2{
    text-align: center;
}

.confirm-details p {
  margin-bottom: 10px;
  font-size: 16px;
}

/* ボタン */
.button-group {
  display: flex;
  justify-content: space-between;
  margin-top: 1.5rem;
}

.confirm-btn, .back-btn {
  padding: 10px 16px;
  border: none;
  border-radius: 4px;
  font-weight: bold;
  cursor: pointer;
}

.confirm-btn {
  background-color: #1976d2;
  color: white;
}

.confirm-btn:hover {
  background-color: #1259a3;
}

.back-btn {
  background-color: #ccc;
  color: #333;
}

.back-btn:hover {
  background-color: #bbb;
}
</style>
