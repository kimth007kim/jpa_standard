package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityMangerFactory는 하나만 생성해서 애플리케이션 전체가 공유

        EntityManager em = emf.createEntityManager();
//      EntityManger는 쓰레드간에 공유x  사용하고 버려야한다. JPA의 모든 데이터변경은 트랜잭션 안에서 실행해야한다.

        EntityTransaction tx= em.getTransaction();
        tx.begin();

        try{

            // 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

//            team.getMembers().add(member);

            team.addMember(member);

            em.flush();
            em.clear();

            Team findTeam =  em.find(Team.class , team.getId());
            List<Member> members = findTeam.getMembers();

            System.out.println("================");
            System.out.println("members = "+ findTeam);
            System.out.println("================");


            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
