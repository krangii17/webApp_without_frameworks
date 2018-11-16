package com.timur.pet_project.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by timyr on 15.08.18.
 */

@WebServlet(
        name = "LocaleChange",
        urlPatterns = "/locale-change"
)
public class LocaleChange extends HttpServlet {

    private final Logger Log = LoggerFactory.getLogger(LocaleChange.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("RU") != null) {
            Log.debug("Set russian language");
            Locale locale = new Locale("ru", "UA");
            req.getSession().setAttribute("LOCALE", locale);
        } else if (req.getParameter("EN") != null) {
            Log.debug("Set english language");
            Locale locale = new Locale("en", "EN");
            req.getSession().setAttribute("LOCALE", locale);
        } else {
            resp.sendError(400);
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

}
