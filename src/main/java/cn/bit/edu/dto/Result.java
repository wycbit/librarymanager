package cn.bit.edu.dto;

public class Result<T> {

    private Boolean success;
    private T data;
    private String error;

    public Result() {
    }

    public Result(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(Boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
