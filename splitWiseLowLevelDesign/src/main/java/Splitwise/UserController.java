package Splitwise;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserController {

    List<User> userList ;

    public User getUserById(UUID uuid){
        return userList.stream().filter((user -> user.getUuid() == uuid)).collect(Collectors.toList()).get(0) ;
    }

}

