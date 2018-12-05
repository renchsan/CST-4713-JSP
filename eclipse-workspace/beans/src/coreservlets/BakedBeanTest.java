package coreservlets;

/** A small command-line program to test the BakedBean.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate/JPA, and Java programming</a>.
 */

public class BakedBeanTest {
  public static void main(String[] args) {
    BakedBean bean = new BakedBean();
    System.out.println("Original bean: " +
                       "level=" + bean.getLevel() +
                       ", goesWith=" + bean.getGoesWith());
    if (args.length>1) {
      bean.setLevel(args[0]);
      bean.setGoesWith(args[1]);
      System.out.println("Updated bean: " +
                         "level=" + bean.getLevel() +
                         ", goesWith=" + bean.getGoesWith());
    }
  }
}
      
