package OOP.core;

import OOP.core.member.MemberRepository;
import OOP.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//기존의 @Configuration을 등록한 설정정보를 등록하지 않기위해 필터링
@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

/*  수동 등록 (컴포넌트 스캔 충돌 테스트)
  @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

 */
}
