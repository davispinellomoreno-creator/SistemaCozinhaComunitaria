<script setup lang="ts">
import { useRouter } from 'vue-router'
import { useAuthStore } from '@/stores/auth.store'

const router = useRouter()
const auth = useAuthStore()

const navItems = [
  { label: 'Visão geral', to: '/' },
]

async function handleLogout() {
  await auth.logout()
  router.push({ name: 'login' })
}
</script>

<template>
  <div class="flex h-screen bg-gray-50">
    <aside class="w-64 shrink-0 border-r border-gray-200 bg-white flex flex-col">
      <div class="h-16 flex items-center px-6 border-b border-gray-200">
        <span class="font-semibold text-gray-900">Admin</span>
      </div>
      <nav class="flex-1 px-3 py-4 space-y-1">
        <router-link
          v-for="item in navItems"
          :key="item.to"
          :to="item.to"
          class="block rounded-md px-3 py-2 text-sm font-medium text-gray-700 hover:bg-gray-100"
          active-class="bg-gray-100 text-gray-900"
        >
          {{ item.label }}
        </router-link>
      </nav>
      <div class="p-3 border-t border-gray-200">
        <button
          type="button"
          class="w-full rounded-md px-3 py-2 text-sm font-medium text-gray-700 hover:bg-gray-100 text-left"
          @click="handleLogout"
        >
          Sair
        </button>
      </div>
    </aside>

    <div class="flex-1 flex flex-col overflow-hidden">
      <header class="h-16 flex items-center justify-between px-6 border-b border-gray-200 bg-white">
        <h1 class="text-lg font-semibold text-gray-900">Dashboard</h1>
        <span class="text-sm text-gray-500">{{ auth.user?.name ?? auth.user?.email }}</span>
      </header>
      <main class="flex-1 overflow-y-auto p-6">
        <router-view />
      </main>
    </div>
  </div>
</template>
