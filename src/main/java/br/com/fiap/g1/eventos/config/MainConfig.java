package br.com.fiap.g1.eventos.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:email-properties/main.properties")
public class MainConfig {

	@Autowired
	private Environment environment;

	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(environment.getProperty("mail.smtp.host"));
		mailSender.setPort(environment.getProperty("mail.smtp.port", Integer.class));
		mailSender.setUsername(environment.getProperty("mail.smtp.username"));
		mailSender.setPassword(environment.getProperty("mail.smtp.password"));

		Properties props = new Properties();

		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.connectiontimeout", 10000);

		mailSender.setJavaMailProperties(props);

		return mailSender;

	}

}
