package org.koreait.configs.jwt;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
@EnableConfigurationProperties(JwtProperties.class)
public class TokenProvider {
    @Autowired
    private JwtProperties jwtProperties;

    private final String secret;
    private final long tokeValidityInSeconds;

    private Key key;

    public TokenProvider() {
        secret = jwtProperties.getSecret();
        tokeValidityInSeconds = jwtProperties.getAccessTokenValidityInSeconds();

        byte[] bytes = Decoders.BASE64.decode(secret);
        key = Keys.hmacShaKeyFor(bytes);
    }

    public String createToken(Authentication authentication) {

        return null;
    }
}
