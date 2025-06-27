import { createRouter, createWebHistory } from 'vue-router'
import MyPageView from '../views/MyPageView.vue'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import RegisterConfirmView from '../views/RegisterConfirmView.vue'
import RegisterCompleteView from '../views/RegisterCompleteView.vue'
import MainPageView from '../views/MainPageView.vue'
import ReservationFormView from '../views/ReservationFormView.vue'
import BookmarkListView from '../views/BookmarkListView.vue'
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
import ReservationCompleteView from '../views/ReservationCompleteView.vue'

const routes = [
  { path: '/', redirect: '/main' }, // 初期表示はマイページ
  { path: '/main', component: MainPageView }, // ← これが追加された行です

  { path: '/login', component: LoginView },
  { path: '/register', component: RegisterView },
  { path: '/register/confirm', name: 'RegisterConfirm', component: RegisterConfirmView },
  { path: '/register/complete', component: RegisterCompleteView },

  { path: '/mypage', component: MyPageView },
  { path: '/reservation', component: ReservationView },
  { path: '/reservationedit/:id', component: ReservationEditView },
  { path: '/reservation/new', component: ReservationFormView },
  { path: '/reservation/form', name: 'ReservationForm', component: ReservationFormView },
  { path: '/reservation/confirm', name: 'ReservationConfirm', component: ReservationConfirmView },
  { path: '/reservation/complete', name: 'ReservationComplete', component: ReservationCompleteView },

  { path: '/profile', component: ProfileView },
  { path: '/security', component: SecurityView },
  { path: '/payment', component: PaymentView },
  { path: '/point', component: PointView, meta: { requiresAuth: true } },
  { path: '/settings', component: SettingView },
  { path: '/inquiry', component: InquiryView },
  { path: '/logout', component: LogoutView },
  { path: '/bookmark', component: BookmarkListView }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
