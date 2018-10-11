package za.co.gabe.model;

public class Response {

    private long code;

    private String message;

    private Error error;

    private boolean failed;

    public Response() {
    }

    public Response(long code, String message, Error error) {
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

}
