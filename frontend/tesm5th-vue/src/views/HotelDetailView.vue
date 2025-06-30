<template>
    <div>
        <h1>{{ hotel?.name }}</h1>
        <img :src="hotel?.image" alt="ホテル画像">
        <p>{{ hotel?.description }}</p>
        <ul>
            <li>場所:{{ hotel?.location }}</li>
            <li>宿泊料金:\{{ hotel?.price }}</li>
        </ul>

        <!-- 🔽 ブックマークボタン -->
        <button class="bookmark-button" @click="toggleBookmark">
        {{ isBookmarked ? '♥' : '♡' }} ブックマーク
        </button>

        <button>予約する</button>
    </div>
</template>


<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()
const hotel = ref(null)

onMounted(async () => {
  hotel.value = await hotelService.fetchHotelById(route.params.id)
})

const goToReserve = () => {
  router.push({ name: 'ReserveForm', params: { hotelId: hotel.value.id } })
}

// 🔽 追加：ブックマーク状態
const isBookmarked = ref(false)
const toggleBookmark = () => {
  isBookmarked.value = !isBookmarked.value
}
</script>

<style scoped>
img {
  max-width: 100%;
  border-radius: 8px;
}
button {
  margin-top: 1rem;
  padding: 0.5rem 1rem;
  background-color: #1976d2;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
button:hover {
  background-color: #1259a3;
}

/* 🔽 追加：ブックマークボタン用スタイル */
.bookmark-button {
  background-color: transparent;
  color: #e53935;
  border: 1px solid #e53935;
  margin-top: 1rem;
  margin-bottom: 0.5rem;
  font-size: 18px;
  padding: 6px 12px;
  border-radius: 4px;
  cursor: pointer;
}
.bookmark-button:hover {
  background-color: #fdecea;
}
</style>