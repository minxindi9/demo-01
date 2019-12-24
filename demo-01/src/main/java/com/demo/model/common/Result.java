package com.demo.model.common;

public class Result {
    private boolean operationResult;  //接口执行结果：成功或失败
    private String operationStatus;       // 返回状态
    private String displayInfo;       // 返回结果
    public Result() {
        
    }
    
    public Result(boolean operationResult, String operationStatus, String displayInfo) {
        super();
        this.operationResult = operationResult;
        this.operationStatus = operationStatus;
        this.displayInfo = displayInfo;
    }

    public boolean isOperationResult() {
        return operationResult;
    }

    public void setOperationResult(boolean operationResult) {
        this.operationResult = operationResult;
    }
    
    public String getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
    }

    public String getDisplayInfo() {
        return displayInfo;
    }

    public void setDisplayInfo(String displayInfo) {
        this.displayInfo = displayInfo;
    }

    
    
    

    
    
    
    
}
