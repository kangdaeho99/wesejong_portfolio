package org.wesejong.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wesejong.domain.AlarmVO;
import org.wesejong.domain.MeetMatchApplicationDetailsVO;
import org.wesejong.domain.MeetMatchApplicationHistoryVO;
import org.wesejong.domain.MeetMatchManageVO;
import org.wesejong.domain.MeetMatchPersonnelManageVO;
import org.wesejong.domain.MeetMatchProfileVO;
import org.wesejong.domain.MeetMatchTeamMateVO;
import org.wesejong.domain.MeetMatchTeamVO;
import org.wesejong.domain.MemberVO;
import org.wesejong.security.domain.CustomUser;
import org.wesejong.service.AlarmService;
import org.wesejong.service.MeetMatchDepartmentService;
import org.wesejong.service.MeetMatchManageService;
import org.wesejong.service.MeetMatchProfileService;
import org.wesejong.service.MeetMatchTeamMateService;
import org.wesejong.service.MeetMatchTeamService;
import org.wesejong.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/meetmatch/event/*")
@Log4j
public class MeetMatchController {
	
	@Setter(onMethod_=@Autowired)
	private MemberService memberservice;
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchManageService meetmatchmanageservice;

	@Setter(onMethod_=@Autowired)
	private MeetMatchProfileService meetmatchprofileservice;
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchTeamService meetmatchteamservice;
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchTeamMateService meetmatchteammateservice;
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchDepartmentService meetmatchdepartmentservice;

	@Setter(onMethod_=@Autowired)
	private AlarmService alarmservice;
	
	@GetMapping("/explanation")
	public void dolistPage(Model model) {
		log.info("gotoexplanationpage....");
		
//		미트매치에 들어갔을시, 가장 최근에 등록한 meetmatchmanage의 정보가 가져옵니다.
		
		MeetMatchManageVO meetmatchmanagevo = meetmatchmanageservice.get_MeetMatchManageVO_by_read_Max_meetmatchmanage_seq();
		model.addAttribute("meetmatchmanage",meetmatchmanagevo);
		model.addAttribute("meetmatchlist", meetmatchmanageservice.getListWith_meetmatchpersonnelmanage_by_meetmatchmanage_seq(meetmatchmanagevo));
	}
	
	
	@GetMapping("/apply")
	public void doapplyPage(Model model, Authentication authentication) {
		
		MeetMatchProfileVO meetmatchprofilevo = new MeetMatchProfileVO();
		MeetMatchManageVO meetmatchmanagevo = meetmatchmanageservice.get_MeetMatchManageVO_by_read_Max_meetmatchmanage_seq();
		
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = (MemberVO) customuser.getMember();
			meetmatchprofilevo  = meetmatchprofileservice.get_by_mem_seq(membervo.getMem_seq());	
			model.addAttribute("meetmatchprofile", meetmatchprofilevo);
			

		}
			model.addAttribute("meetmatchmanage",meetmatchmanagevo);
			model.addAttribute("meetmatchlist", meetmatchmanageservice.getListWith_meetmatchpersonnelmanage_by_meetmatchmanage_seq(meetmatchmanagevo));		
	}

//	postmapping이어도 request.getParameter로 받아올 수 있습니다.		
	@PostMapping("/apply")
	public String apply(MeetMatchPersonnelManageVO meetmatchpersonnelvo, MeetMatchTeamVO meetmatchteamvo, MeetMatchTeamMateVO meetmatchteammatevo, Model model, HttpServletRequest request, Authentication authentiation) {
		log.info("gotoapplyregister");
		MeetMatchManageVO meetmatchmanagevo = meetmatchmanageservice.get_MeetMatchManageVO_by_read_Max_meetmatchmanage_seq();
		Long meetmatchmanage_seq = meetmatchmanagevo.getMeetmatchmanage_seq();
		
//		System.out.println(meetmatchmanagevo);
//		System.out.println(meetmatchteamvo);
//		System.out.println(meetmatchteammatevo);
//		System.out.println(meetmatchpersonnelvo);
		
		MemberVO membervo = new MemberVO();
		String[] meetmatchteammate_mem_userid = request.getParameterValues("meetmatchteammate_mem_userid");
		
		
//		같은아이디로 두번 지원했을때입니다.
		for(int i=0;i<meetmatchteammate_mem_userid.length;i++) {
			for(int j=0;j<meetmatchteammate_mem_userid.length;j++) {
				if(i != j) {
					if(meetmatchteammate_mem_userid[i].equals(meetmatchteammate_mem_userid[j])) {
						System.out.println("same mem_userid");
						return "/meetmatch/event/applyfail";
					}
				}
			}
		}
		
//		실제 존재하는 아이디인지 유효성test합니다.
//		추가로 똑같이 지원했던 이력이 있는지도 테스트해야합니다.
		for(int i=0;i<meetmatchteammate_mem_userid.length;i++) {
			membervo.setMem_userid(meetmatchteammate_mem_userid[i]);
			if(memberservice.get_by_mem_userid(membervo) == null) {
				System.out.println("not existing membervo");
				return "/meetmatch/event/applyfail";
			}
		}
		
//		중복되어 신청한 존재가 있는지 확인합니다.
//		우선 멤버마다 신청된 meetmatchteammate_list를 모두 가져옵니다.
//		meetmatchteammate_list의 meetmatchteam_seq를 가져와서,  
//		이번의 meetmatchmanagevo의 meetmatchmanage_seq과 같은 값이 존재한다면 
//		return "/meetmatch/event/applyfail"; 을 시켜주면됩니다.
		
		List<MeetMatchTeamMateVO> meetmatchteammatevo_list = new ArrayList<MeetMatchTeamMateVO>();
		List<MeetMatchTeamVO> meetmatchteamvo_list = new ArrayList<MeetMatchTeamVO>();
		
		for(int i=0;i<meetmatchteammate_mem_userid.length;i++) {
			membervo.setMem_userid(meetmatchteammate_mem_userid[i]);
			
			membervo = memberservice.get_by_mem_userid(membervo);
			meetmatchteammatevo_list = meetmatchteammateservice.getList_by_mem_seq_of_member(membervo);
			meetmatchteamvo_list = meetmatchteamservice.getList_by_meetmatchteam_seq_of_meetmatchteammate(meetmatchteammatevo_list);
			
			for(int j=0;j<meetmatchteamvo_list.size();j++) {
				if(meetmatchteamvo_list.get(j).getMeetmatchmanage_seq() == meetmatchmanage_seq) {
					System.out.println("not multi apply!!!!");
					return "/meetmatch/event/applyfail";	
				}
			}
		}
		
//		meetmatchteam에 실제로 팀을 넣습니다.
		meetmatchteamvo.setMeetmatchmanage_seq(meetmatchmanage_seq);
		meetmatchteamvo.setMeetmatchteam_certified((long) 0);
		meetmatchteamvo.setMeetmatchteam_matchedflag((long) 0);
		meetmatchteamvo.setMeetmatchteammate_certifiedcount((long) 1);

		meetmatchteamservice.register(meetmatchteamvo);
		
		Long meetmatchteam_seq;
		if(meetmatchteamvo.getMeetmatchteam_seq() == null) {
			meetmatchteam_seq = (long) 1;
		}else {
			meetmatchteam_seq = meetmatchteamvo.getMeetmatchteam_seq()+1;
		}
		
		meetmatchteamvo.setMeetmatchteam_seq(meetmatchteam_seq);
		
		
		System.out.println("log meetmatchteamvo's meetmatchteam_seq:"+meetmatchteamvo);
		
//		meetmatchteammate에 팀원들의 데이터를 넣습니다.
		for(int i=0;i<meetmatchteammate_mem_userid.length;i++) {
			membervo.setMem_userid(meetmatchteammate_mem_userid[i]);
			membervo = memberservice.get_by_mem_userid(membervo);
			meetmatchteammatevo.setMeetmatchteammate_gender(meetmatchteamvo.getMeetmatchteam_gender());
			meetmatchteammatevo.setMeetmatchteammate_department("");
			meetmatchteammatevo.setMeetmatchteammate_teamleaderflag((long) 0);
			meetmatchteammatevo.setMem_seq(membervo.getMem_seq());
			meetmatchteammatevo.setMeetmatchteam_seq(meetmatchteamvo.getMeetmatchteam_seq());
			meetmatchteammatevo.setMeetmatchteammate_certified((long) 0);	
			if(i==0) {
				meetmatchteammatevo.setMeetmatchteammate_teamleaderflag((long) 1);	
				meetmatchteammatevo.setMeetmatchteammate_certified((long) 1);	
			}
			
			
			meetmatchteammateservice.register(meetmatchteammatevo);
			meetmatchteamservice.update_certified_count_by_meetmatchteam_seq(meetmatchteamvo);
//			System.out.println(meetmatchteammatevo);		
		}
		
//		meetmatchteammate에 들어간 팅원들에게 alarm 초대장을 보냅니다.
		AlarmVO alarmvo = new AlarmVO();
		for(int i=0;i<meetmatchteammate_mem_userid.length;i++) {
			membervo.setMem_userid(meetmatchteammate_mem_userid[i]);
			membervo = memberservice.get_by_mem_userid(membervo);
			alarmvo.setAlarm_title("세종대학교 미팅매칭이벤트에서 초대장이 도착했습니다.");
			alarmvo.setAlarm_content("초대장의 링크에 들어가서 미팅매칭이벤트에 참여해보세요!");
			alarmvo.setAlarm_writer("meetmatchadmin");
			alarmvo.setAlarm_type("3");
			alarmvo.setMem_seq(membervo.getMem_seq());
			alarmservice.register(alarmvo);
		}
		
		
		return "redirect:/meetmatch/event/applyresult";
////	자동으로 meetmatchteamvo에 meetmatchteam_seq을 넣어줍니다.
//		log meetmatchteamvo's meetmatchteam_seq:MeetMatchTeamVO(meetmatchteam_seq=6, meetmatchteam_gender=male, meetmatchteam_certified=null, meetmatchteam_matchedflag=null, meetmatchteam_regdate=null, meetmatchteam_certifieddate=null, meetmatchmanage_seq=1)
		
//		MemberVO meetmatchteammate_membervo = new MemberVO(); 
//		String[] meetmatchteammate_mem_userid = request.getParameterValues("meetmatchteammate_mem_userid");
//		Long meetmatchmanage_seq = meetmatchteamvo.getMeetmatchmanage_seq();
//		for(int i=0;i<meetmatchteammate_mem_userid.length;i++) {
//			meetmatchteammate_membervo.setMem_userid(meetmatchteammate_mem_userid[i]);
//			MemberVO membervo_mem_seq = memberservice.get_by_mem_userid(meetmatchteammate_membervo);
////			일단 진짜 존재하는 mem_userid를 넣는것이 아니므로 아무숫자나 넣어줍니다.
////			meetmatchteammatevo.setMem_seq(membervo_mem_seq.getMem_seq());
//			meetmatchteammatevo.setMeetmatchteammate_gender("");
//			meetmatchteammatevo.setMeetmatchteammate_department("");
//			meetmatchteammatevo.setMeetmatchteammate_teamleaderflag((long)0);
//			meetmatchteammatevo.setMem_seq((long)i);
//			meetmatchteammatevo.setMeetmatchteam_seq(meetmatchteamvo.getMeetmatchteam_seq());
//			if(i==0) {
//				meetmatchteammatevo.setMeetmatchteammate_teamleaderflag((long)1);
//			}
//			
//			meetmatchteammateservice.register(meetmatchteammatevo);
//			System.out.println(meetmatchteammatevo);
//		}
//		
	}
	
	@GetMapping("/applyresult")
	public void doapplyresultPage() {
		log.info("do apply page......");
	}
	
	@GetMapping("/applyfail")
	public void doapplyfailPage() {
		log.info("do apply page......");
	}
	
	
	@GetMapping("/applicationhistory")
	public void doapplicationhistoryPage(Model model, Authentication authentication) {
		log.info("do applicationhistory page......");
		
		List<MeetMatchTeamMateVO> meetmatchteammatevo_list = new ArrayList<MeetMatchTeamMateVO>();
		List<MeetMatchTeamVO> meetmatchteamvo_list = new ArrayList<MeetMatchTeamVO>();
		List<MeetMatchManageVO> meetmatchmanagevo_list = new ArrayList<MeetMatchManageVO>();

		List<MeetMatchApplicationHistoryVO> meetmatchapplicationhistoryvo_list = new ArrayList<MeetMatchApplicationHistoryVO>();

		
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			
			
			
			
//			이 3가지의 값들은 모두 해당 사용자가 포함되어있는 값들입니다.
			meetmatchteammatevo_list = meetmatchteammateservice.getList_by_mem_seq_of_member(membervo);
			meetmatchteamvo_list = meetmatchteamservice.getList_by_meetmatchteam_seq_of_meetmatchteammate(meetmatchteammatevo_list);
			meetmatchmanagevo_list = meetmatchmanageservice.getList_by_meetmatchmanage_seq_of_meetmatchteam(membervo);

//			해당 페이지를 불러올떄마다 신청승인 현황을 update해줍니다.
			for(int i=0;i<meetmatchteamvo_list.size();i++) {
				meetmatchteamservice.update_certified_count_by_meetmatchteam_seq(meetmatchteamvo_list.get(i));
			}
			
			
//			중복신청할시 에러뜹니다. 중복신청 불가하게 만듭니다.
			for(int i=0;i<meetmatchteamvo_list.size();i++) {
				
//				meetmatchmanage_seq은 무조건 존재하는것이니 굳이 For문 안써도될거같다.
						MeetMatchTeamVO meetmatchteamvo = meetmatchteamvo_list.get(i);
						MeetMatchManageVO meetmatchmanagevo = meetmatchmanageservice.get(meetmatchteamvo.getMeetmatchmanage_seq());
						
						MeetMatchApplicationHistoryVO meetmatchapplicationhistoryvo = new MeetMatchApplicationHistoryVO();
						meetmatchapplicationhistoryvo.setMeetmatchmanage_seq(meetmatchmanagevo.getMeetmatchmanage_seq());
						meetmatchapplicationhistoryvo.setMeetmatchmanage_eventid(meetmatchmanagevo.getMeetmatchmanage_eventid());
						meetmatchapplicationhistoryvo.setMeetmatchmanage_eventtitle(meetmatchmanagevo.getMeetmatchmanage_eventtitle());
						meetmatchapplicationhistoryvo.setMeetmatchmanage_eventreleasedate(meetmatchmanagevo.getMeetmatchmanage_eventreleasedate());
						meetmatchapplicationhistoryvo.setMeetmatchmanage_eventendflag(meetmatchmanagevo.getMeetmatchmanage_eventendflag());
						
						meetmatchapplicationhistoryvo.setMeetmatchteam_seq(meetmatchteamvo.getMeetmatchteam_seq());
						meetmatchapplicationhistoryvo.setMeetmatchteam_gender(meetmatchteamvo.getMeetmatchteam_gender());
						meetmatchapplicationhistoryvo.setMeetmatchpersonnelmanage_personnel(meetmatchteamvo.getMeetmatchpersonnelmanage_personnel());
						
						meetmatchapplicationhistoryvo.setMeetmatchteammate_certifiedcount(meetmatchteamvo.getMeetmatchteammate_certifiedcount());
						meetmatchapplicationhistoryvo.setMeetmatchteam_matchedflag(meetmatchteamvo.getMeetmatchteam_matchedflag());
						
						
						meetmatchapplicationhistoryvo_list.add(meetmatchapplicationhistoryvo);
			}
			
			model.addAttribute("meetmatchapplicationhistory", meetmatchapplicationhistoryvo_list);
			
//			model.addAttribute("meetmatchteammate", meetmatchteammatevo);
//			model.addAttribute("meetmatchteam", meetmatchteamservice.getList_by_meetmatchteam_seq_of_meetmatchteammate(meetmatchteammatevo));
//			model.addAttribute("meetmatchmanage", meetmatchmanageservice.getList_by_meetmatchmanage_seq_of_meetmatchteam(membervo));
		}
		
	}
	
	
	@GetMapping("/applicationdetails")
	public void doapplicationdetailsPage(MeetMatchTeamVO meetmatchteamvo, Model model, Authentication authentication) {
		log.info("do applicationdetails page......");
		
		List<MeetMatchTeamMateVO> meetmatchteammatevo_list = new ArrayList<MeetMatchTeamMateVO>();
		List<MeetMatchTeamVO> meetmatchteamvo_list = new ArrayList<MeetMatchTeamVO>();
		List<MeetMatchManageVO> meetmatchmanagevo_list = new ArrayList<MeetMatchManageVO>();

		List<MeetMatchApplicationDetailsVO> meetmatchapplicationdetailsvo_list = new ArrayList<MeetMatchApplicationDetailsVO>();
		
		
////해당하는 meetmatchteam의 정보입니다.		
		meetmatchteamvo = meetmatchteamservice.get(meetmatchteamvo.getMeetmatchteam_seq());
		model.addAttribute("meetmatchteam", meetmatchteamvo);
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			
//meetmatchteam의 meetmatchteammate들을 모두 가져옵니다.
			meetmatchteammatevo_list = meetmatchteammateservice.getList_by_meetmatchteam_seq_of_meetmatchteam(meetmatchteamvo, membervo);
			System.out.println(meetmatchteammatevo_list);
			
			
			for(int i=0;i<meetmatchteammatevo_list.size();i++) {
				MeetMatchApplicationDetailsVO meetmatchapplicationdetailsvo = new MeetMatchApplicationDetailsVO();
				MemberVO membervo_for_mem_seq = new MemberVO();
				
				membervo_for_mem_seq.setMem_seq(meetmatchteammatevo_list.get(i).getMem_seq());				
				System.out.println(memberservice.get_by_mem_seq(membervo_for_mem_seq));
				membervo_for_mem_seq = memberservice.get_by_mem_seq(membervo_for_mem_seq);
				
				if(membervo_for_mem_seq == null) {
					meetmatchapplicationdetailsvo.setMem_userid("탈퇴한 회원");
				}else {
					meetmatchapplicationdetailsvo.setMem_userid(membervo_for_mem_seq.getMem_userid());	
				}
				
				
				meetmatchapplicationdetailsvo.setMeetmatchteammate_gender(meetmatchteammatevo_list.get(i).getMeetmatchteammate_gender());
				meetmatchapplicationdetailsvo.setMeetmatchteaammate_regdate(meetmatchteammatevo_list.get(i).getMeetmatchteammate_regdate());
				meetmatchapplicationdetailsvo.setMeetmatchteammate_certified(meetmatchteammatevo_list.get(i).getMeetmatchteammate_certified());
				meetmatchapplicationdetailsvo.setMeetmatchteam_matchedflag(meetmatchteamvo.getMeetmatchteam_matchedflag());
				
				meetmatchapplicationdetailsvo_list.add(meetmatchapplicationdetailsvo);				
			}
			
			model.addAttribute("meetmatchapplicationdetails", meetmatchapplicationdetailsvo_list);
			meetmatchteamservice.update_certified_count_by_meetmatchteam_seq(meetmatchteamvo);
		}
		
		
	}
	
	@PostMapping("/applicationdetails_confirm")
	public String postapplicationdetails_confirm(MeetMatchTeamVO meetmatchteamvo, Authentication authentication) {
		
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			MemberVO membervo = customuser.getMember();
			
			
			
			MeetMatchTeamMateVO meetmatchteammatevo = new MeetMatchTeamMateVO();
			meetmatchteammatevo.setMeetmatchteam_seq(meetmatchteamvo.getMeetmatchteam_seq());
			meetmatchteammatevo.setMem_seq(membervo.getMem_seq());
			
			meetmatchteammatevo = meetmatchteammateservice.get_by_meetmatchteam_seq_and_mem_seq(meetmatchteammatevo);
			
			
			if(meetmatchteammatevo.getMeetmatchteammate_certified() == 1) {
				meetmatchteammatevo.setMeetmatchteammate_certified((long) 0); 				
				meetmatchteammateservice.update_meetmatchteammate_certified_by_meetmatchteam_seq_and_mem_seq(meetmatchteammatevo);
					
				AlarmVO alarmvo = new AlarmVO();
				alarmvo.setAlarm_title("세종대학교 미팅매칭이벤트에서 신청취소알림이 도착했습니다.");
				alarmvo.setAlarm_content("정확한 정보를 보고싶으시다면 해당 링크를 통해 확인하세요!");
				alarmvo.setAlarm_writer("meetmatchadmin");
				alarmvo.setAlarm_type("3");
				alarmvo.setMem_seq(membervo.getMem_seq());
				alarmservice.register(alarmvo);
				
			}
				else if(meetmatchteammatevo.getMeetmatchteammate_certified() == 0){
				meetmatchteammatevo.setMeetmatchteammate_certified((long) 1); 
				meetmatchteammateservice.update_meetmatchteammate_certified_by_meetmatchteam_seq_and_mem_seq(meetmatchteammatevo);
				
				AlarmVO alarmvo = new AlarmVO();
				alarmvo.setAlarm_title("세종대학교 미팅매칭이벤트에서 신청수락알림이 도착했습니다.");
				alarmvo.setAlarm_content("정확한 정보를 보고싶으시다면 해당 링크를 통해 확인하세요!");
				alarmvo.setAlarm_writer("meetmatchadmin");
				alarmvo.setAlarm_type("3");
				alarmvo.setMem_seq(membervo.getMem_seq());
				alarmservice.register(alarmvo);
				
			}
			
		}
		
		return "redirect:/meetmatch/event/applicationdetails?meetmatchteam_seq="+meetmatchteamvo.getMeetmatchteam_seq();
		
		
	}
	
	
//	@GetMapping("/teammateconfirmdetails")
//	public void doconfirmdetailsPage(Model model, HttpServletRequest request, Authentication authentication) {
//		log.info("do confirm page......");
//		List<MeetMatchTeamMateVO> list_meetmatchteammatevo = new ArrayList<MeetMatchTeamMateVO>();
//		MeetMatchTeamMateVO meetmatchteammatevo = new MeetMatchTeamMateVO();
//		long meetmatchteam_seq = Long.parseLong(request.getParameter("meetmatchteam_seq"));
//		meetmatchteammatevo.setMeetmatchteam_seq(meetmatchteam_seq);		
//		if(authentication!=null) {
//			CustomUser customuser = (CustomUser) authentication.getPrincipal();
//			list_meetmatchteammatevo = meetmatchteammateservice.getList_by_meetmatchteam_seq_of_meetmatchteammate(meetmatchteammatevo, customuser.getMember());
//			model.addAttribute("meetmatchteammate",list_meetmatchteammatevo);
//		}
//		
//	}


//	@GetMapping("/applicationdetailshistory")
//	public void doapplicationdetailshistoryPage(Model model, Authentication authentication) {
////		사용자가 applicationdetailshistory.jsp : 본인이 참가했던 내역들의 정보(매칭결과 포함)를 보여주는 화면입니다.
////		1.접속했을때, meetmatchteammate에서 session의 mem_seq을 통해 meetmatchteammatevo값을 list형태로 모두 가져옵니다.
////		2.meetmatchteammatevo list형태의 meetmatchteam_seq을 통해 meetmatchteamvo list를 가져옵니다.
////		3.meetmatchteamvo를 가져온뒤 화면단에 뿌려줍니다.
//		log.info("do application detailshistory page...");
//		List<MeetMatchTeamMateVO> meetmatchteammatevo = new ArrayList<MeetMatchTeamMateVO>();
//		List<MeetMatchTeamVO> meetmatchteamvo = new ArrayList<MeetMatchTeamVO>();
//		List<MeetMatchManageVO> meetmatchmanagevo = new ArrayList<MeetMatchManageVO>();
//		
//		if(authentication!=null) {
//			CustomUser customuser = (CustomUser) authentication.getPrincipal();
//			meetmatchteammatevo = meetmatchteammateservice.getList_by_mem_seq_of_member(customuser.getMember());
//			
//			model.addAttribute("meetmatchteammate",meetmatchteammatevo);
//			model.addAttribute("meetmatchteam",meetmatchteamservice.getList_by_meetmatchteam_seq_of_meetmatchteammate(meetmatchteammatevo));
//			model.addAttribute("meetmatchmanage", meetmatchmanageservice.getList_by_meetmatchmanage_seq_of_meetmatchteam(customuser.getMember()));	
//		}
//	}
	
//	@GetMapping("/explanation")
//	public void dolistPage(Model model) {
//		log.info("gotoexplanationpage....");
////		model.addAttribute("meetmatchlist", meetmatchservice.getListWith_meetmatchpersonnelmanage());
////		미트매치에 들어갔을시, 가장 최근에 등록한 meetmatchmanage의 정보가 가져옵니다.
//		model.addAttribute("meetmatchmanage",meetmatchmanageservice.get_MeetMatchManageVO_by_read_Max_meetmatchmanage_seq());
//	}
//
//	@GetMapping("/profile")
//	public void doprofilePage(Model model, HttpServletRequest request, Authentication authentication) {
//		log.info("gotoprofilepage");
//		
//		List<MeetMatchDepartmentVO> meetmatchdepartmentvo_list = meetmatchdepartmentservice.getList();
//		MeetMatchManageVO meetmatchmanagevo = new MeetMatchManageVO();
//		MemberVO membervo = new MemberVO();
//		MeetMatchProfileVO meetmatchprofilevo = new MeetMatchProfileVO();
//		
//		Long meetmatchmanage_seq = Long.parseLong(request.getParameter("meetmatchmanage_seq"));
//		meetmatchmanagevo.setMeetmatchmanage_seq(meetmatchmanage_seq);
////		System.out.println(authentication);
//		
////		검색어:spring security CustomUser cannot be cast to
////		https://stackoverflow.com/questions/32465706/spring-securitiy-retrieving-data-from-custom-user
//		
//		if(authentication!=null) {	//만약 로그인한 상태라면, meetmatchprofile 테이블의 데이터가 존재한다면 해당값을 화면에서 보여줍니다.
//			CustomUser customuser = (CustomUser) authentication.getPrincipal();
//			System.out.println(customuser);
//			meetmatchprofilevo = meetmatchprofileservice.get_by_mem_seq(customuser.getMember().getMem_seq());
//			System.out.println(meetmatchprofilevo);
//			model.addAttribute("meetmatchprofile",meetmatchprofilevo);
//		}
//
//		model.addAttribute("meetmatchmanage", meetmatchmanagevo);
//		model.addAttribute("meetmatchdepartment",meetmatchdepartmentvo_list);
//		
//	}
//	
//	@PostMapping("/profile")
//	public String profile(MeetMatchProfileVO meetmatchprofilevo, MeetMatchManageVO meetmatchmanagevo, Model model, HttpServletRequest request, Authentication authentication) {
//			
//		if(authentication!=null) {	//만약 로그인한 상태라면, 
//			CustomUser customuser = (CustomUser) authentication.getPrincipal();
//			System.out.println(customuser);
//			meetmatchprofilevo.setMem_seq(customuser.getMember().getMem_seq());
//		}
//		
//		if(meetmatchprofileservice.getExists_by_mem_seq(meetmatchprofilevo.getMem_seq())==0) {
//			meetmatchprofileservice.register(meetmatchprofilevo);
//		}
//		
////		Long meetmatchmanage_seq = Long.parseLong(request.getParameter("meetmatchmanage_seq"));
////		hidden값을 통해서 meetmatchmanage_seq를 넘깁니다.
//		Long meetmatchmanage_seq = meetmatchmanagevo.getMeetmatchmanage_seq();
//		System.out.println(meetmatchmanagevo);
//		
////		return "meetmatch/event/apply?meetmatchmanage_seq="+meetmatchmanage_seq;
////		return "meetmatch/event/apply"; forward 방식으로 apply를 넘길려했으나, forward방식으로 진행할시 Controller에서 forward로 맵핑한 컨트롤러함수가 작동하지 않습니다.
////		그래서 RequestDispatcher rd = request.getRequestDispatcher("b.jsp"); 방식으로 사용하면 되는것같으나, 그냥 redirect로 넘깁니다.        
////		hidden값을 통해서 meetmatchmanage_seq를 넘깁니다.
//		return "redirect:/meetmatch/event/apply?meetmatchmanage_seq="+meetmatchmanage_seq;
//	}
//	
//	@GetMapping("/apply")
//	public void doapplyPage(MeetMatchManageVO meetmatchmanagevo, Model model, HttpServletRequest request, Authentication authentication) {
////		현재 고민중
//		meetmatchmanagevo = meetmatchmanageservice.get(meetmatchmanagevo.getMeetmatchmanage_seq());	//request parameter meetmatchmanage_seq 보냅니다.
//		MemberVO membervo = new MemberVO();
//		MeetMatchProfileVO meetmatchprofilevo = new MeetMatchProfileVO();
//		if(authentication!=null) {	//로그인하지 않은 상황은 security에서 미리 설정해놓아서 상관없습니다.
//			CustomUser customuser = (CustomUser) authentication.getPrincipal();
//			if(meetmatchprofileservice.getExists_by_mem_seq(customuser.getMember().getMem_seq()) != 1){
////				만약 meetmatchprofilevo가 존재하지 않는다면, 화면에 프로필입력을 하시기 바랍니다.라고 뜨게하든가 합니다.
////				https://okky.kr/article/578596 이것처럼 할려고했지만 별로인듯합니다.
//				meetmatchprofilevo = null;
//			}else if(meetmatchprofileservice.getExists_by_mem_seq(customuser.getMember().getMem_seq()) == 1){
//				meetmatchprofilevo = meetmatchprofileservice.get_by_mem_seq(customuser.getMember().getMem_seq());
//			}
//		}
//		
//		
//		log.info("gotoapplypage");
//		System.out.println(meetmatchmanagevo);
//		System.out.println("applypagesysout");
//		
//		
//		model.addAttribute("meetmatchmanage", meetmatchmanagevo);
//		model.addAttribute("meetmatchprofile",meetmatchprofilevo);
//		
//	}
//	
//	@PostMapping("/apply")
//	public String apply(MeetMatchManageVO meetmatchmanagevo, MeetMatchPersonnelManageVO meetmatchpersonnelvo, MeetMatchTeamVO meetmatchteamvo, MeetMatchTeamMateVO meetmatchteammatevo, Model model, HttpServletRequest request, Authentication authentiation) {
//		log.info("gotoapplyregister");
//		
////		postmapping이어도 request.getParameter로 받아올 수 있습니다.
//		
//		meetmatchteamvo.setMeetmatchteam_certified((long)0);
//		
//		meetmatchteamvo.setMeetmatchteam_matchedflag((long)0);
//		meetmatchteamvo.setMeetmatchteammate_certifiedcount((long)0);
////		자동으로 meetmatchteamvo에 meetmatchteam_seq을 넣어줍니다.
//		meetmatchteamservice.register(meetmatchteamvo);
////		System.out.println("log meetmatchteamvo's meetmatchteam_seq:"+meetmatchteamvo); 
////		log meetmatchteamvo's meetmatchteam_seq:MeetMatchTeamVO(meetmatchteam_seq=6, meetmatchteam_gender=male, meetmatchteam_certified=null, meetmatchteam_matchedflag=null, meetmatchteam_regdate=null, meetmatchteam_certifieddate=null, meetmatchmanage_seq=1)
//		MemberVO meetmatchteammate_membervo = new MemberVO(); 
//		String[] meetmatchteammate_mem_userid = request.getParameterValues("meetmatchteammate_mem_userid");
//		Long meetmatchmanage_seq = meetmatchteamvo.getMeetmatchmanage_seq();
//		for(int i=0;i<meetmatchteammate_mem_userid.length;i++) {
//			meetmatchteammate_membervo.setMem_userid(meetmatchteammate_mem_userid[i]);
//			MemberVO membervo_mem_seq = memberservice.get_by_mem_userid(meetmatchteammate_membervo);
////			일단 진짜 존재하는 mem_userid를 넣는것이 아니므로 아무숫자나 넣어줍니다.
////			meetmatchteammatevo.setMem_seq(membervo_mem_seq.getMem_seq());
//			meetmatchteammatevo.setMeetmatchteammate_gender("");
//			meetmatchteammatevo.setMeetmatchteammate_department("");
//			meetmatchteammatevo.setMeetmatchteammate_teamleaderflag((long)0);
//			meetmatchteammatevo.setMem_seq((long)i);
//			meetmatchteammatevo.setMeetmatchteam_seq(meetmatchteamvo.getMeetmatchteam_seq());
//			if(i==0) {
//				meetmatchteammatevo.setMeetmatchteammate_teamleaderflag((long)1);
//			}
//			
//			meetmatchteammateservice.register(meetmatchteammatevo);
//			System.out.println(meetmatchteammatevo);
//		}
//		
//		return "redirect:/meetmatch/event/applyresult";
//	}
//	
//	@GetMapping("/applyresult")
//	public void doapplyresultPage() {
//		log.info("do apply page......");
//	}
//	
//	@GetMapping("/applicationdetailshistory")
//	public void doapplicationdetailshistoryPage(Model model, Authentication authentication) {
////		사용자가 applicationdetailshistory.jsp : 본인이 참가했던 내역들의 정보(매칭결과 포함)를 보여주는 화면입니다.
////		1.접속했을때, meetmatchteammate에서 session의 mem_seq을 통해 meetmatchteammatevo값을 list형태로 모두 가져옵니다.
////		2.meetmatchteammatevo list형태의 meetmatchteam_seq을 통해 meetmatchteamvo list를 가져옵니다.
////		3.meetmatchteamvo를 가져온뒤 화면단에 뿌려줍니다.
//		log.info("do application detailshistory page...");
//		List<MeetMatchTeamMateVO> meetmatchteammatevo = new ArrayList<MeetMatchTeamMateVO>();
//		List<MeetMatchTeamVO> meetmatchteamvo = new ArrayList<MeetMatchTeamVO>();
//		List<MeetMatchManageVO> meetmatchmanagevo = new ArrayList<MeetMatchManageVO>();
//		
//		if(authentication!=null) {
//			CustomUser customuser = (CustomUser) authentication.getPrincipal();
//			meetmatchteammatevo = meetmatchteammateservice.getList_by_mem_seq_of_member(customuser.getMember());
//			
//			model.addAttribute("meetmatchteammate",meetmatchteammatevo);
//			model.addAttribute("meetmatchteam",meetmatchteamservice.getList_by_meetmatchteam_seq_of_meetmatchteammate(meetmatchteammatevo));
//			model.addAttribute("meetmatchmanage", meetmatchmanageservice.getList_by_meetmatchmanage_seq_of_meetmatchteam(customuser.getMember()));	
//		}
//	}
//	
//	@GetMapping("/teammateconfirmdetails")
//	public void doconfirmdetailsPage(Model model, HttpServletRequest request, Authentication authentication) {
//		log.info("do confirm page......");
//		List<MeetMatchTeamMateVO> list_meetmatchteammatevo = new ArrayList<MeetMatchTeamMateVO>();
//		MeetMatchTeamMateVO meetmatchteammatevo = new MeetMatchTeamMateVO();
//		long meetmatchteam_seq = Long.parseLong(request.getParameter("meetmatchteam_seq"));
//		meetmatchteammatevo.setMeetmatchteam_seq(meetmatchteam_seq);		
//		if(authentication!=null) {
//			CustomUser customuser = (CustomUser) authentication.getPrincipal();
//			list_meetmatchteammatevo = meetmatchteammateservice.getList_by_meetmatchteam_seq_of_meetmatchteammate(meetmatchteammatevo, customuser.getMember());
//			model.addAttribute("meetmatchteammate",list_meetmatchteammatevo);
//		}
//		
//	}
	
	
}
