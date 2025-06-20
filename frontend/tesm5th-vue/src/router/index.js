import RegisterView from '../views/RegisterView.vue'
import RegisterConfirmView from '../views/RegisterConfirmView.vue'
import RegisterCompleteView from '../views/RegisterCompleteView.vue'

const routes = [
  { path: '/register', name: 'Register', component: RegisterView },
  { path: '/register/confirm', name: 'RegisterConfirm', component: RegisterConfirmView },
  { path: '/register/complete', name: 'RegisterComplete', component: RegisterCompleteView }
]
