package pro.sky.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import pro.sky.telegrambot.listener.TelegramBotUpdatesListener;


@SpringBootApplication
@EnableScheduling
public class TelegramBotApplication {
	private TelegramBotUpdatesListener telegramBotUpdatesListener;



	public static void main(String[] args) {
		SpringApplication.run(TelegramBotApplication.class, args);

	}

}
