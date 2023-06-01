package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Optional;

import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter out = response.getWriter();
        String searchParameter = Optional.ofNullable(request.getParameter("search")).orElse("");

        List<String> result = getCompanies()
                .stream()
                .filter(company -> company.contains(searchParameter))
                .toList();

        if (result.isEmpty()) {
            out.println("Companies not found");
        } else {
            result.forEach(out::println);
        }
        // END
    }
}
