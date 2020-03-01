package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils
{
  public static void main(String[] args)
  {
    String path = "E:\\webapp";
    File f = new File(path);
    List appNameList = getDir(path);
    System.out.println(appNameList);
  }

  public static List<String> getDir(String strPath)
  {
    List appNameList = new ArrayList();
    File f = new File(strPath);
    if (f.isDirectory()) {
      File[] fList = f.listFiles();
      for (int j = 0; j < fList.length; j++) {
        if (fList[j].isDirectory())
          appNameList.add(fList[j].getPath());
      }
    }
    return appNameList;
  }
}