package hello.core;

import hello.core.discount.DisCountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration // 안붙여주면 Appconfig CGLIB 가 아닌 순수 Appconfig가 등록돼서 싱글톤이 보장되지 않는다.
public class AppConfig {

    // @Bean이 붙은 메서드를 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.
    // 이렇게 등록된 객체를 스프링 빈 이라고 한다.
    // 스프링 빈의 이름은 호출한 메서드명을 사용한다.
    // CGLIB 덕분에 스프링 컨테이너에 객체가 등록돼있으면 객체를 생성하지 않고, 등록된 객체를 반환하기 때문에 싱글톤을 보장할 수 있다.

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), disCountPolicy());
    }

    @Bean
    public DisCountPolicy disCountPolicy(){
        return new RateDiscountPolicy();
    }
}
