package day11;

public class Path {
  private String root;
  private String currentPath;

  public Path() {
//    this.currentPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
//    this.currentPath = System.getProperty("user.dir") + "/" + this.getClass().getName().replace(".", "/").replace(this.getClass().getSimpleName(), "");
    this.currentPath = this.getClass().getResource(".").getPath();
    String[] path = this.currentPath.split("/");
    this.root = "/" + path[1] + "/" + path[2] + "/";
  }

  public String getRoot() {
    return root;
  }

  public String getCurrentPath() {
    return currentPath;
  }

  public void setCurrentPath(String currentPath) {
    this.currentPath = currentPath;
  }
}
