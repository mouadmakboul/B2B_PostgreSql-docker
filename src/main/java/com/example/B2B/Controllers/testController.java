package com.example.B2B.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class testController {
    @GetMapping("/")
    public String returnHtml() {
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Page HTML</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>MOUAD MAKBOUL</h1>\n" +
                "    <h1>PR MERIEM CHERGUI</h1>\n" +
                "    <h1>PR SAYOUTI</h1>\n" +
                "    <h1>PR DAOUIDI</h1>\n" +
                "    <p>Merci pour votre attention.</p>\n" +
                "</body>\n" +
                "</html>";
        return htmlContent;
}}
