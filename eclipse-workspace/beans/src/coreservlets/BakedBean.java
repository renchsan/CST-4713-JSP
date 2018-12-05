package coreservlets;
import java.io.*;

/** Small bean to illustrate various bean-sharing mechanisms. It implements
 *  Serializable because one of the sharing examples uses session scope.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate/JPA, and Java programming</a>.
 */

public class BakedBean implements Serializable {
  private String level = "half-baked";
  private String goesWith = "hot dogs";

  public String getLevel() {
    return(level);
  }
  
  public void setLevel(String newLevel) {
    level = newLevel;
  }

  public String getGoesWith() {
    return(goesWith);
  }
  
  public void setGoesWith(String dish) {
    goesWith = dish;
  }
}
