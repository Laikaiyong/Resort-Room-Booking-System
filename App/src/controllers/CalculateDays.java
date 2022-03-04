package controllers;

import java.time.Duration;
import java.time.LocalDate;

public class CalculateDays {
    
    public int dateDifference(LocalDate startDate, LocalDate endDate)
    {
        Duration diff = Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay());
        int diffDays = (int) diff.toDays();
        return diffDays;
    }
}
