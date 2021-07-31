package OOP.core.discount;

import OOP.core.annotation.MainDiscountPolicy;
import OOP.core.member.Grade;
import OOP.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
/**
 * @Qualifier 처럼 생성자에도 넣어주어야함
 */
@MainDiscountPolicy
/**
 *같은 타입의 인스턴스가 있다면 이걸 등록
 */
//@Primary
/**
 * 같은 타입이 있다면 생성자에서 지정한 구분자를 생성
 * 단점: 오타
 */
//@Qualifier("mainDiscountPolicy")
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
