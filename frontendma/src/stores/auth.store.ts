import { defineStore } from 'pinia'
import { authService, type LoginPayload } from '@/services/auth.service'

interface AuthUser {
  id: string | number
  name: string
  email: string
}

interface AuthState {
  user: AuthUser | null
  token: string | null
}

export const useAuthStore = defineStore('auth', {
  state: (): AuthState => ({
    user: null,
    token: localStorage.getItem('auth_token'),
  }),
  getters: {
    isAuthenticated: (state) => !!state.token,
  },
  actions: {
    async login(payload: LoginPayload) {
      const { data } = await authService.login(payload)
      this.token = data.token
      this.user = data.user
      localStorage.setItem('auth_token', data.token)
    },
    async logout() {
      this.token = null
      this.user = null
      localStorage.removeItem('auth_token')
    },
    async fetchCurrentUser() {
      const { data } = await authService.me()
      this.user = data
    },
  },
})
