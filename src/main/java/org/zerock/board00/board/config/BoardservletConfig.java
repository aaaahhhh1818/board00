package org.zerock.board00.board.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan(basePackages = "org.zerock.board00.board.controller")
public class BoardservletConfig implements WebMvcConfigurer {
}
