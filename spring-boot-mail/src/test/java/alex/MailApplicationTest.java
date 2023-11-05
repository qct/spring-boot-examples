package alex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

/**
 * default description.
 *
 * @author qct
 * @date 2018/2/20
 * @since 1.0
 */
@SpringBootTest
@ActiveProfiles("test")
public class MailApplicationTest {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration configuration;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    private GreenMail greenMail;

    @BeforeEach
    void setUp() {
        greenMail = new GreenMail();
        greenMail.setUser(username, password);
        greenMail.start();
    }

    @AfterEach
    void tearDown() {
        greenMail.stop();
    }

    @Test
    public void testSendSimpleMessage() throws MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("capital-cron<capital-cron-no-replay@xxx.com>");
        message.setTo("xxx@xxx.net");
        message.setText("test1");
        message.setSubject("主题");
        mailSender.send(message);

        assertTrue(greenMail.waitForIncomingEmail(5000, 1));
        Message[] messages = greenMail.getReceivedMessages();
        assertEquals(1, messages.length);
        assertEquals("主题", messages[0].getSubject());
        String body = GreenMailUtil.getBody(messages[0]).replaceAll("=\r?\n", "");
        assertEquals("test1", body);
    }

    @Test
    void testTemplateMessage() throws IOException, TemplateException, MessagingException {
        Template template = configuration.getTemplate("alert-email.ftl");
        Map<String, String> model = new HashMap<>();
        model.put("name", "Peter");
        model.put("signature", "Peter one");
        model.put("location", "Tokyo");

        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setTo("xxx@xxx.net");
        helper.setFrom(new InternetAddress("capital-cron-no-replay@xxx.com", "capital-cron"));
        helper.setText(content, true);
        String subject = "报警啦";
        helper.setSubject(subject);

        mailSender.send(mimeMessage);

        assertTrue(greenMail.waitForIncomingEmail(5000, 1));
        Message[] messages = greenMail.getReceivedMessages();
        assertEquals(1, messages.length);
        assertEquals(subject, messages[0].getSubject());
        String body = GreenMailUtil.getBody(messages[0]).replaceAll("=\r?\n", "");
        assertTrue(body.contains("Peter"));
    }
}
