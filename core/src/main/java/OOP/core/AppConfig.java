package OOP.core;

import OOP.core.discount.DiscountPolicy;
import OOP.core.discount.RateDiscountPolicy;
import OOP.core.member.MemberRepository;
import OOP.core.member.MemberService;
import OOP.core.member.MemberServiceImpl;
import OOP.core.member.MemoryMemberRepository;
import OOP.core.order.OrderService;
import OOP.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
