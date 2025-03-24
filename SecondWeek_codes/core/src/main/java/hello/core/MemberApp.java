// 간단 서비스 테스트
// Member 객체를 직접 생성해서 테스트해보는 과정

package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();

        // 1. AppConfig 클래스를 스프링 컨테이너없이 그냥 적용
        AppConfig appConfig = new AppConfig();
        final MemberService memberService= appConfig.memberService();


        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
