package uz.jl.lunch_order_rest.configuration.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class JwtUtil {
    public static final Integer expiry = 600_000;
    public static final String secret = "akbarov_007_qwerty_dev_007_dev_qwerty_akbarov_007";

    public static Date getExpiry() {
        return new Date((System.currentTimeMillis() + expiry));
    }

    public static Date getExpiryForRefreshToken() {
        return new Date((System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30)));
    }

    public static Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secret.getBytes());
    }

    public static JWTVerifier getVerifier() {
        return JWT.require(getAlgorithm()).build();
    }
}
