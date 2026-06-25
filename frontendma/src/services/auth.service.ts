import { api } from './api'

export interface LoginPayload {
  email: string
  password: string
}

export interface LoginResponse {
  token: string
  user: {
    id: string | number
    name: string
    email: string
  }
}

export const authService = {
  login(payload: LoginPayload) {
    return api.post<LoginResponse>('/auth/login', payload)
  },
  logout() {
    return api.post('/auth/logout')
  },
  me() {
    return api.get<LoginResponse['user']>('/auth/me')
  },
}
