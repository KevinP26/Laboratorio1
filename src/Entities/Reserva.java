package Entities;

import java.time.LocalDateTime;

public class Reserva {
    private String reserveNumber;
    private LocalDateTime reserveDate;
    private String reserveStatus;

    public Reserva(String reserveNumber, LocalDateTime reserveDate, String reserveStatus) {
        this.reserveNumber = reserveNumber;
        this.reserveDate = reserveDate;
        this.reserveStatus = reserveStatus;
    }

    public String getReserveNumber() {
        return reserveNumber;
    }

    public void setReserveNumber(String reserveNumber) {
        this.reserveNumber = reserveNumber;
    }

    public LocalDateTime getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDateTime reserveDate) {
        this.reserveDate = reserveDate;
    }

    public String getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(String reserveStatus) {
        this.reserveStatus = reserveStatus;
    }
    

}
