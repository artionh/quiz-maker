package DAO;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;

import entityBeans.role;
import entityBeans.user;

public class userDAO {
	public void ADD(user u){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        	 session.beginTransaction();
	        session.save(u);
	        session.getTransaction().commit();
	    } finally {
	        session.close();
	    }
	}
	public void DELETE(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            user u = session.load(user.class, new Integer(id));
            session.delete(u);
        } finally {
            session.close();
        }}
        public void UPDATE(user u){
    	
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                session.update(u);
                session.getTransaction().commit();}
            finally {
                session.close();
            }
    		
    	}
       
		@SuppressWarnings("unchecked")
		public List<user> getUsers(){
        	List<user> users = new ArrayList<>();
             Session session = HibernateUtil.getSessionFactory().openSession();
             try 
             {  session.beginTransaction();
                users = session.createQuery("from user").getResultList();
             } finally {
                 session.close();
             }
             return users;
        	
        }
		public user getUser(String password,String username){
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try 
	        {  session.beginTransaction();
	       String sql =  "from user s where"
					+ " s.username='"+username+"' AND s.password='"+password+"'";
	           return    (user) session.createQuery(sql).getSingleResult();
	        } finally {
	            session.close();
	        }}
	
		public role setRoli(int id){
			
			 Session session = HibernateUtil.getSessionFactory().openSession();
		        try {
		           session.beginTransaction();
		           return( session.load(role.class, new Integer(id)));
		            
		        } finally {
		            session.close();
		        }
		      
		}
		
}
