package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component가 붙은 클래스들을 스프링 빈에 자동으로 등록해줌

         // 모든 클래스를 탐색하면 시간이 오래 걸리므로, 탐색을 시작할 위치를 정해준다.
                                            // default값은 ComponentScan이 붙은 class가 포함된 패키지부터 하위 패키지를 탐색한다.
                                            // 지금은 hello.core 패키지에 들어있으므로 hello.core 패키지에 있는 모든 클래스를 탐색한다.
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 스프링 빈에 등록하지 않을 것을 지정
)
public class AutoAppConfig {
}
