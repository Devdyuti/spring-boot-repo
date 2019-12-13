package user;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@EnableAutoConfiguration
public class UserApplicationController { 

	public static void main(String[] args) throws Exception{
		SpringApplication.run(UserResourse.class, args);
	}
	/**Below 2 Methods LocaleResolver and ResourceBundleMessageSource
	 * being used in Internationalization example
	 * {@link /helo-internationalization}
	 * */
	@Bean
	public LocaleResolver localeResolver() {
		//SessionLocaleResolver sessionLocaleResolver=new SessionLocaleResolver();
		AcceptHeaderLocaleResolver sessionLocaleResolver=new AcceptHeaderLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.addBasenames("messages");
		return messageSource;
	}

}
