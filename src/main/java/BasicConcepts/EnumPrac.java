package BasicConcepts;

public enum EnumPrac {

    // Set of constants

    SUCCESS(200, "Great"),
    FAILURE(500, "Sorry"),
    BAD_REQ(404, "Try again");

    private int status;
    private String message;

    EnumPrac(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
