package pro.sky.telegrambot.config;



/**
 * Конфигурация бота
 */

@Configuration
@Data
public class BotConfig {
    @Value("${telegram.bot.token}")
    private String token;
    @Value("${telegram.bot.msg.start}")
    private String startMsg;
}
