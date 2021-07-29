package OOP.core;

import OOP.core.discount.DiscountPolicy;
import OOP.core.discount.FixDiscountPolicy;
import OOP.core.member.MemberRepository;
import OOP.core.member.MemberService;
import OOP.core.member.MemberServiceImpl;
import OOP.core.member.MemoryMemberRepository;
import OOP.core.order.OrderService;
import OOP.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
