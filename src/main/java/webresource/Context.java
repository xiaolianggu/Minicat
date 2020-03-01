package webresource;

import java.util.List;

import server.HttpServlet;

public class Context
{
  private String appName;
  private List<Wrapper> wrapperList;

  public HttpServlet getByUrlPattern(String urlPattern)
  {
    for (Wrapper wrapper : this.wrapperList) {
      if (urlPattern.equals(wrapper.getUrlPattern())) {
        return wrapper.getServlet();
      }
    }
    return null;
  }
  public String getAppName() {
    return this.appName;
  }
  public void setAppName(String appName) {
    this.appName = appName;
  }
  public List<Wrapper> getWrapperList() {
    return this.wrapperList;
  }
  public void setWrapperList(List<Wrapper> wrapperList) {
    this.wrapperList = wrapperList;
  }
}