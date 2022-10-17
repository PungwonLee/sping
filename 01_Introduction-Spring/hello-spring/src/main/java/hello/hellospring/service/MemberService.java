package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

 //이거를 넣으면된다 서비스네하고 스프링컨테이너에 등록을해준다
public class MemberService {
    private final MemberRepository memberRepository ;
    //순수한 자바 클래스 스프링이 알수 없다
     //멤버서비스는 멤버리포지토리가 필요하다 스프링이 생성할때 뜰떄
    // 어라 서비스네 하고 생성자를 호출한다 그떄 오토와이어드가 있으면 아너는 멤버리포지토리가 필요하구나 스프링이 멤버리포지토리를 넣어준다
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*

     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
