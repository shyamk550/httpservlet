import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

public class HTTPServletRequestSimulator implements HttpServletRequest {

    private final Map<String, String[]> parameters = new HashMap<>();
    private final Map<String, Object> attributes = new HashMap<>();
    private String method = "GET";
    private String requestURI = "/";
    private String contextPath = "";
    private String servletPath = "";
    private String queryString = "";

    public void setParameter(String name, String value) {
        parameters.put(name, new String[]{value});
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setRequestURI(String uri) {
        this.requestURI = uri;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public void setServletPath(String servletPath) {
        this.servletPath = servletPath;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    @Override
    public String getParameter(String name) {
        String[] values = parameters.get(name);
        return (values != null && values.length > 0) ? values[0] : null;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(parameters.keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return parameters.get(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return parameters;
    }

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public void setAttribute(String name, Object o) {
        attributes.put(name, o);
    }

    @Override
    public void removeAttribute(String name) {
        attributes.remove(name);
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getRequestURI() {
        return requestURI;
    }

    @Override
    public String getContextPath() {
        return contextPath;
    }

    @Override
    public String getServletPath() {
        return servletPath;
    }

    @Override
    public String getQueryString() {
        return queryString;
    }

    // --- Unimplemented Methods Throwing Exceptions ---
    @Override public String getAuthType() { throw new UnsupportedOperationException(); }
    @Override public Cookie[] getCookies() { throw new UnsupportedOperationException(); }
    @Override public long getDateHeader(String name) { throw new UnsupportedOperationException(); }
    @Override public String getHeader(String name) { throw new UnsupportedOperationException(); }
    @Override public Enumeration<String> getHeaders(String name) { throw new UnsupportedOperationException(); }
    @Override public Enumeration<String> getHeaderNames() { throw new UnsupportedOperationException(); }
    @Override public int getIntHeader(String name) { throw new UnsupportedOperationException(); }
    @Override public String getPathInfo() { throw new UnsupportedOperationException(); }
    @Override public String getPathTranslated() { throw new UnsupportedOperationException(); }
    @Override public String getRemoteUser() { throw new UnsupportedOperationException(); }
    @Override public boolean isUserInRole(String role) { throw new UnsupportedOperationException(); }
    @Override public Principal getUserPrincipal() { throw new UnsupportedOperationException(); }
    @Override public String getRequestedSessionId() { throw new UnsupportedOperationException(); }
    @Override public String getRequestURL() { throw new UnsupportedOperationException(); }
    @Override public HttpSession getSession(boolean create) { throw new UnsupportedOperationException(); }
    @Override public HttpSession getSession() { throw new UnsupportedOperationException(); }
    @Override public String changeSessionId() { throw new UnsupportedOperationException(); }
    @Override public boolean isRequestedSessionIdValid() { throw new UnsupportedOperationException(); }
    @Override public boolean isRequestedSessionIdFromCookie() { throw new UnsupportedOperationException(); }
    @Override public boolean isRequestedSessionIdFromURL() { throw new UnsupportedOperationException(); }
    @Override public boolean isRequestedSessionIdFromUrl() { throw new UnsupportedOperationException(); }
    @Override public boolean authenticate(HttpServletResponse response) throws IOException, ServletException { throw new UnsupportedOperationException(); }
    @Override public void login(String username, String password) throws ServletException { throw new UnsupportedOperationException(); }
    @Override public void logout() throws ServletException { throw new UnsupportedOperationException(); }
    @Override public Collection<Part> getParts() throws IOException, ServletException { throw new UnsupportedOperationException(); }
    @Override public Part getPart(String name) throws IOException, ServletException { throw new UnsupportedOperationException(); }
    @Override public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException { throw new UnsupportedOperationException(); }

    // Others
    @Override public String getProtocol() { return "HTTP/1.1"; }
    @Override public String getScheme() { return "http"; }
    @Override public String getServerName() { return "localhost"; }
    @Override public int getServerPort() { return 8080; }
    @Override public BufferedReader getReader() throws IOException { throw new UnsupportedOperationException(); }
    @Override public String getRemoteAddr() { return "127.0.0.1"; }
    @Override public String getRemoteHost() { return "localhost"; }
    @Override public Locale getLocale() { return Locale.getDefault(); }
    @Override public Enumeration<Locale> getLocales() { return Collections.enumeration(List.of(Locale.getDefault())); }
    @Override public boolean isSecure() { return false; }
    @Override public RequestDispatcher getRequestDispatcher(String path) { throw new UnsupportedOperationException(); }
    @Override public String getRealPath(String path) { throw new UnsupportedOperationException(); }
    @Override public int getRemotePort() { return 0; }
    @Override public String getLocalName() { return "localhost"; }
    @Override public String getLocalAddr() { return "127.0.0.1"; }
    @Override public int getLocalPort() { return 8080; }
    @Override public ServletContext getServletContext() { throw new UnsupportedOperationException(); }
    @Override public AsyncContext startAsync() throws IllegalStateException { throw new UnsupportedOperationException(); }
    @Override public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException { throw new UnsupportedOperationException(); }
    @Override public boolean isAsyncStarted() { return false; }
    @Override public boolean isAsyncSupported() { return false; }
    @Override public AsyncContext getAsyncContext() { throw new UnsupportedOperationException(); }
    @Override public DispatcherType getDispatcherType() { throw new UnsupportedOperationException(); }
    @Override public String getCharacterEncoding() { return "UTF-8"; }
    @Override public void setCharacterEncoding(String env) throws UnsupportedEncodingException { }
    @Override public int getContentLength() { return -1; }
    @Override public long getContentLengthLong() { return -1; }
    @Override public String getContentType() { return null; }
    @Override public ServletInputStream getInputStream() throws IOException { throw new UnsupportedOperationException(); }
}
