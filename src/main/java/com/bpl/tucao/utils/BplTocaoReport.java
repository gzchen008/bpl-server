package com.bpl.tucao.utils;

import com.bpl.tucao.entity.BplHot;
import com.bpl.tucao.service.BplHotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by johnnwang on 2017/8/11.
 */
@Service
@Lazy(false)
public class BplTocaoReport {
    @Autowired
    private BplHotService bplHotService;

    @Scheduled(cron = "0 0 5 * * SUN")
    public void generateReport() {
        List<BplHot> weekly = bplHotService.generateWeekly();
        List<BplHot> history = bplHotService.generateHistory();
        List<BplHot> weeklyDone = bplHotService.generateWeeklyDone();
    }
}
