package edu.diplom.agronomistadviser.application.port.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

public interface ScheduledCheckLastPredictions {
    @Scheduled(cron = "0 5 * * * *")
    void checkLastPredictionsForCornFHB();

    @Scheduled(cron = "0 10 */6 * * *")
    void checkLastPredictionsForSunflowerGMD();

    @Scheduled(cron = "0 15 */6 * * *")
    void checkLastPredictionsForWheatPMB();

    @Scheduled(cron = "0 20 */6 * * *")
    void checkLastPredictionsForCornLBH();
}
