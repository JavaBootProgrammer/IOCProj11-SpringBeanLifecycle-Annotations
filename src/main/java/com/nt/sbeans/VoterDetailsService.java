package com.nt.sbeans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("voter")
public class VoterDetailsService {
	@Value("${voter.id}")
	private  Integer vid;
	@Value("${voter.name}")
	private  String   name;
	@Value("${voter.addrs}")
	private  String  addrs;
	@Value("${voter.age}")
	private   Integer age;
	private  Date dov;
	
	public VoterDetailsService() {
		System.out.println("VoterDetailsService:: 0-param constructor");
	}
	
	//custom init method
	@PostConstruct
	public   void myInit() {
		System.out.println("VoterDetailsService.myInit()");
		//check weather important  properties are injected with correct values or not
		if(name==null || name.length()==0 || name.equals("") || age==null || age<=0)
			throw new IllegalArgumentException(" PErson name, age are not given  properly");
		// initialize left over properties
		  dov=new Date();
	}
	
	
	public   String  checkVotingElgibility() {
		System.out.println("VoterDetailsService.checkVotingElgibility()");
		if(age<18)
			return "Mr./Miss/Mrs."+name+" u  r  not elgible for voting --> verified on ::"+dov;
		else
			return "Mr./Miss/Mrs."+name+" u  r   elgible for voting---> verified on ::"+dov;
	}
	
	@PreDestroy
	public   void myDestroy() {
		System.out.println("VoterDetailsService.myDestroy()");
		name=null;
		age=null;
		addrs=null;
		dov=null;
		vid=null;
	}
	
	

}
