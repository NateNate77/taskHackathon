package testHibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


public class ApplicationListenerBean implements ApplicationListener{

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListenerBean.class);

    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        String messsage = applicationEvent.toString();
        LOGGER.info(messsage);


        if (applicationEvent instanceof ContextRefreshedEvent) {
            ApplicationContext applicationContext = ((ContextRefreshedEvent) applicationEvent).getApplicationContext();
//            applicationContext.getBean("nameBean");


        }
    }
}
