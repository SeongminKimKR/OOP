package OOP.core.Autowired;

import OOP.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        /**
         * 자동 주입될 대상이 없으면 메소드 자체 호출 X
         */
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("setNoBean1 = " + member);
        }

        /**
         * 자동 주입될 대상이 없으면 null 입력
         */
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("setNoBean2 = " + member);
        }

        /**
         * 자동 주입될 대상이 없으면 Optional.empty 입력
         */
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("noBean3 = " + member);
        }

    }
}
