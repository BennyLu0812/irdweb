package com.ird.portal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: <br/>
 * Description: <br/>
 * Date: 2018年09月07日 下午07:14:45<br/>
 *
 * @author David Siu
 * @version 1.0
 * @since JDK1.8
 */
@Configuration
public class CLPWebConfig {

    @Value("${clp-web.version}")
    private String version;
    
    @Value("${clp-web.deployDate}")
    private String deployDate;
    
    @Bean(name = "cosWebVersion")
    public CosWebVersion cosWebVersion() {
		return new CosWebVersion() {
			@Override
			public String getVersion() {
				return version;
			}

			@Override
			public String getDeployDate() {
				return deployDate;
			}
		};
    }

    public interface CosWebVersion {
    	String getVersion();
    	String getDeployDate();
    }
}
