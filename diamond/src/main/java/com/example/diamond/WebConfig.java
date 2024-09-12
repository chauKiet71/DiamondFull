package com.example.diamond;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Cấu hình để phục vụ tệp từ thư mục tĩnh trong dự án
        registry.addResourceHandler("/diamond/images/**")
                .addResourceLocations("file:D:/duanCaNhan/diamond/backend/diamond/images/");
    }
}
