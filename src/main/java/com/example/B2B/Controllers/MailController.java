package com.example.B2B.Controllers;

import com.example.B2B.Entities.MailStructure;
import com.example.B2B.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/mail")

public class MailController {
    @Autowired
    private MailService ms;
    @PostMapping("/send/{mail}")
    public String sendMail(@PathVariable String mail, @RequestBody MailStructure mailStructure){

        ms.sendMail(mail,mailStructure);
        return "Successfully sent email";
    }
}
