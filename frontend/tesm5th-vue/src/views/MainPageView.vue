<template>
  <div class="search-area">
    <section>
      <label for="location">地域を選択</label>
      <select v-model="location" id="location">
        <option value="">選択してください</option>
        <option v-for="pref in prefectures" :key="pref" :value="pref">
          {{ pref }}
        </option>
      </select>
    </section>

    <label>チェックイン日</label>
    <input type="date" v-model="checkIn" />

    <label>チェックアウト日</label>
    <input type="date" v-model="checkOut" />

    <label>予約人数</label>
    <input type="number" v-model.number="guests" min="1" placeholder="人数を入力"/>

    <button @click="searchHotels">検索</button>

    <section class="recommend-area">
      <h2>おすすめホテル</h2>
      <div class="recommend-list">
        <HotelCard
          v-for="hotel in recommendedHotels"
          :key="hotel.id"
          :hotel="hotel"
        />
      </div>
      <router-link to="/hotels" class="more-link">もっと見る</router-link>
    </section>
  </div>
</template>


<script setup>
import {ref} from 'vue' ;
import {useRouter} from 'vue-router';
import HotelCard from '../components/HotelCard.vue';

const router=useRouter()

const location = ref('')
const checkIn = ref('')
const checkOut = ref('')
const guests = ref(1)

// const toggleRegionList=()=>{
//     selectedRegion.value=region
//     showRegions.value=false
// }

const prefectures = [
  '北海道', '青森県', '岩手県', '宮城県', '秋田県', '山形県', '福島県',
  '茨城県', '栃木県', '群馬県', '埼玉県', '千葉県', '東京都', '神奈川県',
  '新潟県', '富山県', '石川県', '福井県', '山梨県', '長野県',
  '岐阜県', '静岡県', '愛知県', '三重県',
  '滋賀県', '京都府', '大阪府', '兵庫県', '奈良県', '和歌山県',
  '鳥取県', '島根県', '岡山県', '広島県', '山口県',
  '徳島県', '香川県', '愛媛県', '高知県',
  '福岡県', '佐賀県', '長崎県', '熊本県', '大分県', '宮崎県', '鹿児島県', '沖縄県'
]

const recommendedHotels = ref([
  { id: 1, name: '東京リゾート', location: '東京都', price: 15000, image: '/img/hotel1.jpg' },
  { id: 2, name: '大阪グランドホテル', location: '大阪府', price: 12000, image: '/img/hotel2.jpg' },
  { id: 3, name: '沖縄ビーチホテル', location: '沖縄県', price: 18000, image: '/img/hotel3.jpg' },
])

const searchHotels = () => {
  router.push({
    path: '/hotels',
    query: {
      location: location.value,
      checkIn: checkIn.value,
      checkOut: checkOut.value,
      guests: guests.value
    }
  })
}
</script>

<style scoped>
.search-area {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  padding: 1.5rem;
  background: #f9f9f9;
  border-radius: 8px;
}

label {
  font-weight: bold;
}

input, select {
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  background-color: #1976d2;
  color: white;
  padding: 0.6rem;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-weight: bold;
}

button:hover {
  background-color: #1259a3;
}

.recommend-area {
  margin-top: 2rem;
}

.recommend-list {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
}

.more-link {
  display: inline-block;
  margin-top: 1rem;
  color: #1976d2;
  font-weight: bold;
}
</style>

