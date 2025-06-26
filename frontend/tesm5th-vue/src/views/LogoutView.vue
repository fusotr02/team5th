<template>
  <div>
    ログアウト中...
  </div>
</template>

<script setup>
import { onMounted } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

onMounted(() => {
  // ローカルストレージなどに保存されたトークンを削除
  localStorage.removeItem('authToken') // 使ってるキー名に合わせて修正

  // 必要ならCookieも削除（例：document.cookie = ...）

  // ホームに遷移
  router.push('/')
})
</script>