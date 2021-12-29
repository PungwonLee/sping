package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(                                //AppConfig, TestConfig 앞에서 만든 설정을 제외하기 위해 excludeFilters를 이용함 ( Configuration 이것을 제외하는 것임 )
        basePackages = "hello.core.member", //멤버만 컴포넌트 스캔대상이된다. >> 어디서 찾는지 지정할 수 있다.
        basePackageClasses = AutoAppConfig.class,       //지정한 클래스의 패키지를 탐색 시작 위로 지정한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
//default 지정하지 않은 것 패키지 package hello.core의 위치를 다 찾는다
public class AutoAppConfig {
}
