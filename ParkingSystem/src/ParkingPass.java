import java.time.LocalDate;

public class ParkingPass {
    private String duration;
    private double fee;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    public ParkingPass(String duration, double fee) {
        this.duration = duration;
        this.fee = fee;
        this.issueDate = LocalDate.now();
        this.expiryDate = calculateExpiryDate(duration);
    }

    public LocalDate calculateExpiryDate(String duration) {
        return switch (duration) {
            case "1 Day" -> issueDate.plusDays(1);
            case "1 Week" -> issueDate.plusDays(7);
            case "1 Month" -> issueDate.plusMonths(1);
            default -> issueDate;
        };
    }

    public String getDuration() {
        return duration;
    }

    public String getFee() {
        return String.valueOf(fee);
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
