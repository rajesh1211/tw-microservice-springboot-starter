package csmart.api.classes;

import csmart.api.db.ClassRepo;
import csmart.api.model.Class;
import csmart.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassRepo classRepo;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void createClass(@RequestBody Class klass){
        classRepo.createClass(klass);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Class getClassById(@PathVariable("id")  int id){
        return classRepo.getClass(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Class> getClasses(){
        try {
            return classRepo.getClasses();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}/users", method = RequestMethod.GET)
    public @ResponseBody List<User> getUsersByClass(@PathVariable("id")  int id){
        try {
            return classRepo.getUsersByClass(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
