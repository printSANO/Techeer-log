import {defineConfig} from "vite";
import react from "@vitejs/plugin-react";

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [react()],
    server: {
        port: 3000,
        host: true,
        proxy: {
            "/members": "http://consolelog.store:8080",
            "/posts": "http://consolelog.store:8080",
            "/api": "http://consolelog.store:8080",
            "/post": "http://consolelog.store:8080",
            "/board": "http://consolelog.store:8080",
            "/login": "http://consolelog.store:8080",
        },
    },
});
