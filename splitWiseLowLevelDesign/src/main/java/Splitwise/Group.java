package Splitwise;

import Splitwise.expense.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
public class Group {

    UUID uuid;

    String description;

    List<User> users;

    List<Expense> expenses;

    public Group() {
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users = this.users.stream().filter((usr) -> usr.getUuid() != user.getUuid()).collect(Collectors.toList());
    }

}
