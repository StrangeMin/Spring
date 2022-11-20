package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired // 기존 AppConfig에서는 빈에 직접 등록하면서 의존관계를 주입해줬는데, 컴포넌트 스캔 시에는 그런 방식으로 주입 불가능
               // 따라서 Autowired를 생성자에 붙여줌으로써 의존관계를 자동으로 주입해줘야 함
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
