package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pk.service.MsgDetailsImp;

@SpringBootApplication
public class SpringMailingDemoApplication {

	public static void main(String[] args) throws Exception {
	ApplicationContext ctx=	SpringApplication.run(SpringMailingDemoApplication.class, args);
	 MsgDetailsImp msgdetails = ctx.getBean(MsgDetailsImp.class);
	 String email[]=new String[2];
	 email[0]="kunalborchate4747@gmail.com";
	 email[1]="aniket.6402.lipne@gmail.com";
	 String[] msg = {"Demo Message", "Don't Reply To It"};
	 String res = msgdetails.sendMsg(msg, email);
	 System.out.println(res);
	}

}
