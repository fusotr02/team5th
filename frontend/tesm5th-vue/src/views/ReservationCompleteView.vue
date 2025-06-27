<template>
  <div>
    <!-- 共通ヘッダー -->
    <header class="header">
      <h1>team5th</h1>
      <p class="welcome">ホテル予約サイト</p>
    </header>

    <!-- 完了メッセージ -->
    <div class="complete-container">
      <h2>予約完了</h2>
      <p>ご予約ありがとうございました。</p>
      <router-link to="/" class="back-link">トップへ戻る</router-link>
    </div>
  </div>
</template>

<script>
export default {}
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

/* 完了メッセージ本体 */
.complete-container {
  max-width: 500px;
  margin: 120px auto 0; /* ヘッダー分の余白含む */
  padding: 2rem;
  background: #ffffff;
  border-radius: 8px;
  box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
  text-align: center;
}

h2 {
  font-size: 24px;
  margin-bottom: 1rem;
}

.back-link {
  display: inline-block;
  margin-top: 1.5rem;
  padding: 0.6rem 1.2rem;
  background-color: #1976d2;
  color: white;
  text-decoration: none;
  border-radius: 4px;
  font-weight: bold;
  transition: background-color 0.3s;
}

.back-link:hover {
  background-color: #1259a3;
}
</style>
