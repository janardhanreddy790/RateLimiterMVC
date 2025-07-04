# 🚀 Redis-Backed Rate Limiter (Spring Boot + Bucket4j)

This project demonstrates a **Redis-backed distributed rate limiter** using Spring Boot and Bucket4j.

## ⚙️ How It Works

- Limits: 5 requests per 10 seconds per IP (simulated UUID in this demo)
- Uses **Bucket4j** with **Redisson** client to store buckets in Redis
- Works across multiple instances — perfect for PROD/TST/ACC environments

## 🧪 Test

```bash
for i in {1..10}; do curl -i http://localhost:8080/api/hello; echo; done
```

## 🧰 Stack

- Spring Boot 3.2.4
- Redis (localhost)
- Bucket4j (8.10.1)
- Redisson client (3.24.3)

## 🧱 Redis Setup

Ensure Redis is running locally:

```bash
redis-server
```

Or use Docker:

```bash
docker run -p 6379:6379 redis
```

## 🏁 Run App

```bash
mvn spring-boot:run
```

## 🛡 Good for:
- TST / ACC / PRD environments
- Scalable distributed rate limiting