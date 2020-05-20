package com.zd.eventBus;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

public class TestEventBus {
    @Test
    public void testReceiveEvent() throws Exception {

        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        eventBus.register(listener);


         eventBus.post(new TestEvent(300));


        System.out.println("LastMessage:"+listener.getLastMessage());
    }
}