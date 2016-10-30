package com.bmeit;

import com.bmeit.Controller.ApiProjectController;
import com.bmeit.Manager.*;
import com.bmeit.Model.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.tags.form.FormTag;

/**
 * Created by sunqiang on 2016/9/28.
 */
@Configuration
public class MHdemoConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:img/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public ImgManager getImgManager(){
        return ImgManager.getInstance();
    }

    @Bean
    public ProjectManager getProjectManager(){
        return ProjectManager.getInstance();
    }

    @Bean
    public MemberManager getMemberManager(){
        return MemberManager.getInstance();
    }

    @Bean
    public ProjectMemberManager getProjectMemberManager(){
        return ProjectMemberManager.getInstance();
    }

    @Bean
    public MemberTagManager getMemberTagManager(){
        return MemberTagManager.getInstance();
    }
}
