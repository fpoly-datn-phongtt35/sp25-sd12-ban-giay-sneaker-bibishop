package com.poly.admin.service;



import com.poly.admin.dto.ChatLieuDTO;
import java.util.List;

public interface ChatLieuService {
    List<ChatLieuDTO> getAllChatLieu();
    ChatLieuDTO addChatLieu(ChatLieuDTO chatLieuDTO);
    ChatLieuDTO updateChatLieu(ChatLieuDTO chatLieuDTO);
}
