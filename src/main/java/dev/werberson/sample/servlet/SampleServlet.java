package dev.werberson.sample.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class SampleServlet extends HttpServlet {
    private static final String CONTENT_TYPE_TEXT = "text/plain";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Set success status code 200.
        resp.setStatus(HttpServletResponse.SC_FOUND);
        // Set content type to text/plain.
        resp.setContentType(CONTENT_TYPE_TEXT);

        // Write plaintext "Hello, World!" to the response.
        Writer writer = resp.getWriter();
        try {
            writer.write("Hello, World!");
            writer.flush();
        } finally {
            writer.close();
        }
    }

}
