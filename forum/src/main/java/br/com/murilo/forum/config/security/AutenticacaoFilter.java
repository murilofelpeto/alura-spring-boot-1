package br.com.murilo.forum.config.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.murilo.forum.config.validacao.model.ErroDeAutenticacaoException;
import br.com.murilo.forum.config.validacao.model.ResourceNotFoundException;
import br.com.murilo.forum.entity.Usuario;
import br.com.murilo.forum.repository.UsuarioRepository;

public class AutenticacaoFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UsuarioRepository repository;
	
	public AutenticacaoFilter(TokenService tokenService, UsuarioRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = getToken(request);
		
		if(tokenService.isTokenValid(token)) {
			autenticarUsuario(token);
		}
		
		filterChain.doFilter(request, response);		
	}
	
	private void autenticarUsuario(String token) {
		Usuario usuario = repository.findById(tokenService.getIdUsuario(token)).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);		
	}

	private String getToken(HttpServletRequest request) {
		String token = Optional.ofNullable(request.getHeader("Authorization")).orElseThrow(() -> new ErroDeAutenticacaoException("Token nulo"));
		
		if(token.isEmpty() || !token.startsWith("Bearer ")) {
			throw new ErroDeAutenticacaoException("Token vazio ou não começa com Bearer");
		}
		
		return token.substring(7);
	}

}
