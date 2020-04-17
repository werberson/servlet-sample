package dev.werberson.sample.servlet;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SampleServletTest {

    @Test
    public void doGet() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(resp.getWriter()).thenReturn(writer);

        new SampleServlet().doGet(req, resp);

        verify(writer).close();
        //TODO test status code when success
//        assertEquals(resp.getStatus(), HttpServletResponse.SC_OK);

    }

    @Test
    public void testWriterIsClosedOnException() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);
        when(resp.getWriter()).thenReturn(writer);
        doThrow(new RuntimeException()).when(writer).write(anyString());

        try {
            new SampleServlet().doGet(req, resp);
            fail("Exception expected");
        } catch (Exception ignored) {}
        verify(writer).close();
        //TODO test status code when error
    }
}