package com.efacility.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.efacility" })
@Import(value = { SpringSecurityConfig.class })
public class SpringRootConfig {

}
