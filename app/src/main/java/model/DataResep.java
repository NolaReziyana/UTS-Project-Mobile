package model;

import java.util.List;

public class DataResep {
    private int code;
    private String message;
    List<ModelResep> modelResepList;

    public DataResep(int code, String message, List<ModelResep> modelResepList) {
        this.code = code;
        this.message = message;
        this.modelResepList = modelResepList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ModelResep> getModelResepList() {
        return modelResepList;
    }

    public void setModelResepList(List<ModelResep> modelResepList) {
        this.modelResepList = modelResepList;
    }
}
