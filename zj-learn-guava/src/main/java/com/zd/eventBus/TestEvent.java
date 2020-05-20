package com.zd.eventBus;

public class TestEvent {
    public void setMessage(int message) {
        this.message = message;
    }

    private  int message;
    public TestEvent(int message) {
        this.message = message;
        System.out.println("event message:"+message);
    }
    public int getMessage() {
        return message;
    }
}