package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    /*private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    */
    // @PersistenceContext 스펙상 필요하나 안 해도 스프링에서 DI 해준다.
    // private EntityManager em;

    private final MemberRespository memberRespository;

    @Autowired
    public SpringConfig(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    @Bean
    public MemberService memberService() {
        // return new MemberService(memberRespository());
        return new MemberService(memberRespository);
    }
/*
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
*/
//    @Bean
    //    public MemberRespository memberRespository(){
        //return new MemoryMemberRespository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
   // }
}
