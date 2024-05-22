//AppConfig.java
package com.voter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nt.sbeans")
@PropertySource("com/voter/commons/Info.properties")
public class AppConfig {

}
