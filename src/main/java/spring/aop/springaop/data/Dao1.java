package spring.aop.springaop.data;

import org.springframework.stereotype.Repository;

// This class is the one that talks with database, so that is why we should have @Repository annotation on it
@Repository
public class Dao1 {
    public String retrieveSomething() {
        return "Dao1" ;
    }
}
