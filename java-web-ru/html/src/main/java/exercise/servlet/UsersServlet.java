package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<Map<String, String>> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("src/main/resources/users.json");
        var content = Files.readAllBytes(path);
        return objectMapper.readValue(content, List.class);
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        response.setContentType("text/html;charset=UTF-8");

        String head = """
                    <head>
                    <meta charset="UTF-8">
                    <title>Example application</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
        crossorigin="anonymous">
                </head>
                """;
        StringBuilder result = new StringBuilder();
        result.append(head);
        result.append("<table>");

        for (var user : getUsers()) {
            result.append("<tr><td>")
                    .append(user.get("id"))
                    .append("</td><td><a href=\"/users/")
                    .append(user.get("id"))
                    .append("\">")
                    .append(user.get("firstName"))
                    .append(" ")
                    .append(user.get("lastName"))
                    .append("</a></td></tr>");
        }
        result.append("</table>");

        PrintWriter out = response.getWriter();
        out.println(result);
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        response.setContentType("text/html;charset=UTF-8");

        Map<String, String> user = getUsers()
                .stream()
                .filter(u -> u.get("id").equals(id))
                .findAny()
                .orElse(null);

        if (user == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        String head = """
                    <head>
                    <meta charset="UTF-8">
                    <title>Example application</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
        crossorigin="anonymous">
                </head>
                """;
        String result = head
                + "<table>"
                + "<tr><td> Id: " + user.get("id") + "</td></tr>"
                + "<tr><td> First name: " + user.get("firstName") + "</td></tr>"
                + "<tr><td> Last name: " + user.get("lastName") + "</td></tr>"
                + "<tr><td> Email: " + user.get("email") + "</td></tr>"
                + "</table>";

        PrintWriter out = response.getWriter();
        out.println(result);
        // END
    }
}
