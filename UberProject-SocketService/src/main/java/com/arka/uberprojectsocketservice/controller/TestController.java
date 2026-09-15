package com.arka.uberprojectsocketservice.controller;

import com.arka.uberprojectsocketservice.Dto.ChatRequest;
import com.arka.uberprojectsocketservice.Dto.ChatResponce;
import com.arka.uberprojectsocketservice.Dto.TestRequest;
import com.arka.uberprojectsocketservice.Dto.TestResponce;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    public TestController(SimpMessagingTemplate simpMessagingTemplate) {

        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    @MessageMapping("ping")
    @SendTo("/topic/ping")
    public TestResponce pingCheck(TestRequest message){
        System.out.println("Received Message from client"+message);
      return  TestResponce.builder().data("Received").build();


    }

//    @Scheduled(fixedDelay = 2000)
//    public void sendPeriodicMessage(){
//       simpMessagingTemplate
//               .convertAndSend("/topic/schedule","Periodic message send"+System.currentTimeMillis());
//    }


    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public ChatResponce chatMessages(ChatRequest request){

        ChatResponce responce=ChatResponce.builder().name(request.getUsername()).message(request.getMessage()).timestamp(""+System.currentTimeMillis()).build();
        return responce;
    }
}
