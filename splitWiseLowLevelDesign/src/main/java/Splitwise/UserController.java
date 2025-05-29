package Splitwise;

import java.util.List;

public class UserController {

    List<User> users;

    public UserController(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

}
