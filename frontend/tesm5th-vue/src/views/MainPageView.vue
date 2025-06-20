<template>
    <div class="main-page">
        <h1>ホテルを探す</h1>

        <!-- 🔸検索フォーム -->
         <div class="search-form">
            <!-- キーワード検索 -->
             <input
             v-model="searchKeyword"
             type="text"
             placeholder="ホテル名やキーワード"
             />

             <!-- 🔸チェックイン・アウト -->
              <div class="date-pickers">
                <label>               
                    チェックイン:
                    <input type="date" v-model="checkInDate"/>
                </label>
                <label>
                    チェックアウト:
                    <input type="date" v-model="checkOutDate"/>
                </label>
         </div>

         <!-- 🔸地域選択 -->
          <div class="regoin-select">
            <button @click="toggleRegionList">
                地域を選ぶ
            </button>
            <div v-if="showRegions" class="region-list">
                <button v-for="pref in prefectures":key="pref"@click="selectRegion(pref)">
                    {{ pref }}
                </button>
            </div>
            <p v-if="selectedRegion">選択中:{{ selectedRegion }}</p>
          </div>

          <!-- 🔸検索ボタン -->
           <button @click="searchHotels">検索</button>
         </div>
    </div>
</template>

<script setup>
import {ref} form 'vue'
import {useRouter} from 'vue-router'

const router=useRouter()

const searchKeyword=ref('')
const checkInDate=ref('')
const checkOutDate=ref('')
const selectedRegion=ref('')
const showRegions=ref(false)

const toggleRegionList=()=>{
    selectedRegion.value=region
    showRegions.value=false
}

const prefectures[
    '北海道','青森県','秋田県','岩手県','宮城県','山形県','福島県',
    '茨城県','栃木県','群馬県','埼玉県','千葉県','東京都','神奈川県',
    '新潟県','富山県','石川県','福井県','山梨県','長野県',
    '岐阜県','静岡県','愛知県','三重県'
    '滋賀県','京都府','大阪府','兵庫県','奈良県','和歌山県',
    '岡山県','鳥取県','島根県','広島県','山口県',
    '徳島県','香川県','高知県','愛媛県',
    '福岡県','佐賀県','長崎県','大分県','熊本県','宮崎県','鹿児島県',
    '沖縄県'
]

const searchHotels=()=>{
    router.push({
        path:'hotels',
        query:{
            keyword: searchKeyword.value,
            region: selectedRegion.value,
            checkIn: checkInData.value,
            checkOut: checkOutDate.value
        }
    })
}
</script>

<style scoped>
.main-page {
  padding: 40px;
  max-width: 700px;
  margin: 0 auto;
  text-align: center;
}
.search-form {
  margin-top: 20px;
}
input[type="text"],
input[type="date"] {
  margin: 10px;
  padding: 8px;
  width: 80%;
  max-width: 400px;
  font-size: 16px;
}
button {
  margin: 10px;
  padding: 8px 16px;
}
.region-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 8px;
  margin: 10px 0;
}
.region-list button {
  background: #f0f0f0;
  border: 1px solid #ccc;
  padding: 6px 10px;
  cursor: pointer;
}
</style>

