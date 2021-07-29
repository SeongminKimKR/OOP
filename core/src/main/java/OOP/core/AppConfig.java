package OOP.core;

import OOP.core.discount.FixDiscountPolicy;
import OOP.core.member.MemberService;
import OOP.core.member.MemberServiceImpl;
import OOP.core.member.MemoryMemberRepository;
import OOP.core.order.OrderService;
import OOP.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy());
    }


}
