package config;

import controller.NoteController;
import dao.NoteDAO;
import impl.NoteDAOImpl;
import impl.NoteServiceImpl;
import service.NoteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "config")
public class WebConfig {

    @Bean
    public NoteDAO noteDAO(){
        return new NoteDAOImpl();
    }

    @Bean
    public NoteService noteService(){
        return new NoteServiceImpl(noteDAO());
    }

    @Bean
    public NoteController noteManagerController(){
        return  new NoteController(noteService());
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
