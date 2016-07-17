package com.qixin.app.flexWechatMain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qixin.app.AppConstants;
import com.qixin.app.Advanced.model.UserLocation;
import com.qixin.app.Advanced.service.UserLocationService;
import com.qixin.app.custommenu.model.CustomMenu;
import com.qixin.app.custommenu.service.ICustomMenuService;
import com.qixin.app.customreplay.model.CustomReplay;
import com.qixin.app.customreplay.service.ICustomReplayService;
import com.qixin.app.flexWechatMain.model.WeChatWall;
import com.qixin.app.flexWechatMain.service.WeChatWallService;
import com.qixin.app.message.model.AttentionMsg;
import com.qixin.app.message.model.MsgPictureText;
import com.qixin.app.message.model.WxMessage;
import com.qixin.app.message.service.IAttentionMsgService;
import com.qixin.app.message.service.IWxMessageService;
import com.qixin.app.system.config.service.ISystemConfigService;
import com.qixin.platform.commons.Config;
import com.qixin.platform.log.CommonLogger;
import com.qixin.platform.tools.date.DateUtil;
import com.qixin.platform.wxbase.message.MessageHead;
import com.qixin.platform.wxbase.message.TextMessage;
import com.qixin.platform.wxbase.message.event.ClickEventMessage;
import com.qixin.platform.wxbase.message.event.ReportLocationEventMessage;
import com.qixin.platform.wxbase.message.event.SubscribeEventMessage;
import com.qixin.platform.wxbase.message.response.Item;
import com.qixin.platform.wxbase.message.response.PictureTextMessage;
import com.qixin.platform.wxbase.message.session.HandleMessageAdapter;
import com.qixin.platform.wxbase.message.session.WeChatSession;
import com.qixin.platform.wxbase.web.SHA1;

@Controller
@RequestMapping("/")
public class QXMainController {

	private static final Logger log = Logger.getLogger(QXMainController.class);	
	
	@Resource
	private ISystemConfigService systemConfigService;
	
	@Resource
	private IWxMessageService msgService;

	@Resource
	private IAttentionMsgService ptService;

	@Resource
	private IWxMessageService wxService;

	@Resource
	private ICustomReplayService crService;

	@Resource
	private ICustomMenuService menuService;

	@Resource
	private UserLocationService userlocationService;

	@Resource
	private IAttentionMsgService attentionService;
	
	@Resource
	private WeChatWallService wechatwallservice;

