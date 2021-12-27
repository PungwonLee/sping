package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired //생성에 자동으로 MemberRepository , DiscountPolicy를 주입한다
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    ////    private final DiscountPolicy discountPolicy= new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy= new RateDiscountPolicy();
//                                //DiscountPolicy 만 의존인줄 알았는데 위의 코드처럼 RateDiscountPolicy 도 의존해 DIP를 위반한다!
//                                //FixDiscountPolicy에서  RateDiscountPolicy로 변경하는 순간 OCP를 위반!! //클라이언트 코드에 영향.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discount= discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discount);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
