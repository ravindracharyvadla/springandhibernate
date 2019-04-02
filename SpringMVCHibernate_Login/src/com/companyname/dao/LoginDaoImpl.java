package com.companyname.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class LoginDaoImpl implements LoginDao{

	
	/*private HibernateTemplate hibernateTemplate;
    private static Logger log = Logger.getLogger(AuthService.class);
 
    private LoginDaoImpl() { }
 
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    @Override
    public boolean findUser(String emailId, String password) {
        log.info("Checking the user in the database");
        boolean isValidUser = false;
        String sqlQuery = "from Users u where u.emailId=? and u.password=?";
        try {
            List<Users> userObj = (List<Users>) hibernateTemplate.find(sqlQuery, emailId, password);
            if(userObj != null && userObj.size() > 0) {
                log.info("Id= " + userObj.get(0).getId() + ", Name= " + userObj.get(0).getName() + ", Password= " + userObj.get(0).getPassword());
                isValidUser = true;
            }
        } catch(Exception e) {
            isValidUser = false;
            log.error("An error occurred while fetching the user details from the database", e);    
        }
        return isValidUser;
    }
*/
	
	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
    public boolean findUser(String emailId, String password){
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		//Query using Hibernate Query Language
		String SQL_QUERY ="from Users as o where o.emailId=:emailId and o.password=:password";//Note: Users is Entity class name
		//String SQL_QUERY ="from Users as o where o.emailId=emailId and o.password=password";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("emailId",emailId);
		query.setParameter("password",password);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			userFound= true;
		}
		else{
			userFound= false;
		}

		session.close();
		
		return userFound;              
   }

}
