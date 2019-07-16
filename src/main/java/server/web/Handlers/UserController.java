package server.web.Handlers;

import io.javalin.Context;
import io.javalin.apibuilder.CrudHandler;
import org.jetbrains.annotations.NotNull;
import server.domain.dao.UserDAO;
import server.domain.model.User;
import server.web.Utils.HashUtils;
import server.web.Utils.UserData;
import server.web.request_models.CreateUser;
import server.web.request_models.UpdateUser;
import server.web.response_models.ErrorResponse;
import server.web.response_models.SuccessMessage;

import java.util.Date;
import java.util.List;

public class UserController implements CrudHandler {
    @Override
    public void create(@NotNull Context context) {
        CreateUser createUser = context.bodyAsClass(CreateUser.class);
        if (!(createUser.getRole().equals("admin") || createUser.getRole().equals("user"))) {
            context.status(400);
            context.json(new ErrorResponse("bad roles"));
        } else {
            User user = new User(new Date(), null, "", createUser.getUsername(), HashUtils.hashPassword(createUser.getPassword()), createUser.getRole());
            UserDAO.persist(user);
            context.status(201);
            context.json(new SuccessMessage("created user"));
        }

    }

    @Override
    public void delete(@NotNull Context context, @NotNull String s) {
        long id = Long.valueOf(s);
        if (UserDAO.delete(UserDAO.getById(id))) {
            context.status(204);
            context.json(new SuccessMessage("Successfully deleted user"));
        } else {
            context.status(400);
            context.json(new ErrorResponse("Bad credentials"));
        }
        //add check for id

    }

    @Override
    public void getAll(@NotNull Context context) {
        List<User> userList = UserDAO.getAllUsers();
//        List<UserResponse> userResponses = new ArrayList<>();
//        for (User user : userList) {
//            userResponses.add(new UserResponse(user));
//        }
        UserData userData = new UserData(context);
        System.out.println(userData.getId());
        System.out.println(userData.getUsername());
        System.out.println(userData.getRole());
        context.status(200);
        context.json(userList);
    }

    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {
        long id = Long.valueOf(s);
        User user = UserDAO.getById(id);
        if (user != null) {
            context.status(200);
            context.json(user);
        } else {
            context.status(400);
            context.json(new ErrorResponse("No such user"));
        }
        //add check for id

    }

    @Override
    public void update(@NotNull Context context, @NotNull String s) {
        UpdateUser updateUser = context.bodyAsClass(UpdateUser.class);
        long id = Long.valueOf(s);
        User user = UserDAO.getById(id);
        if (user != null) {
            if (!updateUser.getUsername().isEmpty() && !updateUser.getUsername().equals("")) {
                user.setUsername(updateUser.getUsername());
            }
            if (!updateUser.getPassword().isEmpty() && !updateUser.getPassword().equals("")) {
                user.setPassword(HashUtils.hashPassword(updateUser.getPassword()));
            }
            UserDAO.update(user);
            context.status(200);
            context.json(new SuccessMessage("user updated"));
        } else {
            context.status(400);
            context.json(new ErrorResponse("Bad credentials"));
        }
        //add check for id

    }
}
