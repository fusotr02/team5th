import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import RegisterConfirmView from '../views/RegisterConfirmView.vue'
import RegisterCompleteView from '../views/RegisterCompleteView.vue'
import MainPageView from '../views/MainPageView.vue'
// 他の必要なビューもインポート
//import MyPageView from '../views/MyPageView.vue'
import ReservationFormView from '../views/ReservationFormView.vue'
import BookmarkListView from '../views/BookmarkListView.vue'
import Mypageview from '../views/Mypageview.vue'
import ReservationView from '../views/ReservationView.vue'
import ReservationEditView from '../views/ReservationEditView.vue'
import ProfileView from '../views/ProfileView.vue'
import SecurityView from '../views/SecurityView.vue'
import PaymentView from '../views/PaymentView.vue'
import PointView from '../views/PointView.vue'
import SettingView from '../views/SettingView.vue'
import InquiryView from '../views/InquiryView.vue'
import LogoutView from '../views/LogoutView.vue'
import ReservationConfirmView from '../views/ReservationConfirmView.vue'


const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: LoginView },
  { path: '/register', component: RegisterView },
  { path: '/register/confirm', name: 'RegisterConfirm', component: RegisterConfirmView },
  { path: '/register/complete', component: RegisterCompleteView },
  { path: '/main',   component: MainPageView },
  { path: '/mypage', component: Mypageview },
  { path:'/reservation', component: ReservationView.vue },
  { path: '/reservationedit/:id', component: ReservationEditView.vue },
  { path: '/reservation/new', component: ReservationFormView },
  { path: '/profile', component: ProfileView.vue },
  { path: '/security', component: SecurityView.vue },
  { path: '/payment', component: PaymentView.vue },
  { path: '/point', component: PointView.vue, meta: { requiresAuth: true }},
  { path: '/settings', component: SettingView.vue },
  { path: '/inquiry', component: InquiryView.vue },
  { path: '/logout', component: LogoutView.vue },
  { path: '/bookmark', component: BookmarkListView },
  {path: '/reservation/form', name: 'ReservationForm',component: ReservationFormView},
  {path: '/reservation/confirm',name: 'ReservationConfirm',component: ReservationConfirmView},
  {path: '/reservation/complete',name: 'ReservationComplete',component: ReservationCompleteView}
  // 必要に応じて他のルートも追加
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
