package com.lin.demoidea.moudles.demo2.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ljq
 * @create 2019/10/28 0028
 * 实现servlet
 */
// servlet 映射,默认不支持异步，要asyncSupported = true
@WebServlet(urlPatterns = "/my/servlet", asyncSupported = true)
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 异步的
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(()->{
            try {
                resp.getWriter().println("hello myservlet");
                // 触发完成，异步方式需要主动告诉完成了
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
