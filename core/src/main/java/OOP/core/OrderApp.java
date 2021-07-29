package OOP.core;

import OOP.core.member.Grade;
import OOP.core.member.Member;
import OOP.core.member.MemberService;
import OOP.core.member.MemberServiceImpl;
import OOP.core.order.Order;
import OOP.core.order.OrderService;
import OOP.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " +order);
    }
}
