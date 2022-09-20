package dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class CustomErrorMessage {
    private int status;
    private LocalDateTime timestamp;
    private String message;
    private String path;

    private String error;

    public CustomErrorMessage(
            int statusCode,
            LocalDateTime timestamp,
            String message,
            String path) {

        this.status = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
    }

    public CustomErrorMessage(int status, LocalDateTime timestamp, String message, String path, String error) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.error = error;
    }

    public CustomErrorMessage() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "CustomErrorMessage{" +
                "status=" + status +
                ", timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", error='" + error + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomErrorMessage that = (CustomErrorMessage) o;
        return status == that.status && Objects.equals(timestamp, that.timestamp) && Objects.equals(message, that.message) && Objects.equals(path, that.path) && Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, timestamp, message, path, error);
    }
}
