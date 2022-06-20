package alex;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

/**
 * default description.
 *
 * @author qct
 * @date 2018/2/20
 * @since 1.0
 */
@SpringBootTest
public class MailApplicationTest {

    @Autowired private JavaMailSender mailSender;

    @Autowired private Configuration configuration;

    @Test
    public void testSendSimpleMessage() throws IOException, TemplateException, MessagingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("capital-cron<capital-cron-no-replay@xxx.com>");
        message.setTo("xxx@xxx.net");
        message.setText("test1");
        message.setSubject("主题");
        // mailSender.send(message);

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
        helper.setSubject("报警啦");

        mailSender.send(mimeMessage);
    }
}
