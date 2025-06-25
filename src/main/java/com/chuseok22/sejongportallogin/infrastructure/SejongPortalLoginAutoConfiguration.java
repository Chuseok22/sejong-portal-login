package com.chuseok22.sejongportallogin.infrastructure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.chuseok22.sejongportallogin.infrastructure")
public class SejongPortalLoginAutoConfiguration {
  // 필요 시 @Bean 정의나 @ConditionalOnMissingBean 처리도 추가
}
