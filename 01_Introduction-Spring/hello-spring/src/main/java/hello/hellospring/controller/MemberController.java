package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //스프링 빈이 관리해준다
public class MemberController {
    //스프링 빈을 등록하는 2가지방법중 하나이다
    //컴포넌트 스캔 방식이다
//    @Autowired  private final MemberService memberService; //이게 필드 주입이라 한다.
//    @Autowired //셋터 인젝션 방식
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }

    //필드주입은 뭔가 바꿀 방법이다 중간에 바꿔치기가 안된다.

//    @Autowired //의존관계를 주입해준다 DI
//    public MemberController(MemberService memberService) {
//        this.memberService=memberService;
//    }

    // 결론은 생성자 방법을 쓰는게 좋다
    //

    private  MemberService memberService;
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member= new Member();
        member.setName(form.getName());
        memberService.join(member);
        System.out.println(member.getName());
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
