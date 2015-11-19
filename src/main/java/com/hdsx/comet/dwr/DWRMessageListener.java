package com.hdsx.comet.dwr;

import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.ServerContextFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.context.ServletContextAware;

import com.hdsx.comet.event.JMSApplicationEvent;
import com.hdsx.comet.vo.Message;

public class DWRMessageListener implements ApplicationListener, ServletContextAware {

	private ServletContext ctx;
	
	@Override
	public void setServletContext(ServletContext ctx) {
		// TODO Auto-generated method stub
		this.ctx = ctx;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		 if (event instanceof JMSApplicationEvent) {
	           String msg = (String) event.getSource();
	            ServerContext context = ServerContextFactory.get();
	            //获得客户端所有chat页面script session连接数
	            Collection<ScriptSession> sessions = context.getScriptSessionsByPage(ctx.getContextPath() + "/chat.jsp");
	            Collection<ScriptSession> sessions1 = context.getScriptSessionsByPage(ctx.getContextPath() + "/chat2.jsp");
	            sessions.addAll(sessions1);
	            for (ScriptSession session : sessions) {
	                ScriptBuffer sb = new ScriptBuffer();
	                sb.appendScript("showMessage('")
	                .appendScript(msg)
	                .appendScript("')");
	                System.out.println(sb.toString());
	                //执行客户端script session方法，相当于浏览器执行JavaScript代码
	                  //上面就会执行客户端浏览器中的showMessage方法，并且传递一个对象过去
	                session.addScript(sb);
	            }
	        }
	}

}
