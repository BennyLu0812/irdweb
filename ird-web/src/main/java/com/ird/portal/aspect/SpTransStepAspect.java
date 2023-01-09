//package mo.gov.dsat.vics.aspect;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import mo.gov.dsat.vics.common.sys.data.SysUrlDTO;
//import mo.gov.dsat.vics.sys.service.SysUrlService;
//
//@Aspect
//@Component
//public class SpTransStepAspect {
//
//    private static final Logger logger = LoggerFactory.getLogger(SpTransStepAspect.class);
//
//    @Autowired
//    private SysUrlService sysUrlService;
//
//    @Value("${server.contextPath}")
//    private String contextPath;
//
//    @Around(value = "@annotation(mo.gov.dsat.vics.web.annotion.SpTransactionStep)")
//    public Object aroundProcess(ProceedingJoinPoint pjp)
//        throws Throwable {
//        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
//        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
//        process(request);
//
//        return pjp.proceed();
//    }
//
//    private void process(HttpServletRequest request) {
//        String url = request.getRequestURI();
//
//        String spNo = request.getParameter("spNo");
//        if (StringUtils.isBlank(spNo)) {
//            throw new IllegalArgumentException("The controller method using Annotation @SpTransactionStep must contains request param 'SpNo'");
//        }
//
//        logger.info("Before entering the page[{}] with spNo[{}]", url, spNo);
//        if (StringUtils.isNotBlank(spNo)) {
//            spNo = spNo.replace("$", "");
//        }
//        String urlLink = url.replace(contextPath, "").replaceAll("/+", "/");
//        SysUrlDTO sysUrl = sysUrlService.getSysUrlBySpNoAndUrl(spNo, urlLink);
//
//        if (sysUrl == null) {
//            logger.warn("Could not find the sysUrl by spNo[{}], url[{}]", spNo, urlLink);
//        } else {
//            logger.info("nextUrlLink[{}]", sysUrl.getNextFormattedUrlLink());
//            request.setAttribute("nextUrlLink", sysUrl.getNextFormattedUrlLink());
//
//            //getPreviousSysUrl may return multiple url, temp. use getHeader referer
//            String previousUrl = request.getHeader("referer");
//            logger.info("previousUrlLink[{}]", previousUrl);
//            request.setAttribute("previousUrlLink", previousUrl);
//
//            SysUrlDTO previousSysUrl = sysUrlService.getPreviousSysUrl(sysUrl.getUrlId());
//            if (previousSysUrl != null) {
//                sysUrlService.formatUrlLink(previousSysUrl, spNo);
//
//                logger.info("previousUrlLink[{}]", previousSysUrl.getFormattedUrlLink());
//                request.setAttribute("previousUrlLink", previousSysUrl.getFormattedUrlLink());
//            }
//
//        }
//    }
//
//}