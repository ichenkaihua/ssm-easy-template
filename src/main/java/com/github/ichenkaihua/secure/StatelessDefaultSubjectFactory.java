package com.github.ichenkaihua.secure;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * 实现不穿件session的factory
* @ClassName  StatelessDefaultSubjectFactory 
* @Description   
* @Author chenkaihua
* @Email admin@chenkaihua.com
* @Date 2015年5月8日 下午9:45:06 
*
 */
public class StatelessDefaultSubjectFactory extends DefaultWebSubjectFactory {

    @Override
    public Subject createSubject(SubjectContext context) {
        //不创建session
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}
