<template>
  <div id="app">
    <router-view />
  
  </div>
<hotelsite></hotelsite>
</template>

<script>
import hotelsite from './components/Header.vue'

export default {
  name: 'App',
  components: {
    hotelsite  // 👈 ここを追加！
  }
}
</script>
