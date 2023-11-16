package web.crawler.scheduler.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CrawlerScheduler {
    private final String cron = "1 * * * * *";

    @Scheduled(cron = cron)
    public void executeCrawler() {
        System.out.println("Rodando crawler...");
    }
}
