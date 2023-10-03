package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.nio.charset.StandardCharsets;

//@WebFilter("/*")
public class CharsetFilter implements Filter{
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		arg0.setCharacterEncoding(StandardCharsets.UTF_8.name());
		arg1.setCharacterEncoding(StandardCharsets.UTF_8.name());
		arg2.doFilter(arg0, arg1);
	}
}
