package server.web.Handlers;

import io.javalin.Context;
import io.javalin.Handler;
import org.jetbrains.annotations.NotNull;
import server.domain.dao.UserDAO;
import server.domain.model.User;
import server.web.Utils.UserData;
import server.web.response_models.UserInfo;

public class UserInfoHandler implements Handler {
    int numberOfLoggins = 0;
    int numberOfTakeOffs = 0;
    int numberOfUpdateCalls = 0;
    int numberOfAddedWagons = 0;
    @Override
    public void handle(@NotNull Context context) throws Exception {
        UserData data = new UserData(context);
        UserInfo info = new UserInfo();
        User u =UserDAO.getByUsername(data.getUsername());
        info.setId(u.getId());
        info.setIp(context.ip());
        info.setLastLoginTime(u.getLastLoginTime());

        u.getUserActionList().forEach(userAction -> {
            if(userAction.getAction().equals("logged_in")) numberOfLoggins++;
            if(userAction.getAction().equals("add_wagon")) numberOfAddedWagons++;
            if(userAction.getAction().equals("take_off_wagon")) numberOfTakeOffs++;
            if(userAction.getAction().equals("get_wagon")) numberOfUpdateCalls++;
        });
        info.setNumberOfLogins(numberOfLoggins);
        info.setNumberOfTakeOffs(numberOfTakeOffs);
        info.setNumberOfUpdateCalls(numberOfUpdateCalls);
        info.setNumberOfAddedWagons(numberOfAddedWagons);
        info.setNumberOfWagonsNow(u.getUserWagons().size());

        context.status(200);
        context.json(info);
    }
}
