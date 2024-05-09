package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.VoterDetailsService;

public class SpringBeanLifeCycleTest {

	 public static void main(String[] args) {
		//create IOC container
		   AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		   //get Spring Bean
		   VoterDetailsService service=ctx.getBean("voter",VoterDetailsService.class);
		   //invoke the b.method
		   String result=service.checkVotingElgibility();
		   System.out.println(result);
		   
		   //close the container
		   ctx.close();
		   
	}
}
