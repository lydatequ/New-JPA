package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Sales;

public class SalesDao {
    
    protected EntityManagerFactory entityManagerFactory;
            protected EntityManager em;
    
    public SalesDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("NewJPAPU");
        em = entityManagerFactory.createEntityManager();  
    }
    
    public Sales getSales(Integer scode){
        return em.find(Sales.class, scode);
    }
    
    public List<Sales> fetchSales(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
            return entityManager.createNamedQuery("Sales.findAll").getResultList();     
    }
    
    public Sales getTopSale(){
        TypedQuery  <Sales> q = em.createQuery("SELECT s FROM Sales s WHERE s.quant=("
                + "SELECT MAX(s.quant) FROM Sales s)", Sales.class);
        return q.getSingleResult();
//        return q.getResultList();

//        Query q1 = em.createQuery("Select s from Sales s WHERE s.quant = "
//                + "(SELECT MAX(s.quant) FROM Sales s)");
//        return (List<Sales>) q1.getSingleResult();
    }
    
    public List <Sales> getAllSales(){
        Query q = em.createNativeQuery("Select * from Sales", Sales.class);
        
        return q.getResultList();
    }
    
    public List<Sales> getSalesByQuant (Integer quant){
        return em.createNamedQuery("Sales.findByQuant")
                .setParameter("quant", quant)
                .getResultList();
    }
    
}
