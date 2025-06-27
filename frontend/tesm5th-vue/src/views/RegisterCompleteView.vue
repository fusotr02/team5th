<template>
  <div>
    <h1>登録内容確認</h1>
    <p>名前：{{ name }}</p>
    <p>メール：{{ email }}</p>

    <button @click="handleRegister">登録</button>
    <button @click="goBack">戻る</button>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'
import { ref } from 'vue'

// ↓ 前の画面から name や email を props や route query で受け取る想定
const name = ref('')
const email = ref('')
const password = ref('') // ※実際には props や route 経由で渡すのが理想

const router = useRouter()

const handleRegister = async () => {
  try {
    const response = await fetch('/api/auth/register', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      credentials: 'include',
      body: JSON.stringify({
        name: name.value,
        email: email.value,
        password: password.value
      })
    })

    if (response.ok) {
      router.push('/register/complete')
    } else {
      alert('登録に失敗しました')
    }
  } catch (error) {
    console.error(error)
    alert('通信エラーが発生しました')
  }
}

const goBack = () => {
  router.push('/register')
}
</script>
