package OOP.core.member;

import OOP.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join() {
        Member member= new Member(1L,"memberA",Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        assertThat(member).isEqualTo(findMember);
    }
}
