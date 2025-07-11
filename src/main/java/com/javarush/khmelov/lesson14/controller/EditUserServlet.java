package com.javarush.khmelov.lesson14.controller;

import com.javarush.khmelov.lesson14.config.Winter;
import com.javarush.khmelov.lesson14.entity.Role;
import com.javarush.khmelov.lesson14.entity.User;
import com.javarush.khmelov.lesson14.service.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/edit-user", loadOnStartup = 1)
public class EditUserServlet extends HttpServlet {

    private final UserService userService = Winter.find(UserService.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute("roles", Role.values());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringId = req.getParameter("id");
        if (stringId != null) {
            long id = Long.parseLong(stringId);
            Optional<User> user = userService.get(id);
            user.ifPresent(value -> req.setAttribute("user", value));
        }
        req.getRequestDispatcher("/WEB-INF/edit-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("id");
        User user = User.builder()
                .id(parameter!=null?Long.parseLong(parameter):null)
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .role(Role.valueOf(req.getParameter("role")))
                .build();
        if (req.getParameter("create") != null) {
            userService.create(user);
        } else if (req.getParameter("update") != null) {
            user.setId(Long.parseLong(req.getParameter("id")));
            userService.update(user);
        }
        resp.sendRedirect(req.getContextPath() + "/edit-user?id=" + user.getId());
    }
}
