package csmart.api.controllers;

import csmart.api.dao.ClassRepo;
import csmart.api.model.Class;
import csmart.api.model.User;
import csmart.api.service.ClassService;
import csmart.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassService classService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void createClass(@RequestBody Class klass){
        classService.createClass(klass);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Class getClassById(@PathVariable("id")  int id){
        return classService.getClassById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Class> getClasses(){
        return classService.getClasses();
    }

    @RequestMapping(value = "/{id}/users", method = RequestMethod.GET)
    public @ResponseBody List<User> getUsersByClass(@PathVariable("id")  int id){
        return classService.getUsersByClass(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteClassById(@PathVariable("id") int id){
        classService.deleteClassById(id);
    }


}
