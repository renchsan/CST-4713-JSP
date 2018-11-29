package coreservlets.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.math.*;

import coreservlets.MyClasses;
import coreservlets.Primes;

public class MyClassesTag extends SimpleTagSupport {
  

  @Override
  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
    String[] classes = MyClasses.getClasses();
    out.print(classes);
    
  }
}
