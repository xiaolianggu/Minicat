package webresource;
import java.util.List;

public class Host
{
  private String appBase;
  private String name;
  private List<Context> contextList;

  public String getAppBase()
  {
    return this.appBase;
  }
  public void setAppBase(String appBase) {
    this.appBase = appBase;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public List<Context> getContextList() {
    return this.contextList;
  }
  public void setContextList(List<Context> contextList) {
    this.contextList = contextList;
  }
  public Context getByAppName(String appName) {
    for (Context context : this.contextList) {
      if (appName.equals(context.getAppName())) {
        return context;
      }
    }
    return null;
  }
}