package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //final이 붙은 생성자를 만들어준다 25~27행의 코드를 똑같이 만들어줌
public class OrderServiceImpl implements OrderService{
    ////    private final DiscountPolicy discountPolicy= new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy= new RateDiscountPolicy();
//                                //DiscountPolicy 만 의존인줄 알았는데 위의 코드처럼 RateDiscountPolicy 도 의존해 DIP를 위반한다!
//                                //FixDiscountPolicy에서  RateDiscountPolicy로 변경하는 순간 OCP를 위반!! //클라이언트 코드에 영향.

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired //생성에 자동으로 MemberRepository , DiscountPolicy를 주입한다
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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
