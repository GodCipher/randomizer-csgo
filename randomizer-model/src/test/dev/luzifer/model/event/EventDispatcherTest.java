package dev.luzifer.model.event;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.function.Consumer;

public class EventDispatcherTest {

    @Test
    @Ignore(value = "NOT HEADLESS")
    public void testEventDispatched() {

        Event event = Mockito.mock(Event.class);
        EventDispatcher.dispatch(event);

        Mockito.verify(event, Mockito.times(1)).execute();
    }

    @Test
    @Ignore(value = "NOT HEADLESS")
    public void testHandlerCalled() {

        Event event = Mockito.mock(Event.class);
        Consumer<Event> handler = Mockito.mock(Consumer.class);

        EventDispatcher.registerHandler(event.getClass(), handler);
        EventDispatcher.dispatch(event);

        Mockito.verify(handler, Mockito.times(1)).accept(event);
    }

}
