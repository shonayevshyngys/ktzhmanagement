package server.web.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.javalin.Context;
import io.javalin.security.Role;
import server.web.JWT.JWTAccessManager;
import server.web.JWT.JWTGenerator;
import server.web.JWT.JWTProvider;
import server.web.JWT.JavalinJWT;
import server.domain.model.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWThandler {
    private Algorithm alg;
    private JWTGenerator<User> generator;
    private JWTVerifier verifier;
    private JWTAccessManager accessManager;
    private JWTProvider provider;
    private Map<String, Role> rolesMap;


    public JWThandler(){
        this.alg = Algorithm.HMAC256("another_secret_key");

        generator = (user, alg) -> {
            JWTCreator.Builder token = JWT.create()
                    .withExpiresAt(new Date(System.currentTimeMillis() + (90 * 60 * 1000)))
                    .withClaim("role",user.getRole())
                    .withClaim("username", user.getUsername())
                    .withClaim("id", String.valueOf(user.getId()));
            return token.sign(alg);
        };

        rolesMap = new HashMap<>();
        initRoles();
        verifier = JWT.require(alg).build();
        provider = new JWTProvider(alg,generator,verifier);
        accessManager = new JWTAccessManager("role", rolesMap, Roles.ANYONE);
    }

    public JWTAccessManager getAccessManager() {
        return accessManager;
    }

    public JWTProvider getProvider() {
        return provider;
    }

    public String getToken(User user){
        String s = provider.generateToken(user);
        return s;
    }

    public DecodedJWT getPayload(Context ctx){
        return JavalinJWT.getDecodedFromContext(ctx);
    }
    private void initRoles(){
        rolesMap.put("user", Roles.USER);
        rolesMap.put("admin", Roles.ADMIN);
    }
}
