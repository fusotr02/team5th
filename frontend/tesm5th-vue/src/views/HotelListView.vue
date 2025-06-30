<template>
  <div class="hotel-list">
    <h1>ホテル一覧</h1>

    <div v-if="hasError" class="error-message">ホテルの読み込みに失敗しました。</div>
    <div v-else-if="hotels.length === 0">ホテルが見つかりませんでした</div>

    <div class="hotel-grid" v-else>
      <HotelCard
      v-for="hotel in hotels"
      :key="hotel.id"
      :hotel="hotel"
      />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted,watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'
import HotelCard from '../components/HotelCard.vue'

const hotels = ref([])
const hasError = ref(false) 
const route = useRoute()
const router = useRouter()

const fetchHotels = async () => {
  try {
    const location = route.query.location || ''
    const response = await axios.get('/api/hotels', {
      params: { location }
    })
    hotels.value = response.data
    hasError.value = false
  } catch (error) {
    console.error('ホテル一覧取得失敗:', error)
    hasError.value = true
  }
}

onMounted(fetchHotels) 

watch(() => route.query, fetchHotels, { deep: true })
// const goToDetail = (hotelId) => {
//   router.push(`/hotel/${hotelId}`) // 例: /hotel/3 → HotelDetailViewへ
// }
</script>

<style scoped>
.hotel-list {
  padding: 20px;
}
.hotel-grid {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
}
</style>
