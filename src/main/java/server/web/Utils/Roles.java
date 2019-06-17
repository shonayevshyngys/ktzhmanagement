package server.web.Utils;

import io.javalin.security.Role;

public enum Roles implements Role {
    ANYONE,
    USER,
    ADMIN
}
