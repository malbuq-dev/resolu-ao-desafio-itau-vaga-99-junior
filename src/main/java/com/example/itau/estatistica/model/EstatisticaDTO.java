package com.example.itau.estatistica.model;

import java.util.DoubleSummaryStatistics;

import lombok.Data;

@Data
public class EstatisticaDTO {
    private final long count;
    private final double sum;
    private final double avg;
    private final double min;
    private final double max;

    public EstatisticaDTO(DoubleSummaryStatistics estatisticas) {
        this.count = estatisticas.getCount();
        this.sum = estatisticas.getSum();
        this.avg = estatisticas.getAverage();
        this.min = estatisticas.getMin();
        this.max = estatisticas.getMax();
    }
    public EstatisticaDTO() {
        this.count = 0;
        this.sum = 0;
        this.avg = 0;
        this.min = 0;
        this.max = 0;
    }
    
}
