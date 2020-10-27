import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RedissonTestServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    final HttpSession session = req.getSession();
    if (session.getAttribute("foo") == null) {
      session.setAttribute("foo", new ArrayList());
    } else {
      List list = (List) session.getAttribute("foo");
      list.add("bar");
      //session.setAttribute("foo", list);
    }

    resp.getWriter().println("Session Creation Time: " + session.getCreationTime());
    resp.getWriter().println("Session Last Accessed: " + session.getLastAccessedTime());
    resp.getWriter().println("Session attribute foo: " + session.getAttribute("foo"));
  }
}