package kr.or.ddit.ranger.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class RangerServiceTest {
	
	// 해당 메서드가 Test 대상임을 알려주는 어노테이션이다.
	// 일반적으로 메서드 단위로 테스트 메서드를 생성한다.
	// 하나의 메서드도 시나리오에 따라 여러 개의 테스트 메서드를 생성할 수도 있다.
	// ex : 회원 등록 dao 메서드 생성시
	//		정상적인 값을 입력해서 db 테이블에 데이터가 정상적으로 입력되는 성공 케이스
	//		비정상적인 값(회원 id 중복)을 입력하여 db 테이블에 데이터가 입력되지 않는 실패 케이스
	
	// 테스트 메서드는 테스트 하려고 하는 메서드 이름 + 접미어 Test를 붙여주는 게 일반적이다.
	// getRangers ==> getRangersTest
	
	/* 
	테스트 코드의 통과 조건 :
	1. 테스트 메서드 실행 시 assert 구문을 모두 통과한다.
	2. 에러가 없으면 통과
	
	main 메서드가 없음에도 실행이 가능한 것은
	이클립스에서 @Test 메서드가 붙은 메서드를 실행 해주기 때문이다.(jUnit에서 실행)
	maven 배포시에도 @Test 메서드가 붙은 메서드가 통과가 되어야 빌드 사이클이 진행 된다.
	
	외부환경(서버)에 의존하는 코드(예: outservlet 객체의 생성..)는 테스트 하기 어렵다.
	*/
	@Test
	public void getRangersTest() {
		/***Given : 주어진 상황 기술***/
		RangerServiceI rangerService = new RangerService();

		/***When : 행위 ***/
		List<String> rangers = rangerService.getRangers();
		/***Then : 결과 ***/
		assertNotNull(rangers);	// Null이 아니면 통과한다
		
		
		
	}
	
}