	/**
	 * 接口绑定
	 * 
	 * @return
	 */
	@RequestMapping(value = "/qxmain/{bid}", method = RequestMethod.GET)
	public void bstQuery(@PathVariable("bid") String bid, String signature,
			String timestamp, String nonce, String echostr,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {

		try {
			// TODO: 对signature 等判空
			String token = AppConstants.token;
			String[] str = { token, timestamp, nonce };
			Arrays.sort(str);
			String bigStr = str[0] + str[1] + str[2];
			String digest = new SHA1().getDigestOfString(bigStr.getBytes())
					.toLowerCase();
			if (digest.equals(signature)) {
				response.setCharacterEncoding("utf-8");
				BufferedReader sis = request.getReader();
				char[] buf = new char[1024];
				int len = 0;
				StringBuffer sb = new StringBuffer();
				while ((len = sis.read(buf)) != -1) {
					sb.append(buf, 0, len);
				}
				response.getWriter().print(echostr);
				response.getWriter().flush();
				response.getWriter().close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			CommonLogger.error("奇新接口绑定出错", e);
			map.put("errorMsg", "奇新接口绑定出错!");
		}
	}

	@RequestMapping(value = "/qxmain/{bid}", method = RequestMethod.POST)
	public void bstQuery(@PathVariable("bid") String bid,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		try {
			InputStream is = request.getInputStream();
			OutputStream os = response.getOutputStream();
			final WeChatSession session = WeChatSession.newInstance();
			HandleMessageAdapter adapter = new HandleMessageAdapter(bid,
					session) {

				@Override
				public void onTextMsg(TextMessage msg) {
					
					MessageHead head = new MessageHead();
					head.setFromUserName(msg.getHead().getToUserName());
					head.setToUserName(msg.getHead().getFromUserName());
					CustomReplay wmsg =null;
					int userstauts= getusersatus(head.getToUserName(),this.getBid());
					String wxqoff=Config.getConfigValue("wxqoff");
					if(userstauts==0)
					{
						//未开放的用户
						wmsg = crService.getCustomReplayByExample(
								this.getBid(), "StatelessUserReplayMessage");
					}
					else if(userstauts==2)
					{
						//销定的用户
						wmsg = crService.getCustomReplayByExample(
								this.getBid(), "LockStatusUserReplayMessage");
					}else
					{	
						if("0".equals(wxqoff)&&"##".equals(msg.getContent().substring(0, 2)))
						{
							try
							{
								String wxqnumber=Config.getConfigValue("wxqnumber");
								
								WeChatWall weChatWall=new WeChatWall();
								weChatWall.setGamenumber(wxqnumber);
								weChatWall.setIsreg("1");
								weChatWall.setMsgtxg(msg.getContent().substring(2));
								weChatWall.setOpenid(msg.getHead().getFromUserName());
								weChatWall.setUpdatetime(DateUtil.getCurrentDateTimeToStr());
								wechatwallservice.addWeChatWall(weChatWall);
							} catch (Exception e) {

								e.printStackTrace();
							}
							msg.setContent("WXQReturnMessage");
						}
						//正常的用户
						wmsg = crService.getCustomReplayByExample(
							this.getBid(), msg.getContent());
					}
					if(wmsg==null)
					{
						//无匹配时消息响应！
						wmsg = crService.getCustomReplayByExample(
								this.getBid(), "NoReplayMessageShowthisMenu");
						
					}
					if (wmsg != null) {
						if (wmsg.getType().equals(WxMessage.TXT_TYPE)) {
							TextMessage rmsg = new TextMessage(head);
							rmsg.setContent(wmsg.getReplay());
							session.sendResponseMsg(rmsg);
						} else if (wmsg.getType().equals(WxMessage.PTXT_TYPE)) {

							PictureTextMessage ptmsg = createPictureTextMessage(
									head, wmsg.getWxmsg(), this.getBid());

							session.sendResponseMsg(ptmsg);
						}
					}
					else
					{
						//出现此消息时，管理员应该配置一条关键字为"NoReplayMessageShowthisMenu"的消息
						TextMessage rmsg = new TextMessage(head);
						log.info("严重警告：出现此消息时，管理员应该配置一条关键字为\" NoReplayMessageShowthisMenu \"");
						rmsg.setContent("抱歉！，没有您想要的消息！");
						session.sendResponseMsg(rmsg);
					}
						
						
					

				}

				@Override
				public void onClickEvent(ClickEventMessage msg) {
					// 接收到菜单点击消息
					MessageHead head = new MessageHead();
					head.setFromUserName(msg.getHead().getToUserName());
					head.setToUserName(msg.getHead().getFromUserName());
					
					CustomReplay wmsg =null;
					int userstauts= getusersatus(head.getToUserName(),this.getBid());
					if(userstauts==0)
					{
						//未开放的用户
						wmsg = crService.getCustomReplayByExample(
								this.getBid(), "StatelessUserReplayMessage");
						if (wmsg != null) {
							if (wmsg.getType().equals(WxMessage.TXT_TYPE)) {
								TextMessage rmsg = new TextMessage(head);
								rmsg.setContent(wmsg.getReplay());
								session.sendResponseMsg(rmsg);
							} else if (wmsg.getType().equals(WxMessage.PTXT_TYPE)) {

								PictureTextMessage ptmsg = createPictureTextMessage(
										head, wmsg.getWxmsg(), this.getBid());

								session.sendResponseMsg(ptmsg);
							}
						}
					}
					else if(userstauts==2)
					{
						//销定的用户
						wmsg = crService.getCustomReplayByExample(
								this.getBid(), "LockStatusUserReplayMessage");
						if (wmsg != null) {
							if (wmsg.getType().equals(WxMessage.TXT_TYPE)) {
								TextMessage rmsg = new TextMessage(head);
								rmsg.setContent(wmsg.getReplay());
								session.sendResponseMsg(rmsg);
							} else if (wmsg.getType().equals(WxMessage.PTXT_TYPE)) {

								PictureTextMessage ptmsg = createPictureTextMessage(
										head, wmsg.getWxmsg(), this.getBid());

								session.sendResponseMsg(ptmsg);
							}
						}
					}
					else
					{
						
						CustomMenu menu = menuService.getCustomMenuByBizIdAndKey(
								this.getBid(), msg.getEventKey());
						if (menu != null) {
							if (menu.getReplyType().equals(
									CustomMenu.ReplayType_TEXT)) {
								// 回复文本消息
								TextMessage txtMsg = new TextMessage(head);
								txtMsg.setContent(menu.getContent());
								session.sendResponseMsg(txtMsg);
							} else if (menu.getReplyType().equals(
									CustomMenu.ReplayType_PT)) {
								PictureTextMessage ptmsg = createPictureTextMessage(
										head, menu.getWxmsg(), this.getBid());
								session.sendResponseMsg(ptmsg);
							}
						}
						
					}
					
					
				
				}


		

			
				

				/**
				 * 接收到地理位置事件 通和于所有用户（菜存于数据库）
				 */
				@Override
				public void onReportLocationEvent(
						ReportLocationEventMessage lmsg) {
					try {
						UserLocation ul = new UserLocation();
						ul.setOpenid(lmsg.getHead().getFromUserName());
						ul.setLatitude(lmsg.getLatitude());
						ul.setLongitude(lmsg.getLongitude());
						ul.setPrecisionx(lmsg.getPrecision());
						ul.setUpdatetime(DateUtil.getCurrentDateTimeToStr2());
						userlocationService.addUserLocation(ul);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			
			

				@Override
				public void onSubscribeEvent(SubscribeEventMessage msg) {
					MessageHead head = new MessageHead();
					head.setFromUserName(msg.getHead().getToUserName());
					head.setToUserName(msg.getHead().getFromUserName());
					AttentionMsg amsg = attentionService
							.getAttentionMsgByExample(this.getBid());
					if (amsg == null) {
						TextMessage txtMsg = new TextMessage(head);
						txtMsg.setContent("你好，感谢你的关注!");
						session.sendResponseMsg(txtMsg);
					} else {
						if (amsg.getType().equals(WxMessage.TXT_TYPE)) {
							TextMessage txtMsg = new TextMessage(head);
							txtMsg.setContent(amsg.getReplay());
							session.sendResponseMsg(txtMsg);
						} else if (amsg.getType().equals(WxMessage.PTXT_TYPE)) {
							WxMessage wxmsg = wxService.getWxMessageById(amsg
									.getMsgid());

							PictureTextMessage ptmsg = createPictureTextMessage(
									head, wxmsg, this.getBid());

							session.sendResponseMsg(ptmsg);
						}
					}
				}

			};
			adapter.setPtService(ptService);
			adapter.setWxService(msgService);
			adapter.setMenuService(menuService);
			session.addOnHandleMessageListener(adapter);

			// 必须调用这两个方法
			// 如果不调用close方法，将会出现响应数据串到其它Servlet中。
			session.process(is, os);// 处理微信消息
			session.close();// 关闭Session
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/toIndex")
	public ModelAndView toStockQuery(ModelMap map) {
		return new ModelAndView("/index", map);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(ModelMap map) {
		return new ModelAndView("/index", map);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/indexcopy")
	public ModelAndView toIndexcopy(ModelMap map) {
		return new ModelAndView("/Copy of index2", map);
	}

	public PictureTextMessage createPictureTextMessage(MessageHead head,
			WxMessage wmsg, String bid) {
		PictureTextMessage ptmsg = new PictureTextMessage(head);
		ptmsg.setArticleCount(wmsg.getItems().size() + "");

		List<Item> itemList = new ArrayList<Item>();
		Item i1;
		for (MsgPictureText item : wmsg.getItems()) {
			if (item.getDescription() == null
					|| item.getDescription().equals(""))
				item.setDescription(" ");
			if (item.getUrl() == null || item.getUrl().equals(""))
				item.setUrl(" ");
			if (item.getPicUrl() == null || item.getPicUrl().equals(""))
				item.setPicUrl(" ");
			i1 = new Item(item.getTitle(), item.getDescription(),
					AppConstants.baseAppUrl + item.getPicUrl(), createURL(
							item.getUrl(), bid, head.getToUserName()));
			itemList.add(i1);
		}

		ptmsg.setItemList(itemList);
		return ptmsg;

	}

	private String createURL(String oldurl, String bid, String openid) {
		String newurl = "";
		if (null != oldurl && oldurl.indexOf("?") > -1) {
			newurl = oldurl + "&bid=" + bid + "&openid=" + openid;
		} else {
			newurl = oldurl + "?bid=" + bid + "&openid=" + openid;
		}
		if (newurl.indexOf("http") == -1)
			newurl = AppConstants.baseAppUrl + newurl;

		return newurl;
	}
	
	/**
	 *  
	 * @param openid
	 * @param bid
	 * @return int 用户状态  不存在为 0  正常状态为1 锁定状态为 2 
	 */
	private int getusersatus(String openid,String bid)
	{
//		Employee user=articleServices.queryEmployees(openid);
//		if(null!=user)
//		{
//			return user.getStatus();
//		}
//		return 0;
		return 1;
	}


}
