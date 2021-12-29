package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
//@Qualifier("mainDiscountPolicy") //문자기 때문에 오류발생해도 모른다
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent=10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return price*discountPercent/100;

        return 0;
    }
}
