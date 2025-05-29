package Splitwise;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GroupController {

    List<Group> groups;

    public GroupController(){
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group){
        this.groups.add(group) ;
    }

}
