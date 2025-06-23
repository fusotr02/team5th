import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import RegisterConfirmView from '../views/RegisterConfirmView.vue'
import RegisterCompleteView from '../views/RegisterCompleteView.vue'
import MainPageView from '../views/MainPageView.vue'
// 他の必要なビューもインポート
import MyPageView from '../views/MyPageView.vue'
import ReservationFormView from '../views/ReservationFormView.vue'
import BookmarkListView from '../views/BookmarkListView.vue'

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: LoginView },
  { path: '/register', component: RegisterView },
  { path: '/register/confirm', name: 'RegisterConfirm', component: RegisterConfirmView },
  { path: '/register/complete', component: RegisterCompleteView },
  { path: '/main', component: MainPageView },
  { path: '/mypage', component: MyPageView },
  { path: '/reservation/new', component: ReservationFormView },
  { path: '/bookmarks', component: BookmarkListView },
  // 必要に応じて他のルートも追加
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
