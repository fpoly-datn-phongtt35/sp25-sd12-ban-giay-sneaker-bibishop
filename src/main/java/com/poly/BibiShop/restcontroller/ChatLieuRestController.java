package com.poly.BibiShop.restcontroller;


import com.poly.BibiShop.dto.ChatLieuDTO;
import com.poly.BibiShop.service.ChatLieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/chatlieu")
@RequiredArgsConstructor
public class ChatLieuRestController {
    private final ChatLieuService chatLieuService;

    @GetMapping("/chat-lieu")
    public ModelAndView home() {
        return new ModelAndView("admin/adminWeb/Chatlieu");
    }
    @GetMapping("/getAll")
    public List<ChatLieuDTO> getAllMauSac() {
        return chatLieuService.getAllChatLieu();
    }
    @PostMapping("/add")
    public ChatLieuDTO addChatLieu(@RequestBody ChatLieuDTO dto){
        return chatLieuService.addChatLieu(dto);
    }
    @PutMapping("/update")
    public ChatLieuDTO updateChatLieu(@RequestBody ChatLieuDTO dto){
        return chatLieuService.updateChatLieu(dto);
    }
}
