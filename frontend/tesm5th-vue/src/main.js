// src/main.js または src/main.ts

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import store from './store'

// ここで axios のグローバル設定をする
axios.defaults.baseURL = 'http://localhost:8080'
axios.defaults.withCredentials = true // Cookie付き通信が必要な場合のみ

const app = createApp(App)
app.use(router)
app.use(store)
app.mount('#app')
