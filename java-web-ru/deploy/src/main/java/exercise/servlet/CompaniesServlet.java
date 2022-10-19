package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter printWriter = response.getWriter();

        String searchString = request.getParameter("search") == null
                ? ""
                : request.getParameter("search");

        if (searchString.equals("")) {
            getCompanies().forEach(printWriter::println);
            return;
        }

        List<String> filteredCompanies = getCompanies()
                    .stream()
                    .filter(x -> x.contains(searchString))
                    .collect(Collectors.toList());
        if (filteredCompanies.isEmpty()) {
            printWriter.println("Companies not found");
            return;
        }
        filteredCompanies.forEach(printWriter::println);
        // END
    }
}
