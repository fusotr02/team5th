<template>
  <div class="card">
    <img :src="hotel.imageUrl" alt="ホテル画像" class="hotel-image" />

    <div class="info">
      <h2>{{ hotel.name }}</h2>

      <div class="actions">
        <button @click="toggleBookmark" class="heart-button">
          <span v-if="bookmarked">❤️</span>
          <span v-else>🤍</span>
        </button>

        <router-link :to="`/hotel/${hotel.id}`" class="detail-button">
          詳細を表示 ➡
        </router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, watch, defineProps, defineEmits } from 'vue'

const props = defineProps({
  hotel: {
    type: Object,
    required: true
  },
  isBookmarked: {
    type: Boolean,
    required: true
  }
})

const emit = defineEmits(['toggle'])

const bookmarked = ref(props.isBookmarked)

// 親から更新される場合に備えて監視
watch(() => props.isBookmarked, (newVal) => {
  bookmarked.value = newVal
})

// ハートボタンクリック
const toggleBookmark = () => {
  bookmarked.value = !bookmarked.value
  emit('toggle', { hotelId: props.hotel.id, bookmarked: bookmarked.value })
}
</script>

<style scoped>
.card {
  display: flex;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 12px;
  overflow: hidden;
  margin-bottom: 16px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}

.hotel-image {
  width: 180px;
  height: 120px;
  object-fit: cover;
}

.info {
  padding: 16px;
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.actions {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.heart-button {
  font-size: 24px;
  background: none;
  border: none;
  cursor: pointer;
}

.detail-button {
  text-decoration: none;
  color: #1e3a8a;
  font-weight: bold;
}

.detail-button:hover {
  text-decoration: underline;
  background-color: transparent;
}
</style>
