package by.DAO;

import by.model.EmployeeEntity;
import by.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by УВД on 01.05.2017.
 */
public class DAOImple {
    public void saveEmployee(EmployeeEntity employeeEntity){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employeeEntity);
        session.getTransaction().commit();
        session.close();
    }
    public List<EmployeeEntity> getList(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<EmployeeEntity> list=session.createQuery("from EmployeeEntity ").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
