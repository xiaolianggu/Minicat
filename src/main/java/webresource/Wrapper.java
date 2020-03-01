package webresource;

import server.HttpServlet;

public class Wrapper
{
  private String servletName;
  private String urlPattern;
  private HttpServlet servlet;

  public String getServletName()
  {
    return this.servletName;
  }
  public void setServletName(String servletName) {
    this.servletName = servletName;
  }
  public String getUrlPattern() {
    return this.urlPattern;
  }
  public void setUrlPattern(String urlPattern) {
    this.urlPattern = urlPattern;
  }
  public HttpServlet getServlet() {
    return this.servlet;
  }
  public void setServlet(HttpServlet servlet) {
    this.servlet = servlet;
  }
}