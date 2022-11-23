package exercise.controllers;



import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;
import io.ebean.DB;
import java.util.List;

import exercise.domain.User;
import exercise.domain.query.QUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

public class UserController implements CrudHandler {

    public void getAll(Context ctx) {
        // BEGIN
        List<User> users = new QUser()
                .orderBy()
                .id.asc()
                .findList();

        String json = DB.json().toJson(users);
        ctx.json(json);
        // END
    };

    public void getOne(Context ctx, String id) {

        // BEGIN
        User user = new QUser()
                .id.equalTo(Integer.parseInt(id))
                .findOne();

        String json = DB.json().toJson(user);
        ctx.json(json);
        // END
    };

    public void create(Context ctx) {

        // BEGIN

        String body = ctx.body();

        ctx.formParamAsClass("firstName", String.class)
                .check(value -> value.length() > 0, "Firstname cannot be empty");
        ctx.formParamAsClass("lastName", String.class)
                .check(value -> value.length() > 0, "Lastname cannot be empty");
        ctx.formParamAsClass("email", String.class)
                .check(value -> EmailValidator.getInstance().isValid(value), "Incorrect e-mail");
        ctx.formParamAsClass("password", String.class)
                .check(value -> value.length() > 4, "Short password")
                .check(StringUtils::isNumeric, "Password should content only numbers");
        ctx.bodyValidator(User.class);

        User user = DB.json().toBean(User.class, body);
        user.save();


        // END
    };

    public void update(Context ctx, String id) {
        // BEGIN
        String body = ctx.body();
        User updatedUser = DB.json().toBean(User.class, body);
        updatedUser.setId(id);
        updatedUser.update();
        // END
    };

    public void delete(Context ctx, String id) {
        // BEGIN
        User user = new QUser()
                .id.equalTo(Integer.parseInt(id))
                .findOne();
        if (user != null) {
            user.delete();
        }
        // END
    };
}
