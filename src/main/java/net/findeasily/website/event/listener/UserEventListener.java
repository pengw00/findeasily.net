package net.findeasily.website.event.listener;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import net.findeasily.website.entity.Token;
import net.findeasily.website.entity.User;
import net.findeasily.website.event.EmailEvent;
import net.findeasily.website.service.EmailService;
import net.findeasily.website.service.TokenService;

@Component
@Slf4j
public class UserEventListener {
    private final TokenService tokenService;
    private final EmailService emailService;
    private final Configuration freemarkerConfig;

    @Value("${current.web.server}")
    private String webServer;

    @Autowired
    public UserEventListener(EmailService emailService, TokenService tokenService, Configuration freemarkerConfig) {
        this.emailService = emailService;
        this.tokenService = tokenService;
        this.freemarkerConfig = freemarkerConfig;
    }

    @EventListener
    public void handleEvent(EmailEvent event) throws MessagingException, IOException, TemplateException {
        log.info(event.getType() + " - " + event.getUser());
        emailService.sendHtmlMail(event.getUser().getEmail(), event.getType().getSubject(), buildEmailContent(event));


    }

    private String buildEmailContent(EmailEvent event) throws IOException, TemplateException {
        EmailEvent.Type type = event.getType();
        User user = event.getUser();
        Template t = freemarkerConfig.getTemplate("email/" + type.getTemplateFile());
        return FreeMarkerTemplateUtils.processTemplateIntoString(t, buildModel(type, user));
    }

    private Map<String, Object> buildModel(EmailEvent.Type type, User user) {
        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        model.put("webServer", webServer);

        switch (type) {
            case ACCOUNT_CONFIRMATION:
            case PASSWORD_RESET_REQUEST:
                Token token = tokenService.generate(user.getId());
                model.put("token", Base64.getEncoder().encodeToString((token.getId() + ":" + tokenService.getTokenStr(token)).getBytes()));
                break;
            default:
        }

        return model;
    }
}
