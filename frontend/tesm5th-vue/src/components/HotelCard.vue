<template>
    <div class="hotel-card"@click="goToDetail">
        <img :src="hotel.image" alt="ホテル画像">
        <h3>{{ hotel.name }}</h3>
        <p>{{ hotel.location }}</p>
        <p>\{{ hotel.price }}円</p>
        <button @click.stop="goToDetail">詳細を見る</button>
    </div>
</template>

<script setup>

import {useRouter} from 'vue-router'
const props = defineProps({
    hotel:Object
})

</script>

<style scoped>
.hotel-card{
    border: 1px soild #ccc;
    padding: 1rem;
    border-radius: 8px;
    cursor: pointer;
    transition: transform 0.2s box-shadow 0.2s;
    max-width: 300px;
}

.hotel-card:hover{
    transform: scale(1.02);
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
}

.hotel-card img{
    width: 100%;
    height: 180px;
    object-fit: cover;
    border-radius: 4px;
}

button{
    margin-top: 0.5rem;
    padding: 0.5rem;
    background-color: #1976b2;
    color: white;
    border: none;
    border-radius: 4px;
}

button:hover{
    background-color: #1259a3;
}
</style>