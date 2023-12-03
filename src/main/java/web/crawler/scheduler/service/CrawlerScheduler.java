package web.crawler.scheduler.service;

import org.apache.commons.logging.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
public class CrawlerScheduler {
    private final String cron = "0 */2 * * * *";
    private final String urlCrawler = "http://localhost:8080/catholicLyrics/startCrawlAll";


    @Scheduled(cron = cron)
    public void executeCrawler() {
        System.out.println("Chamando serviço de Crawler: " + LocalDate.now());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(urlCrawler, requestEntity, String.class);

        System.out.println(response.getBody());
    }
}
