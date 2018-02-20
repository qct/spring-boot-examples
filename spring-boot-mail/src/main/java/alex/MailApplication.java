package alex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * <p>Created by qct on 2018/2/20.
 */
@SpringBootApplication
public class MailApplication implements CommandLineRunner {

    private final JavaMailSender mailSender;

    @Autowired
    public MailApplication(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class);
    }

    @Override
    public void run(String... args) {

    }
}
