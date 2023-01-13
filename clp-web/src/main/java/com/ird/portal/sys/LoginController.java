package com.ird.portal.sys;

import com.ird.portal.common.user.data.UserDTO;
import com.ird.portal.sys.service.LoginService;
import com.ird.portal.sys.service.impl.LoginServiceImpl;
import com.ird.portal.user.User;
import com.ird.portal.user.UserContext;
import com.ird.portal.user.entity.UserEntity;
import com.ird.portal.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * login AD驗證
 * <br/>
 * <br/>
 * <b>Date:</b>2018年4月18日<br/>
 * @author linwood
 * @version 1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	private LoginService loginService;

	@Autowired
	private UserService userService;

	private String redirectUrl;

    @GetMapping(path = "/login.html")
    public String login(String param) {
		setRedirectUrl(param);
    	return "login";
    }


    @PostMapping(path = "/login")
    @ResponseBody
    public void login(@RequestBody(required=false) User u, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
    	String url= "";
    	if (getRedirectUrl() != null){
			url = URLDecoder.decode(getRedirectUrl(),"UTF-8");
		}
		int checkFlag =loginService.login(u,request);
		OutputStream out = null;
		try {
			response.setContentType("application/json"); 
			out = response.getOutputStream();
			String data = "{\"checkFlag\":\""+checkFlag+"\",\"url\":\""+url+"\"}";
			out.write(data.getBytes());  
			out.flush();
		} catch (IOException e) {
			logger.error("IOException " + e.getMessage(), e);
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					logger.error("IOException " + e.getMessage(), e);
				}   
			}
		}
    }


    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
    	if(loginService.logout(request)){
			return "redirect:/login/login.html";
		}
		logger.debug("Logout exception");
		return "redirect:/login/login.html";


    }

	@PostMapping(path = "/updatePwd")
	@ResponseBody
	public Map<String, String> updatePwd(HttpServletRequest request, UserDTO userDTO) {
		Map<String, String> returnUser = new HashMap<>();
		String oldPwd=DigestUtils.md5DigestAsHex(userDTO.getOldPassword().getBytes());
		HttpSession session = request.getSession();
		User user= (User) session.getAttribute(UserContext.USER_SESSION);

		UserEntity userEntity=userService.getById(user.getUserId());
		if(!"L".equals(userDTO.getUserType())){
			returnUser.put("result", "403");
			returnUser.put("resultMsg", "用戶類型不對");
			return returnUser;
		}
		if(!oldPwd.equals(userEntity.getPassword())){
			returnUser.put("result", "403");
			returnUser.put("resultMsg", "舊密碼錯誤");
			return returnUser;
		}
		if(!userDTO.getNewPassword().equals(userDTO.getNewPassword2())){
			returnUser.put("result", "403");
			returnUser.put("resultMsg", "兩次密碼不同");
			return returnUser;
		}
		String newPwd=DigestUtils.md5DigestAsHex(userDTO.getNewPassword().getBytes());
		userEntity.setPassword(newPwd);
		userService.updatePwd(userEntity);

		returnUser.put("result", "200");
		returnUser.put("resultMsg", "密碼修改成功，請重新登陸");
    	return returnUser;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}


	@GetMapping(path = "/i18n/changeLangage")
	public String changeLangage(HttpServletRequest request, HttpServletResponse response, @RequestParam String langage) {
		System.out.println(langage);
		User user = UserContext.getUser();
		if (user != null) {
			if(Locale.ENGLISH.getLanguage().equals(langage)){
				//代码中即可通过以下方法进行语言设置
				user.setLocale(Locale.ENGLISH);
			} else {
				user.setLocale(Locale.TRADITIONAL_CHINESE);
			}
		}
		return "redirect:/index.html";
	}
}
