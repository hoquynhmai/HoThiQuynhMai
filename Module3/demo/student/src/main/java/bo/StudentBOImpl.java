package bo;

import common.Validation;
import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Class;
import model.Student;

import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public List<Student> findAllStudent() {
        return this.studentDAO.findAllStudent();
    }

    @Override
    public Student findByID(String id) {
        return this.studentDAO.findByID(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return this.studentDAO.findByName(name);
    }

    @Override
    public String save(Student student) {

        String message;

        if (testID(student.getId())) {
            message = "Invalid ID ! ID is exists ! Please input ID other !";
        } else if (Validation.regexID(student.getId())) {
            message = "Invalid ID ! Format id is CG-XXX with X is number from 0 to 9 !";
        } else if (Validation.regexAge(student.getAge())) {
            message = "Invalid age ! Age must be positive number and greater than to 18 !";
        } else if (Validation.regexEmail(student.getEmail())) {
            message = "Invalid email ! Format email is abc@abc.abc !";
        } else message = this.studentDAO.save(student);

        return message;

//        return this.studentDAO.save(student);
    }

    @Override
    public String update(Student student) {

        String message;

        if (Validation.regexAge(student.getAge())) {
            message = "Invalid age ! Age must be positive integer and greater than to 18 !";
        } else if (Validation.regexEmail(student.getEmail())) {
            message = "Invalid email ! Format email is abc@abc.abc !";
        } else message = this.studentDAO.update(student);

        return message;

//        return this.studentDAO.update(student);
    }

    @Override
    public void delete(String id) {
        this.studentDAO.delete(id);
    }

    @Override
    public List<Class> findAllClass() {
        return this.studentDAO.findAllClass();
    }

    private boolean testID(String id) {
        List<String> listID = this.studentDAO.findAllIDStudent();
        for (String idExist : listID) {
            if (idExist.equals(id)) {
                return true;
            }
        }
        return false;
    }
}
