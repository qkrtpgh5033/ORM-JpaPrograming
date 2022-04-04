import jpabook.jpashop.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        /**
         * EntityManager : 고객의 요청에 따라 DB 작업을 할 때 필요
         */
        EntityManager em = emf.createEntityManager();
        /**
         * 모든 데이터 변경은 "트랜잭션이 필요"
         */
        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();

        //code
        try{

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");
            em.persist(book);

            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
