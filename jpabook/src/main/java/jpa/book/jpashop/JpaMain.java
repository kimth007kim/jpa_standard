package jpa.book.jpashop;

import jpa.book.jpashop.domain.Member;
import jpa.book.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityMangerFactory는 하나만 생성해서 애플리케이션 전체가 공유

        EntityManager em = emf.createEntityManager();
//      EntityManger는 쓰레드간에 공유x  사용하고 버려야한다. JPA의 모든 데이터변경은 트랜잭션 안에서 실행해야한다.

        EntityTransaction tx= em.getTransaction();
        tx.begin();

        try{
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            Member member = em.find(Member.class, memberId);;

//            order.getMember();
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
