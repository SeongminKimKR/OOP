package OOP.core.order;

import OOP.core.annotation.MainDiscountPolicy;
import OOP.core.discount.DiscountPolicy;
import OOP.core.member.Member;
import OOP.core.member.MemberRepository;
import OOP.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
//final이 붙은 객체들을 파라미터로 하는 생성자를 만들어 줌
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    /**
     * 필드 주입
     */
    //@Autowired
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //DIP 원칙을 위배하지 않음

    /**
     * 생성자 주입
     */
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 일반 메서드 주입
     */
    /*@Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/


    /**
     * 세터주입
     */
    /*@Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }*/


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
