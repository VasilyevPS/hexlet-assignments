package exercise.controllers;

import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;
import io.ebean.DB;
import java.util.List;

import exercise.domain.User;
import exercise.domain.query.QUser;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

public class UserController implements CrudHandler {

    public void getAll(Context ctx) {
        // BEGIN
        List<User> users = new QUser()
                .orderBy().id.asc()
                .findList();

        String json = DB.json().toJson(users);

        ctx.json(json);
        // END
    };

    public void getOne(Context ctx, String id) {

        // BEGIN
        User user = new QUser()
                .id.equalTo(Long.parseLong(id))
                .findOne();

        String json = DB.json().toJson(user);

        ctx.json(json);
        // END
    };

    public void create(Context ctx) {

        // BEGIN
        User user = ctx.bodyValidator(User.class)
                .check(obj -> obj.getFirstName().length() > 0, "First name can not be empty")
                .check(obj -> obj.getLastName().length() > 0, "Last name can not be empty")
                .check(obj -> EmailValidator.getInstance().isValid(obj.getEmail()), "Email should be valid")
                .check(obj -> StringUtils.isNumeric(obj.getPassword()), "Password must contains only digits")
                .check(obj -> obj.getPassword().length() > 4, "Password must contain more than 4 characters")
                .get();

        user.save();
        // END
    };

    public void update(Context ctx, String id) {
        // BEGIN
        String body = ctx.body();
        User user = DB.json().toBean(User.class, body);
        user.setId(id);
        user.update();
        // END
    };

    public void delete(Context ctx, String id) {
        // BEGIN
        new QUser()
                .id.equalTo(Long.parseLong(id))
                .delete();
        // END
    };
}
