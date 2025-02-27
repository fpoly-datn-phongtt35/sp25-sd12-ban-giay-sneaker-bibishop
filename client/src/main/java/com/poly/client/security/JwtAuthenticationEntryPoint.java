package com.poly.client.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//        Cookie jwtCookie = WebUtils.getCookie(httpServletRequest, "JWT_TOKEN");
//
//        if (jwtCookie == null) {
//            // Cookie không tồn tại, yêu cầu API hoặc web chưa xác thực
//            // Kiểm tra xem có phải yêu cầu API hay không (ví dụ: path bắt đầu bằng /api)
////            if (httpServletRequest.getServletPath().startsWith("/api")) {
////                // Yêu cầu API, trả về 401 Unauthorized
////                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
////            } else {
////                // Yêu cầu web, chuyển hướng đến trang đăng nhập
////                httpServletResponse.sendRedirect("/login");
////            }
//            httpServletResponse.sendRedirect("/login");
//        }else {
//            // Cookie tồn tại, nhưng có thể không hợp lệ
//            // Xử lý logic kiểm tra tính hợp lệ của JWT trong filter
//            // Nếu JWT không hợp lệ, filter sẽ ném AuthenticationException
//            // và logic ở đây sẽ được gọi lại
//            if (httpServletRequest.getServletPath().startsWith("/api")) {
//                // Yêu cầu API, trả về 401 Unauthorized
//                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//            } else {
//                // Yêu cầu web, chuyển hướng đến trang đăng nhập
//                httpServletResponse.sendRedirect("/login");
//            }
//        }
    }
}
