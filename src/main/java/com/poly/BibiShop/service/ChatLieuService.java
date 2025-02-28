package com.poly.BibiShop.service;



import com.poly.BibiShop.dto.ChatLieuDTO;
import java.util.List;

public interface ChatLieuService {
    List<ChatLieuDTO> getAllChatLieu();
    ChatLieuDTO addChatLieu(ChatLieuDTO chatLieuDTO);
    ChatLieuDTO updateChatLieu(ChatLieuDTO chatLieuDTO);
}
