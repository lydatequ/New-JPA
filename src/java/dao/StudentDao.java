package dao;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;

public class StudentDao {
    
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewJPAPU");
    
    public List<Student> fetchStudents(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        return entityManager.createNamedQuery("Student.findAll").getResultList();     
    }
    
    public void insertStudent(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student s = new Student();
        s.setId(4);
        s.setName("Josh");
        s.setSurname("Mick");
        s.setGrade(12);
        s.setDob(Date.from(LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC)));
        entityManager.getTransaction().begin();
        entityManager.persist(s);
        entityManager.getTransaction().commit();
    
        Student s2 = entityManager.find(Student.class, 4);
        Student s3 = entityManager.merge(s);
    
    
    
    }
    
    
    
    
}
