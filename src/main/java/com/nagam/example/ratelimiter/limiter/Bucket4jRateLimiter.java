package com.nagam.example.ratelimiter.limiter;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class Bucket4jRateLimiter {

    private final Map<String, Bucket> cache = new ConcurrentHashMap<>();

    public boolean isAllowed(String key) {
        Bucket bucket = cache.computeIfAbsent(key, this::newBucket);
        return bucket.tryConsume(1);
    }

    private Bucket newBucket(String key) {
        Bandwidth limit = Bandwidth.classic(50, Refill.intervally(50, Duration.ofSeconds(10)));
        return Bucket4j.builder().addLimit(limit).build();
    }
}
