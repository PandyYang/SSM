/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.91
 * Generated at: 2018-12-01 02:03:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tag2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005fnamespace_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005ftextfield_0026_005fname_005flabel_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fpassword_0026_005fname_005flabel_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fradio_0026_005fname_005flist_005flabel_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fcheckboxlist_0026_005fname_005flist_005flabel_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fselect_0026_005fname_005flist_005flabel_005fheaderValue_005fheaderKey;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005ffile_0026_005fname_005flabel_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005ftextarea_0026_005fname_005flabel_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005factionerror_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005fnamespace_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005ftextfield_0026_005fname_005flabel_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fpassword_0026_005fname_005flabel_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fradio_0026_005fname_005flist_005flabel_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fcheckboxlist_0026_005fname_005flist_005flabel_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fselect_0026_005fname_005flist_005flabel_005fheaderValue_005fheaderKey = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005ffile_0026_005fname_005flabel_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005ftextarea_0026_005fname_005flabel_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005factionerror_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005fnamespace_005faction.release();
    _005fjspx_005ftagPool_005fs_005ftextfield_0026_005fname_005flabel_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005fpassword_0026_005fname_005flabel_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005fradio_0026_005fname_005flist_005flabel_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005fcheckboxlist_0026_005fname_005flist_005flabel_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005fselect_0026_005fname_005flist_005flabel_005fheaderValue_005fheaderKey.release();
    _005fjspx_005ftagPool_005fs_005ffile_0026_005fname_005flabel_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005ftextarea_0026_005fname_005flabel_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005factionerror_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("   \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- struts2表单标签 -->\r\n");
      out.write("\t<!-- 好处1: 内置了一套样式.  -->\r\n");
      out.write("\t<!-- 好处2: 自动回显,根据栈中的属性  -->\r\n");
      out.write("\t<!-- theme:指定表单的主题\r\n");
      out.write("\t\t\txhtml:默认\r\n");
      out.write("\t\t\tsimple:没有主题\r\n");
      out.write("\t -->\r\n");
      out.write("\t");
      if (_jspx_meth_s_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
      if (_jspx_meth_s_005factionerror_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_005fform_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:form
    org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_005fform_005f0 = (org.apache.struts2.views.jsp.ui.FormTag) _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005fnamespace_005faction.get(org.apache.struts2.views.jsp.ui.FormTag.class);
    boolean _jspx_th_s_005fform_005f0_reused = false;
    try {
      _jspx_th_s_005fform_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005fform_005f0.setParent(null);
      // /tag2.jsp(18,1) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fform_005f0.setAction("Demo3Action");
      // /tag2.jsp(18,1) name = namespace type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fform_005f0.setNamespace("/");
      // /tag2.jsp(18,1) name = theme type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fform_005f0.setTheme("xhtml");
      int _jspx_eval_s_005fform_005f0 = _jspx_th_s_005fform_005f0.doStartTag();
      if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = org.apache.jasper.runtime.JspRuntimeLibrary.startBufferedBody(_jspx_page_context, _jspx_th_s_005fform_005f0);
        }
        do {
          out.write("\r\n");
          out.write("\t\t");
          if (_jspx_meth_s_005ftextfield_005f0(_jspx_th_s_005fform_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t");
          if (_jspx_meth_s_005fpassword_005f0(_jspx_th_s_005fform_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t");
          if (_jspx_meth_s_005fradio_005f0(_jspx_th_s_005fform_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t");
          if (_jspx_meth_s_005fradio_005f1(_jspx_th_s_005fform_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t");
          if (_jspx_meth_s_005fcheckboxlist_005f0(_jspx_th_s_005fform_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t");
          if (_jspx_meth_s_005fselect_005f0(_jspx_th_s_005fform_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t");
          if (_jspx_meth_s_005ffile_005f0(_jspx_th_s_005fform_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t");
          if (_jspx_meth_s_005ftextarea_005f0(_jspx_th_s_005fform_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t");
          if (_jspx_meth_s_005fsubmit_005f0(_jspx_th_s_005fform_005f0, _jspx_page_context))
            return true;
          out.write('\r');
          out.write('\n');
          out.write('	');
          int evalDoAfterBody = _jspx_th_s_005fform_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_s_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005fform_0026_005ftheme_005fnamespace_005faction.reuse(_jspx_th_s_005fform_005f0);
      _jspx_th_s_005fform_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005fform_005f0, _jsp_getInstanceManager(), _jspx_th_s_005fform_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_s_005ftextfield_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:textfield
    org.apache.struts2.views.jsp.ui.TextFieldTag _jspx_th_s_005ftextfield_005f0 = (org.apache.struts2.views.jsp.ui.TextFieldTag) _005fjspx_005ftagPool_005fs_005ftextfield_0026_005fname_005flabel_005fnobody.get(org.apache.struts2.views.jsp.ui.TextFieldTag.class);
    boolean _jspx_th_s_005ftextfield_005f0_reused = false;
    try {
      _jspx_th_s_005ftextfield_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005ftextfield_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
      // /tag2.jsp(19,2) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005ftextfield_005f0.setName("name");
      // /tag2.jsp(19,2) name = label type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005ftextfield_005f0.setLabel("用户名");
      int _jspx_eval_s_005ftextfield_005f0 = _jspx_th_s_005ftextfield_005f0.doStartTag();
      if (_jspx_th_s_005ftextfield_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005ftextfield_0026_005fname_005flabel_005fnobody.reuse(_jspx_th_s_005ftextfield_005f0);
      _jspx_th_s_005ftextfield_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005ftextfield_005f0, _jsp_getInstanceManager(), _jspx_th_s_005ftextfield_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fpassword_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:password
    org.apache.struts2.views.jsp.ui.PasswordTag _jspx_th_s_005fpassword_005f0 = (org.apache.struts2.views.jsp.ui.PasswordTag) _005fjspx_005ftagPool_005fs_005fpassword_0026_005fname_005flabel_005fnobody.get(org.apache.struts2.views.jsp.ui.PasswordTag.class);
    boolean _jspx_th_s_005fpassword_005f0_reused = false;
    try {
      _jspx_th_s_005fpassword_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005fpassword_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
      // /tag2.jsp(20,2) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fpassword_005f0.setName("password");
      // /tag2.jsp(20,2) name = label type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fpassword_005f0.setLabel("密码");
      int _jspx_eval_s_005fpassword_005f0 = _jspx_th_s_005fpassword_005f0.doStartTag();
      if (_jspx_th_s_005fpassword_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005fpassword_0026_005fname_005flabel_005fnobody.reuse(_jspx_th_s_005fpassword_005f0);
      _jspx_th_s_005fpassword_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005fpassword_005f0, _jsp_getInstanceManager(), _jspx_th_s_005fpassword_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fradio_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:radio
    org.apache.struts2.views.jsp.ui.RadioTag _jspx_th_s_005fradio_005f0 = (org.apache.struts2.views.jsp.ui.RadioTag) _005fjspx_005ftagPool_005fs_005fradio_0026_005fname_005flist_005flabel_005fnobody.get(org.apache.struts2.views.jsp.ui.RadioTag.class);
    boolean _jspx_th_s_005fradio_005f0_reused = false;
    try {
      _jspx_th_s_005fradio_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005fradio_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
      // /tag2.jsp(21,2) name = list type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fradio_005f0.setList("{'男','女'}");
      // /tag2.jsp(21,2) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fradio_005f0.setName("gender");
      // /tag2.jsp(21,2) name = label type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fradio_005f0.setLabel("性别");
      int _jspx_eval_s_005fradio_005f0 = _jspx_th_s_005fradio_005f0.doStartTag();
      if (_jspx_th_s_005fradio_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005fradio_0026_005fname_005flist_005flabel_005fnobody.reuse(_jspx_th_s_005fradio_005f0);
      _jspx_th_s_005fradio_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005fradio_005f0, _jsp_getInstanceManager(), _jspx_th_s_005fradio_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fradio_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:radio
    org.apache.struts2.views.jsp.ui.RadioTag _jspx_th_s_005fradio_005f1 = (org.apache.struts2.views.jsp.ui.RadioTag) _005fjspx_005ftagPool_005fs_005fradio_0026_005fname_005flist_005flabel_005fnobody.get(org.apache.struts2.views.jsp.ui.RadioTag.class);
    boolean _jspx_th_s_005fradio_005f1_reused = false;
    try {
      _jspx_th_s_005fradio_005f1.setPageContext(_jspx_page_context);
      _jspx_th_s_005fradio_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
      // /tag2.jsp(22,2) name = list type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fradio_005f1.setList("#{1:'男',0:'女'}");
      // /tag2.jsp(22,2) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fradio_005f1.setName("gender");
      // /tag2.jsp(22,2) name = label type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fradio_005f1.setLabel("性别");
      int _jspx_eval_s_005fradio_005f1 = _jspx_th_s_005fradio_005f1.doStartTag();
      if (_jspx_th_s_005fradio_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005fradio_0026_005fname_005flist_005flabel_005fnobody.reuse(_jspx_th_s_005fradio_005f1);
      _jspx_th_s_005fradio_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005fradio_005f1, _jsp_getInstanceManager(), _jspx_th_s_005fradio_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fcheckboxlist_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:checkboxlist
    org.apache.struts2.views.jsp.ui.CheckboxListTag _jspx_th_s_005fcheckboxlist_005f0 = (org.apache.struts2.views.jsp.ui.CheckboxListTag) _005fjspx_005ftagPool_005fs_005fcheckboxlist_0026_005fname_005flist_005flabel_005fnobody.get(org.apache.struts2.views.jsp.ui.CheckboxListTag.class);
    boolean _jspx_th_s_005fcheckboxlist_005f0_reused = false;
    try {
      _jspx_th_s_005fcheckboxlist_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005fcheckboxlist_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
      // /tag2.jsp(23,2) name = list type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fcheckboxlist_005f0.setList("#{2:'抽烟',1:'喝酒',0:'烫头'}");
      // /tag2.jsp(23,2) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fcheckboxlist_005f0.setName("habits");
      // /tag2.jsp(23,2) name = label type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fcheckboxlist_005f0.setLabel("爱好");
      int _jspx_eval_s_005fcheckboxlist_005f0 = _jspx_th_s_005fcheckboxlist_005f0.doStartTag();
      if (_jspx_th_s_005fcheckboxlist_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005fcheckboxlist_0026_005fname_005flist_005flabel_005fnobody.reuse(_jspx_th_s_005fcheckboxlist_005f0);
      _jspx_th_s_005fcheckboxlist_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005fcheckboxlist_005f0, _jsp_getInstanceManager(), _jspx_th_s_005fcheckboxlist_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fselect_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:select
    org.apache.struts2.views.jsp.ui.SelectTag _jspx_th_s_005fselect_005f0 = (org.apache.struts2.views.jsp.ui.SelectTag) _005fjspx_005ftagPool_005fs_005fselect_0026_005fname_005flist_005flabel_005fheaderValue_005fheaderKey.get(org.apache.struts2.views.jsp.ui.SelectTag.class);
    boolean _jspx_th_s_005fselect_005f0_reused = false;
    try {
      _jspx_th_s_005fselect_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005fselect_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
      // /tag2.jsp(24,2) name = list type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fselect_005f0.setList("#{2:'大专',1:'本科',0:'硕士'}");
      // /tag2.jsp(24,2) name = headerKey type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fselect_005f0.setHeaderKey("");
      // /tag2.jsp(24,2) name = headerValue type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fselect_005f0.setHeaderValue("---请选择---");
      // /tag2.jsp(24,2) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fselect_005f0.setName("edu");
      // /tag2.jsp(24,2) name = label type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fselect_005f0.setLabel("学历");
      int _jspx_eval_s_005fselect_005f0 = _jspx_th_s_005fselect_005f0.doStartTag();
      if (_jspx_eval_s_005fselect_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_s_005fselect_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = org.apache.jasper.runtime.JspRuntimeLibrary.startBufferedBody(_jspx_page_context, _jspx_th_s_005fselect_005f0);
        }
        do {
          out.write("\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_s_005fselect_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_s_005fselect_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_s_005fselect_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005fselect_0026_005fname_005flist_005flabel_005fheaderValue_005fheaderKey.reuse(_jspx_th_s_005fselect_005f0);
      _jspx_th_s_005fselect_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005fselect_005f0, _jsp_getInstanceManager(), _jspx_th_s_005fselect_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_s_005ffile_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:file
    org.apache.struts2.views.jsp.ui.FileTag _jspx_th_s_005ffile_005f0 = (org.apache.struts2.views.jsp.ui.FileTag) _005fjspx_005ftagPool_005fs_005ffile_0026_005fname_005flabel_005fnobody.get(org.apache.struts2.views.jsp.ui.FileTag.class);
    boolean _jspx_th_s_005ffile_005f0_reused = false;
    try {
      _jspx_th_s_005ffile_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005ffile_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
      // /tag2.jsp(26,2) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005ffile_005f0.setName("photo");
      // /tag2.jsp(26,2) name = label type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005ffile_005f0.setLabel("近照");
      int _jspx_eval_s_005ffile_005f0 = _jspx_th_s_005ffile_005f0.doStartTag();
      if (_jspx_th_s_005ffile_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005ffile_0026_005fname_005flabel_005fnobody.reuse(_jspx_th_s_005ffile_005f0);
      _jspx_th_s_005ffile_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005ffile_005f0, _jsp_getInstanceManager(), _jspx_th_s_005ffile_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_s_005ftextarea_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:textarea
    org.apache.struts2.views.jsp.ui.TextareaTag _jspx_th_s_005ftextarea_005f0 = (org.apache.struts2.views.jsp.ui.TextareaTag) _005fjspx_005ftagPool_005fs_005ftextarea_0026_005fname_005flabel_005fnobody.get(org.apache.struts2.views.jsp.ui.TextareaTag.class);
    boolean _jspx_th_s_005ftextarea_005f0_reused = false;
    try {
      _jspx_th_s_005ftextarea_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005ftextarea_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
      // /tag2.jsp(27,2) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005ftextarea_005f0.setName("desc");
      // /tag2.jsp(27,2) name = label type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005ftextarea_005f0.setLabel("个人简介");
      int _jspx_eval_s_005ftextarea_005f0 = _jspx_th_s_005ftextarea_005f0.doStartTag();
      if (_jspx_th_s_005ftextarea_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005ftextarea_0026_005fname_005flabel_005fnobody.reuse(_jspx_th_s_005ftextarea_005f0);
      _jspx_th_s_005ftextarea_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005ftextarea_005f0, _jsp_getInstanceManager(), _jspx_th_s_005ftextarea_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fsubmit_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fform_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:submit
    org.apache.struts2.views.jsp.ui.SubmitTag _jspx_th_s_005fsubmit_005f0 = (org.apache.struts2.views.jsp.ui.SubmitTag) _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.ui.SubmitTag.class);
    boolean _jspx_th_s_005fsubmit_005f0_reused = false;
    try {
      _jspx_th_s_005fsubmit_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005fsubmit_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fform_005f0);
      // /tag2.jsp(28,2) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fsubmit_005f0.setValue("提交");
      int _jspx_eval_s_005fsubmit_005f0 = _jspx_th_s_005fsubmit_005f0.doStartTag();
      if (_jspx_th_s_005fsubmit_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005fsubmit_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fsubmit_005f0);
      _jspx_th_s_005fsubmit_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005fsubmit_005f0, _jsp_getInstanceManager(), _jspx_th_s_005fsubmit_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_s_005factionerror_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:actionerror
    org.apache.struts2.views.jsp.ui.ActionErrorTag _jspx_th_s_005factionerror_005f0 = (org.apache.struts2.views.jsp.ui.ActionErrorTag) _005fjspx_005ftagPool_005fs_005factionerror_005fnobody.get(org.apache.struts2.views.jsp.ui.ActionErrorTag.class);
    boolean _jspx_th_s_005factionerror_005f0_reused = false;
    try {
      _jspx_th_s_005factionerror_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005factionerror_005f0.setParent(null);
      int _jspx_eval_s_005factionerror_005f0 = _jspx_th_s_005factionerror_005f0.doStartTag();
      if (_jspx_th_s_005factionerror_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fs_005factionerror_005fnobody.reuse(_jspx_th_s_005factionerror_005f0);
      _jspx_th_s_005factionerror_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_s_005factionerror_005f0, _jsp_getInstanceManager(), _jspx_th_s_005factionerror_005f0_reused);
    }
    return false;
  }
}
