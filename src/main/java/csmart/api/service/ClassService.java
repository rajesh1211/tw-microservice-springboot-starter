package csmart.api.service;

import csmart.api.dao.ClassRepo;
import csmart.api.model.Class;
import csmart.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/* This class is not being used for the task , was testing the starter kit with this*/

@Component
public class ClassService {
    @Autowired
    private ClassRepo classRepo;

    public void createClass(Class klass){
        classRepo.createClass(klass);
    }

    public Class getClassById(int id){
        return classRepo.getClass(id);
    }

    public List<Class> getClasses(){
        try {
            return classRepo.getClasses();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getUsersByClass(int id){
        try {
            return classRepo.getUsersByClass(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteClassById(int id){
        classRepo.deleteClassById(id);
    }

}
