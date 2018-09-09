package repository.impl;

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;

import java.util.List;


@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Student> getStudents() {
        Session session = sessionFactory.getCurrentSession();


        return session.createQuery("from student").list();
    }

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(student);
    }

    @Override
    public void delStudent(int studId) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, studId);
        session.delete(student);
    }

    @Override
    public void editStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student oldSt = session.get(Student.class, student.getId());
        oldSt.setAdmin(student.getAdmin());
        oldSt.setAge(student.getAge());
        oldSt.setName(student.getName());
        session.merge(oldSt);
    }

    @Override
    public Student getStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }


}
