package com.mag.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;  
  
public class HibernateUtils {  
/* 
  *��ȡHibernate.cfg.xml�ļ� 
*/  
    private static SessionFactory factory;  
      
    static {  
        try {  
            //��ȡhibernate.cfg.xml�ļ�  
            Configuration cfg = new Configuration().configure();  
              
            //����SessionFactory  
            
            ServiceRegistry serviceRegistry= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();  
            factory = cfg.buildSessionFactory(serviceRegistry);
           // factory = cfg.buildSessionFactory();  
        }catch(Exception e) {  
            e.printStackTrace();  
        }  
    }  
    /* 
      *��Session 
    */  
      
    public static Session getSession() {  
        return factory.openSession();  
    }   
    /* 
      *�ر�Session 
    */  
      
    public static void closeSession(Session session) {  
        if (session != null) {  
            if (session.isOpen()) {  
                session.close();  
            }  
        }  
    }  
      
    public static SessionFactory getSessionFactory() {  
        return factory;  
    }  
}  