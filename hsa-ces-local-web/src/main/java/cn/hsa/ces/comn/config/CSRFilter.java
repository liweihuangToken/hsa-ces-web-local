package cn.hsa.ces.comn.config;

import cn.hsa.ces.comn.utils.AppInfoConfigPropertiesUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * ①防御 CSRF 的几种策略，验证 HTTP Referer 字段 ②解决HTTP响应头X-Frame-Options缺失
 *
 * @author liweihuang
 */
@Component
@Slf4j
public class CSRFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 解决HTTP响应头X-Frame-Options缺失（点击劫持），导致的浏览器提供的安全特性失效容易遭受Web前端黑客攻击影响。
        ((HttpServletResponse) response).addHeader("X-Frame-Options", "sameorign");

        // 防止CSRF漏洞，添加referer验证组件，捕获请求头部Referer属性并对其进行验证。
        List<String> csrfurlList = AppInfoConfigPropertiesUtils.getInstance().getCsrfurl();
        if (null != csrfurlList && !csrfurlList.isEmpty()) {
            boolean flag = false;
            String referer = ((HttpServletRequest) request).getHeader("Referer");
            for (String vReferer : csrfurlList) {
                if (null == referer || referer.trim().startsWith(vReferer)) {
                    flag = true;
                    chain.doFilter(request, response);
                    break;
                }
            }
            if (!flag) {
                log.info("疑似CSRF攻击，referer:" + referer);
                returnMsg(response, "疑似CSRF攻击，referer:" + referer);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("Filter正在初始化...");
    }

    @Override
    public void destroy() {
        log.info("Filter正在销毁...");
    }

    /**
     * 错误情况下页面信息输出
     *
     * @param response
     * @param msg
     */
    private void returnMsg(ServletResponse response, String msg) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(msg);

        } catch (IOException e) {
            log.error("response error", e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
