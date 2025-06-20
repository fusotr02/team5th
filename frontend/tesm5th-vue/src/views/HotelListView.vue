<template>
  <div class="hotel-list">
    <h1>ホテル一覧</h1>
    <div v-if="hotels.length === 0">ホテルが見つかりませんでした。</div>

    <div class="hotel-grid">
      <HotelCard
        v-for="hotel in hotels"
        :key="hotel.id"
        :hotel="hotel"
        @click="goToDetail(hotel.id)"
      />
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'
import HotelCard from '../components/HotelCard.vue'

const hotels = ref([])
const router = useRouter()

onMounted(async () => {
  try {
    const response = await axios.get('/api/hotels') // Spring BootのHotelControllerが返す一覧
    hotels.value = response.data
  } catch (error) {
    console.error('ホテル一覧取得失敗:', error)
  }
})

const goToDetail = (hotelId) => {
  router.push(`/hotel/${hotelId}`) // 例: /hotel/3 → HotelDetailViewへ
}
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
