package org.wesejong.controller;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.wesejong.domain.AlarmVO;
import org.wesejong.domain.ChatRoomJoinVO;
import org.wesejong.domain.ChatRoomVO;
import org.wesejong.domain.MeetMatchManageVO;
import org.wesejong.domain.MeetMatchTeamMateVO;
import org.wesejong.domain.MeetMatchTeamVO;
import org.wesejong.service.AlarmService;
import org.wesejong.service.ChatRoomJoinService;
import org.wesejong.service.ChatRoomService;
import org.wesejong.service.MeetMatchManageService;
import org.wesejong.service.MeetMatchTeamMateService;
import org.wesejong.service.MeetMatchTeamService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/meetmatch/meetmatchmanage/*")
@Log4j
public class AdminMeetMatchManageController {
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchManageService meetmatchmanageservice;
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchTeamService meetmatchteamservice;
	
	@Setter(onMethod_=@Autowired)
	private MeetMatchTeamMateService meetmatchteammateservice;
	
	@Setter(onMethod_=@Autowired)
	private ChatRoomService chatroomservice;

	@Setter(onMethod_=@Autowired)
	private ChatRoomJoinService chatroomjoinservice;
	
	@Setter(onMethod_=@Autowired)
	private AlarmService alarmservice;

	@GetMapping("/list")
	public void dolistPage(Model model) {
		log.info("gotoboardList....");
		model.addAttribute("meetmatchmanagelist", meetmatchmanageservice.getListWith_meetmatchpersonnelmanage());
		
	}
	
	@GetMapping("/register")
	public void doregisterPage(Model model) {
		log.info("gotoboardregister....");
	}
	
	@PostMapping("/register")
	public String register(MeetMatchManageVO meetmatchmanagevo, RedirectAttributes rttr) {
		log.info("register:" + meetmatchmanagevo);
		meetmatchmanageservice.register(meetmatchmanagevo);
		log.info(meetmatchmanagevo.getMeetmatchmanage_eventstartdate());
		//Tue Oct 05 20:15:00 KST 2021
		rttr.addFlashAttribute("result",meetmatchmanagevo.getMeetmatchmanage_seq());
		return "redirect:/admin/meetmatch/meetmatchmanage/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("meetmatchmanage_seq") Long meetmatchmanage_seq, Model model) {
		log.info("/get");
		log.info(meetmatchmanageservice.get(meetmatchmanage_seq).getMeetmatchmanage_eventstartdate());
		//Tue Oct 05 20:15:00 KST 2021
		model.addAttribute("meetmatchmanage", meetmatchmanageservice.get(meetmatchmanage_seq));
		
	}

	@PostMapping("/modify")
	public String modifyx(MeetMatchManageVO meetmatchmanagevo, RedirectAttributes rttr) {
		log.info("modify:"+meetmatchmanagevo);
		
		if(meetmatchmanageservice.modify(meetmatchmanagevo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchmanage/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("meetmatchmanage_seq") Long meetmatchmanage_seq, RedirectAttributes rttr) {
		log.info("remove....."+meetmatchmanage_seq);
		
		if(meetmatchmanageservice.remove(meetmatchmanage_seq)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/admin/meetmatch/meetmatchmanage/list";
	}	
	
	@PostMapping("/removebychkbox")
	public String go_delete(HttpServletRequest request) {
		String[] arr = request.getParameterValues("chkbox");
		long meetmatchmanage_seq;
		for(int i=0;i<arr.length;i++) {
			meetmatchmanage_seq =(long)Integer.parseInt(arr[i]);
			meetmatchmanageservice.remove(meetmatchmanage_seq);
		}
		return "redirect:/admin/meetmatch/meetmatchmanage/list";
	}

	@GetMapping("/executerandomprogram")
	public void doexecuterandomprogram(Model model) {
		log.info("/executerandomprogram");
		
		model.addAttribute("meetmatchmanage", meetmatchmanageservice.getList());
		
	}
	
//	테스트를 위한 값 대입
	
//	meetmatch팀 전체 수정
//	update meetmatchteam set meetmatchteam_matchedflag = 0;
//	update meetmatchteam set meetmatchteam_certified = 0;
	
//	meetmatchmanage값 대입
//	insert into meetmatchmanage (meetmatchmanage_eventid, meetmatchmanage_eventtitle, meetmatchmanage_eventcontent) values (1,'','');
	
//	meetmatchmanagepersonnel값 대입
//	insert into meetmatchpersonnelmanage (meetmatchpersonnelmanage_personnel, meetmatchmanage_seq) values (1, 1);
//	insert into meetmatchpersonnelmanage (meetmatchpersonnelmanage_personnel, meetmatchmanage_seq) values (2, 1);
//	insert into meetmatchpersonnelmanage (meetmatchpersonnelmanage_personnel, meetmatchmanage_seq) values (4, 1);
	
//	1:1 일경우
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('male',1,1);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 1,1);
//	
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('male',1,1);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 2,2);
//	
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('male',1,1);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 3,3);
//	
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('female',1,1);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 4,4);
//	
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('female',1,1);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 5,5);
	
	
//	2:2 일경우
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('male',1,2);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 6,6);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 6,7);
//
//	
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('male',1,2);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 7,8);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 7,9);
//	
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('male',1,2);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 8,10);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 8,11);
//	
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('female',1,2);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 9,12);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 9,13);
//	
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('female',1,2);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 10,14);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 10,15);
	
//	4:4 일경우
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('male',1,4);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 11,16);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 11,17);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 11,18);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 11,19);
//
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('male',1,4);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 12,20);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 12,21);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 12,22);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 12,23);
//	
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('male',1,4);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 13,24);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 13,25);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 13,26);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('male', 1, 13,27);
//	
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('female',1,4);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 14,28);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 14,29);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 14,30);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 14,31);
//	
//	insert into meetmatchteam (meetmatchteam_gender, meetmatchmanage_seq, meetmatchpersonnelmanage_personnel) values ('female',1,4);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 15,32);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 15,33);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 15,34);
//	insert into meetmatchteammate (meetmatchteammate_gender, meetmatchteammate_certified, meetmatchteam_seq, mem_seq) values ('female', 1, 15,35);
	
	
//	어떤식으로 executerandomprogram을 할지 생각해봅니다.
//	1.executerandomprogram.jsp에서 결과값을 알아볼 meetmatchmanage_seq을 입력받습니다.
//	2.meetmatchmanage_seq을 받은뒤, 해당 meetmatchmanagevo를 받아옵니다.
//	3.meetmatchmanagevo의 meetmatchmanagepersonnelvoList값들을 받아옵니다.
//	4.meetmatchmanagepersonnelvoList의 인원수 (1,2,4)인 예시를 찾습니다.
//	5.인원수 1을 먼저 계산합니다.
//	6.meetmatchteamvolist에 meetmatchteam의 meetmatchmanage_seq = 1, meetmatchpersonnelmanage_personnel이 1이고,  칼럼들을 모두 가져옵니다.
//	7.meetmatchteamvolist를 돌면서 
//	meetmatchpersonnelmanage_personnel과 meetmatchteammate_certifiedcount가 같다면,
//	meetmatchteam_certified를 1으로 바꿉니다.
//	아니라면 meetmatchteam_certified를 -1 로 바꿉니다.
//	8.meetmatchteamvolist에 meetmatchmanage_seq = 1, meetmatchteam_certified = 1,   meetmatchteam_gender에 따라 
//	meetmeetmatchteamvo_male_list, meetmatchteamvo_female_list를 나눠줍니다.
//	9.meetmatchteamvo_male_list의 개수와 meetmatchteamvo_female_list의 개수를 가져옵니다.
//	10.male_list, female_list객체에 랜덤정렬 함수인 Collections.shuffle(list)를 사용합니다. (https://heum-story.tistory.com/10)
//	11.shuffle을 수행한뒤, meetmatchteamvo_male_list, meetmatchteamvo_female_list 의 수가 작은 것을 기준으로
//	해당 meetmatchteamvo_male_list의 teammate들 ( X )
//	해당 meetmatchteamvo_female_list의 teammate들에게 채팅방을 생성한뒤 초대해주고, 매칭완료되었다는 알림을 보내줍니다. ( X )
//	meetmatchteamvo_male_list와 meetmatchteamvo_female_list 의 meetmatchteam_matchedflag : 1 로 수정합니다.
//	12.수가 작은것을 넘어서면, meetmatchteam_matchedflag : -1로 수정합니다.
//	13.이것을 (1,2,4) 모두 똑같이 반복합니다.

	@PostMapping("/executerandomprogram")
	public void doexecuterandomprogram(@RequestParam("meetmatchmanage_seq") Long meetmatchmanage_seq, Model model) {
		MeetMatchManageVO meetmatchmanagevo = new MeetMatchManageVO();
		MeetMatchTeamVO meetmatchteamvo = new MeetMatchTeamVO();
		Long meetmatchpersonnelmanage_personnel;
		
		List<MeetMatchManageVO> meetmatchmanagevo_list = new ArrayList<MeetMatchManageVO>();
		List<MeetMatchTeamVO> meetmatchteamvo_list = new ArrayList<MeetMatchTeamVO>();
		List<MeetMatchTeamMateVO> meetmatchteammatevo_list = new ArrayList<MeetMatchTeamMateVO>();
		
		
		
		MeetMatchTeamVO meetmatchteamvo_male = new MeetMatchTeamVO();
		MeetMatchTeamVO meetmatchteamvo_female = new MeetMatchTeamVO();
		List<MeetMatchTeamVO> meetmatchteamvo_male_list = new ArrayList<MeetMatchTeamVO>();
		List<MeetMatchTeamVO> meetmatchteamvo_female_list = new ArrayList<MeetMatchTeamVO>();
		
		System.out.println(meetmatchmanage_seq);
		meetmatchmanagevo = meetmatchmanageservice.get(meetmatchmanage_seq);
		
		System.out.println("meetmatchmanagevo:"+meetmatchmanagevo);
		System.out.println("meetmatchpersonnelmanagevolist:"+meetmatchmanagevo.getMeetmatchpersonnelmanagevoList());
		for(int i=0;i<meetmatchmanagevo.getMeetmatchpersonnelmanagevoList().size();i++) {
			meetmatchpersonnelmanage_personnel = meetmatchmanagevo.getMeetmatchpersonnelmanagevoList().get(i).getMeetmatchpersonnelmanage_personnel();
			
			meetmatchteamvo.setMeetmatchmanage_seq(meetmatchmanagevo.getMeetmatchmanage_seq());
			meetmatchteamvo.setMeetmatchpersonnelmanage_personnel(meetmatchpersonnelmanage_personnel);
			
			meetmatchteamvo_list = meetmatchteamservice.getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel(meetmatchteamvo);
			System.out.println("meetmatchteamvo_list:"+meetmatchteamvo_list);
			for(int j=0;j<meetmatchteamvo_list.size();j++) {
				meetmatchteamservice.update_certified_count_by_meetmatchteam_seq(meetmatchteamvo_list.get(j));
				
				
				if(meetmatchpersonnelmanage_personnel == meetmatchteamvo_list.get(j).getMeetmatchteammate_certifiedcount()) {
					meetmatchteamvo.setMeetmatchteam_seq(meetmatchteamvo_list.get(j).getMeetmatchteam_seq());
					meetmatchteamvo.setMeetmatchteam_certified((long) 1);
					meetmatchteamservice.update_meetmatchteam_certified(meetmatchteamvo);
					System.out.println("certified!:"+meetmatchteamvo);
				}else {
					meetmatchteamvo.setMeetmatchteam_seq(meetmatchteamvo_list.get(j).getMeetmatchteam_seq());
					meetmatchteamvo.setMeetmatchteam_certified((long) -1);
					meetmatchteamservice.update_meetmatchteam_certified(meetmatchteamvo);
					System.out.println("certified!:"+meetmatchteamvo);
				}
			}
			
			meetmatchteamvo_male.setMeetmatchmanage_seq(meetmatchmanagevo.getMeetmatchmanage_seq());
			meetmatchteamvo_male.setMeetmatchteam_certified((long) 1);
			meetmatchteamvo_male.setMeetmatchpersonnelmanage_personnel(meetmatchpersonnelmanage_personnel);
			meetmatchteamvo_male.setMeetmatchteam_gender("male");
			
			meetmatchteamvo_male_list = meetmatchteamservice.getList_by_meetmatchmanage_seq_and_meetmatchteam_certified_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_gender(meetmatchteamvo_male);
			
			System.out.println("meetmatchteamvo_male_list:"+meetmatchteamvo_male_list);
			
			meetmatchteamvo_female.setMeetmatchmanage_seq(meetmatchmanagevo.getMeetmatchmanage_seq());
			meetmatchteamvo_female.setMeetmatchteam_certified((long) 1);
			meetmatchteamvo_female.setMeetmatchpersonnelmanage_personnel(meetmatchpersonnelmanage_personnel);
			meetmatchteamvo_female.setMeetmatchteam_gender("female");
			
			meetmatchteamvo_female_list = meetmatchteamservice.getList_by_meetmatchmanage_seq_and_meetmatchteam_certified_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_gender(meetmatchteamvo_female);
			
			System.out.println("meetmatchteamvo_female_list:"+meetmatchteamvo_female_list);
			
			
			Collections.shuffle(meetmatchteamvo_male_list);
			Collections.shuffle(meetmatchteamvo_female_list);
			
//			더작은값 구하는것임
			int shuffle_length = ( meetmatchteamvo_male_list.size() < meetmatchteamvo_female_list.size() ) ? meetmatchteamvo_male_list.size() : meetmatchteamvo_female_list.size();
			System.out.println("shuffled meetmatchteamvo_male_list:"+meetmatchteamvo_male_list);
			System.out.println("shuffled meetmatchteamvo_male_list size:"+meetmatchteamvo_male_list.size());
			System.out.println("shuffled meetmatchteamvo_female_list:"+meetmatchteamvo_female_list);
			System.out.println("shuffled meetmatchteamvo_female_list size:"+meetmatchteamvo_female_list.size());
			System.out.println("shufflelength:"+shuffle_length);
			for(int j=0;j<shuffle_length;j++) {
				
//				여기서 이상하게 meetmatchteamvo_male에 set 설정해서 할려고하면안됬습니다. (이유는 모르겟습니다)
//				그냥 바로 가져오는 방법을 택합니다.
//				
				
				meetmatchteamvo_male_list.get(j).setMeetmatchteam_matchedflag((long) 1);
				System.out.println("shuffled meetmatchteamvo_male_list.get(j):"+meetmatchteamvo_male_list.get(j));
				meetmatchteamservice.update_meetmatchteam_matchedflag(meetmatchteamvo_male_list.get(j));
				
				
				meetmatchteamvo_female_list.get(j).setMeetmatchteam_matchedflag((long) 1);
				System.out.println("shuffled meetmatchteamvo_female_list.get(j):"+meetmatchteamvo_female_list.get(j));
				meetmatchteamservice.update_meetmatchteam_matchedflag(meetmatchteamvo_female_list.get(j));
				
				
			}
		}
		
	}

	
//	1.executerandomprogram.jsp에서 결과값을 알아볼 meetmatchmanage_seq를 입력받습니다.
//	2.meetmatchmanage_seq을 받은뒤, 해당 meetmatchmanagevo를 받아옵니다.
//	3.meetmatchmanagevo의 meetmatchmanagepersonnelvoList값들을 받아옵니다.
//	4.meetmatchmanagepersonnelvoList의 인원수 (1,2,4)인 예시를 찾습니다.
//	5.인원수 1을 먼저 계산합니다.
//	6.meetmatchteamvolist에 meetmatchteam의 meetmatchmanage_seq = 1, meetmatchpersonnelmanage_personnel = 1, meetmatch_matchedflag = 1 인 값들을 가져옵니다.
//	7.meetmatchteamvolist에서 meetmatchmanage_seq= 1, meetmatchpersonnelmanage_personnel = 1, meetmatch_matchedflag = 1를 meetmatchteam_gender에 따라
//	8.meetmatchteamvo_male_list, meetmatchteamvo_female_list를 나눠줍니다.
//	9.meetmatchteamvo_male_list의 개수와 meetmatchteamvo_female_list의 개수를 가져옵니다.
//	10.male_list, female_list객체에 랜덤정렬 함수인 Collections.shuffle(list)를 사용합니다.
//	11.shuffle을 수행한뒤, meetmatchteamvo_male_list, meetmatchteamvo_female_list의 수가 작은 것을 기준으로 (개수는 같아야만함) 
//	해당 meetmatchteamvo_male_list의 teammate
//	meetmatchteamvo_female_list의 teammate들에게 채팅방을 생성한뒤 초대하고, 알림 또한 보내줍니다.
//	또한 meetmatchteamvo_male_list의 team_seq 와 meetmatchteam_female_list의 meetmatchteam_meetmatchedpartner_meetmatchteam_seq를 저장해줍니다.

	
	@PostMapping("/matchingprogram")
	public String domatchingprogram(@RequestParam("meetmatchmanage_seq") Long meetmatchmanage_seq, Model model) {
		MeetMatchManageVO meetmatchmanagevo = new MeetMatchManageVO();
		Long meetmatchpersonnelmanage_personnel;
	

		
		
		MeetMatchTeamVO meetmatchteamvo_matched_male = new MeetMatchTeamVO();
		MeetMatchTeamVO meetmatchteamvo_matched_female = new MeetMatchTeamVO();
		List<MeetMatchTeamVO> meetmatchteamvo_matched_male_list = new ArrayList<MeetMatchTeamVO>();
		List<MeetMatchTeamVO> meetmatchteamvo_matched_female_list = new ArrayList<MeetMatchTeamVO>();
		
		List<MeetMatchTeamMateVO> meetmatchteammatevo_matched_male_list = new ArrayList<MeetMatchTeamMateVO>();
		List<MeetMatchTeamMateVO> meetmatchteammatevo_matched_female_list = new ArrayList<MeetMatchTeamMateVO>();
		
//		meetmatchmanage_seq을 받아서 meetmatchmanagevo 값을 받아옵니다.
		meetmatchmanagevo = meetmatchmanageservice.get(meetmatchmanage_seq);
		
		System.out.println("meetmatchmanagevo:"+meetmatchmanagevo);
		System.out.println("meetmatchpersonnelmanagevolist:"+meetmatchmanagevo.getMeetmatchpersonnelmanagevoList());
		
//		meetmatchmanagevo의 1,2,4 인원을 모두 검사합니다.
		for(int i=0;i<meetmatchmanagevo.getMeetmatchpersonnelmanagevoList().size();i++){
			
			meetmatchpersonnelmanage_personnel = meetmatchmanagevo.getMeetmatchpersonnelmanagevoList().get(i).getMeetmatchpersonnelmanage_personnel();
			
//			meetmatchteamvo.setMeetmatchmanage_seq(meetmatchmanagevo.getMeetmatchmanage_seq());
//			meetmatchteamvo.setMeetmatchpersonnelmanage_personnel(meetmatchpersonnelmanage_personnel);
//			meetmatchteamvo.setMeetmatchteam_matchedflag((long) 1);
//			
//			meetmatchteamvo_matched_list = meetmatchteamservice.getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_matchedflag(meetmatchteamvo);
//			System.out.println("meetmatchteamvo_list:"+meetmatchteamvo_matched_list);
			
			meetmatchteamvo_matched_male.setMeetmatchmanage_seq(meetmatchmanagevo.getMeetmatchmanage_seq());
			meetmatchteamvo_matched_male.setMeetmatchpersonnelmanage_personnel(meetmatchpersonnelmanage_personnel);
			meetmatchteamvo_matched_male.setMeetmatchteam_matchedflag((long) 1);
			meetmatchteamvo_matched_male.setMeetmatchteam_gender("male");
			
			meetmatchteamvo_matched_male_list = meetmatchteamservice.getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_matchedflag_and_meetmatchteam_gender(meetmatchteamvo_matched_male);
			
			System.out.println("meetmatchteamvo_matched_male_list:"+meetmatchteamvo_matched_male_list);
			
			meetmatchteamvo_matched_female.setMeetmatchmanage_seq(meetmatchmanagevo.getMeetmatchmanage_seq());
			meetmatchteamvo_matched_female.setMeetmatchpersonnelmanage_personnel(meetmatchpersonnelmanage_personnel);
			meetmatchteamvo_matched_female.setMeetmatchteam_matchedflag((long) 1);
			meetmatchteamvo_matched_female.setMeetmatchteam_gender("female");
					
			meetmatchteamvo_matched_female_list = meetmatchteamservice.getList_by_meetmatchmanage_seq_and_meetmatchpersonnelmanage_personnel_and_meetmatchteam_matchedflag_and_meetmatchteam_gender(meetmatchteamvo_matched_female);
			
			System.out.println("meetmatchteamvo_matched_female_list:"+meetmatchteamvo_matched_female_list);
			
			Collections.shuffle(meetmatchteamvo_matched_male_list);
			Collections.shuffle(meetmatchteamvo_matched_female_list);
			
			System.out.println("meetmatchteamvo_matched_male_list:"+meetmatchteamvo_matched_male_list);
			System.out.println("meetmatchteamvo_matched_female_list_size:"+meetmatchteamvo_matched_female_list.size());
			//값이 같아야만함 값이 안같으면 실행안되게합니다. 이제 여기서부터 채팅이랑 알림 넣는것입니다.
			
//			1.meetmatchteamvo_matched_male_list와 meetmatchteamvo_matched_female_list는 이미 shuffle된상태입니다. 
//			2.meetmatchteamvo_matched_male_list의 첫번째 팀과 meetmatchteamvo_matched_female_list의 첫번째 팀
//			이 서로 매치됩니다.
//			3.서로의 meetmatchteam_seq를 meetmatchteam_partner에 넣습니다.
//			4.
			
			
			
			
			
			
			if( meetmatchteamvo_matched_male_list.size()  == meetmatchteamvo_matched_female_list.size() ) {
				
				for(int j=0;j<meetmatchteamvo_matched_male_list.size();j++) {
					

					meetmatchteamvo_matched_male = meetmatchteamvo_matched_male_list.get(j);

					
					meetmatchteamvo_matched_female = meetmatchteamvo_matched_female_list.get(j);
					
					
					meetmatchteamvo_matched_male.setMeetmatchteam_matchedpartner(meetmatchteamvo_matched_female.getMeetmatchteam_seq());
					
					meetmatchteamvo_matched_female.setMeetmatchteam_matchedpartner(meetmatchteamvo_matched_male.getMeetmatchteam_seq());
					
					meetmatchteamservice.update_meetmatchteam_matchedpartner(meetmatchteamvo_matched_male);
					meetmatchteamservice.update_meetmatchteam_matchedpartner(meetmatchteamvo_matched_female);
					
					meetmatchteammatevo_matched_male_list = meetmatchteammateservice.getList_by_meetmatchteam_seq_of_meetmatchteam(meetmatchteamvo_matched_male);
					meetmatchteammatevo_matched_female_list = meetmatchteammateservice.getList_by_meetmatchteam_seq_of_meetmatchteam(meetmatchteamvo_matched_female);
					AlarmVO alarmvo = new AlarmVO();
					
					if(meetmatchteammatevo_matched_male_list.size() == meetmatchteammatevo_matched_female_list.size()) {
						String chatroom_uuid;
						Long chatroom_seq;
						ChatRoomVO chatroomvo = new ChatRoomVO();
						ChatRoomJoinVO chatroomjoinvo = new ChatRoomJoinVO();
						
						chatroomvo.setChatroom_name("미팅매칭방");
						chatroomvo = chatroomservice.register_return_chatroom_seq(chatroomvo);						
						chatroom_seq = chatroomvo.getChatroom_seq() + 1;
						
						chatroomvo.setChatroom_seq(chatroom_seq);
						chatroomvo = chatroomservice.get(chatroomvo);
						
						chatroom_uuid = chatroomvo.getChatroom_uuid();
						for(int k=0;k<meetmatchteammatevo_matched_male_list.size();k++) {
///////////////////////////////male////////////////////////							
							alarmvo.setAlarm_title("세종대학교 미팅매치이벤트에서 매칭이 성공했습니다. 매칭상대방과 본인 모두 "+chatroom_uuid+" 채팅방에 이미 포함되어있습니다. 채팅목록에 들어가서 바로 대화해보세요!");
							alarmvo.setAlarm_content("https://wesejong.cafe24.com/socket/chat?chatroom_uuid="+chatroom_uuid+" 채팅목록에 들어가 상대방과 대화해보세요!");
							alarmvo.setAlarm_writer("meetmatchadmin");
							alarmvo.setAlarm_type("4");
							alarmvo.setMem_seq(meetmatchteammatevo_matched_male_list.get(k).getMem_seq());
							
							alarmservice.register(alarmvo);

/////////////////////////////female////////////////////////							
//							alarmvo.setAlarm_title("세종대학교 미팅매치이벤트에서 매칭이 성공했습니다");
//							alarmvo.setAlarm_content("https://wesejong.cafe24.com/socket/chat?chatroom_uuid="+chatroom_uuid+" 해당 링크로 들어가 상대방과 대화해보세요!");
//							alarmvo.setAlarm_writer("meetmatchadmin");
//							alarmvo.setAlarm_type("4");							
							alarmvo.setMem_seq(meetmatchteammatevo_matched_female_list.get(k).getMem_seq());
							
							alarmservice.register(alarmvo);

///////////////////////////////male////////////////////////
							chatroomjoinvo.setChatroom_seq(chatroomvo.getChatroom_seq());
							chatroomjoinvo.setMem_seq(meetmatchteammatevo_matched_male_list.get(k).getMem_seq());
							chatroomjoinservice.register(chatroomjoinvo);
/////////////////////////////female////////////////////////							
							chatroomjoinvo.setChatroom_seq(chatroomvo.getChatroom_seq());
							chatroomjoinvo.setMem_seq(meetmatchteammatevo_matched_female_list.get(k).getMem_seq());
							chatroomjoinservice.register(chatroomjoinvo);
						}
					}
					
					
					
				}
				
			}
			
		}
		
		return "redirect:/admin/meetmatch/meetmatchmanage/executerandomprogram";
		
	}
	
	
//	executerandomprogram을 실행할시, 매칭된 팀들은 meetmatchteam_matchedflag = 1로 변경됩니다.
//	meetmatchteam_matchedflag = 0 인 것들중인 팀들 모두에게 alarm으로 실패여부를 알려줍니다.
//	아 그리고 이후에 더 진행할것이라는것 알리기
	@PostMapping("matchingfailalarm")
	public String domatchingfailalarm(@RequestParam("meetmatchmanage_seq") Long meetmatchmanage_seq, Model model) {
		
		MeetMatchManageVO meetmatchmanagevo = meetmatchmanageservice.get(meetmatchmanage_seq);

		MeetMatchTeamVO meetmatchteamvo = new MeetMatchTeamVO();
		
		meetmatchteamvo.setMeetmatchmanage_seq(meetmatchmanagevo.getMeetmatchmanage_seq());
		meetmatchteamvo.setMeetmatchteam_matchedflag((long) 0);
		List<MeetMatchTeamVO> meetmatchteamvo_unmatched_list = meetmatchteamservice.getList_by_meetmatchmanage_seq_and_meetmatchteam_matchedflag(meetmatchteamvo);
		AlarmVO alarmvo = new AlarmVO();
		for(int i=0;i<meetmatchteamvo_unmatched_list.size();i++) {
			
			List<MeetMatchTeamMateVO> meetmatchteammatevo_unmatched_list = meetmatchteammateservice.getList_by_meetmatchteam_seq_of_meetmatchteam(meetmatchteamvo_unmatched_list.get(i));
			
			meetmatchteamvo_unmatched_list.get(i).setMeetmatchteam_matchedflag((long) -1);
			meetmatchteamservice.update_meetmatchteam_matchedflag(meetmatchteamvo_unmatched_list.get(i));
			
			for(int j=0;j<meetmatchteammatevo_unmatched_list.size();j++) {
				
				alarmvo.setAlarm_title("세종대학교 미팅매치이벤트에서 매칭이 실패했습니다.");
				alarmvo.setAlarm_content("다음기회에 다시 참여해보세요!");
				alarmvo.setAlarm_writer("meetmatchadmin");
				alarmvo.setAlarm_type("4");
				alarmvo.setMem_seq(meetmatchteammatevo_unmatched_list.get(j).getMem_seq());
				alarmservice.register(alarmvo);
				
			}
			
		}
		
		return "redirect:/admin/meetmatch/meetmatchmanage/executerandomprogram";
	}
}
