import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

export default defineConfig({
  base: '/',
  plugins: [react()],
  server: {
      proxy: {
        '/api_event': {
          target: 'http://localhost:8082', // Spring Boot 백엔드
          changeOrigin: true,
          secure: false,
        },
        '/user': {
          target: 'http://localhost:8082',
          changeOrigin: true,
          secure: false,
        },
        '/search': {
          target: 'http://localhost:8082',
          changeOrigin: true,
          secure: false,
        },
      },
    },
});
