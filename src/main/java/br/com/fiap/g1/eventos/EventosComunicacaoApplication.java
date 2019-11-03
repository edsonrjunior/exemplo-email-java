package br.com.fiap.g1.eventos;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.fiap.g1.eventos.envio.Mailer;
import br.com.fiap.g1.eventos.envio.Mensagem;

@SpringBootApplication
public class EventosComunicacaoApplication {

	public static void main(String[] args) {

//		SpringApplication.run(EventosComunicacaoApplication.class, args);

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				EventosComunicacaoApplication.class.getPackage().getName());

		Mailer mailer = applicationContext.getBean(Mailer.class);

		mailer.enviar(new Mensagem("Alexandre Teste <alexandre.algaworks@gmail.com>",
				Arrays.asList("Testes AlgaWorks <testes.algaworks@gmail.com>"), "Aula Spring E-mail",
				"Olá! \n\n O envio de e-mail deu certo!"));

		applicationContext.close();

		System.out.println("Fim");

	}

}
