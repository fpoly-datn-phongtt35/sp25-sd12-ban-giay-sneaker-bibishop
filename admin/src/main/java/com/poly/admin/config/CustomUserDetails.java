package com.poly.admin.config;

import com.poly.admin.entity.NhanVien;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;



public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private NhanVien user;
		
	public CustomUserDetails(NhanVien user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_ADMIN";
		return List.of(new SimpleGrantedAuthority(role));
		
		
	}

	@Override
	public String getPassword() {
		return user.getMatKhau();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}
	public int getVaiTro(){
		return user.getVaiTro();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
