package com.timur.pet_project.tag;

import com.timur.pet_project.util.ResourceBundleToUTF8;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by timyr on 14.08.18.
 */
public class Localization extends TagSupport {
    private ResourceBundleToUTF8 utf8 = new ResourceBundleToUTF8();
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int doStartTag() {

        HttpSession session = pageContext.getSession();

        if (session.getAttribute("LOCALE") == null) {
            if (pageContext.getRequest().getLocale() == null) {
                session.setAttribute("LOCALE", new Locale("en", "EN"));
            } else {
                session.setAttribute("LOCALE", pageContext.getRequest().getLocale());
            }
        }

        Locale locale = (Locale) session.getAttribute("LOCALE");

        if (message != null && !message.isEmpty()) {
            ResourceBundle messages = null;
            messages = ResourceBundle.getBundle("i18n.messages", locale, utf8);
            String locMessage = messages.getString(message);
            try {
                pageContext.getOut().print(locMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SKIP_BODY;
    }
}
