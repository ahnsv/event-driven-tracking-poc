package net.class101.eventdrivenpoc.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Slf4j
@NoArgsConstructor
public class Usage {
    private int cpuUsage;
    private int memoryUsage;
    private Date date;

    @Builder
    public Usage(int cpuUsage, int memoryUsage, Date date) {
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
        this.date = date;
    }
}
