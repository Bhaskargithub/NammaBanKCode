package org.nammabank.aoplogging;

import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.nammabank.modelObjects.BankDetail;
import org.nammabank.modelObjects.UserInfo;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectjLogging {
	
	//private Logger log = Logger.getLogger(getClass());
	private Log log = LogFactory.getLog(this.getClass());

	@Pointcut("execution(* save*(..))")
	public void SavePoint(){ }
	
	
	/*---------------------------------------------
	 Point cuts and advices
	---------------------------------------------
	For hibernate dao functions
*/	
	@Pointcut("within(org.nammabank.hibernatedao..*)") 
	public void objectDao(){}
	
	@Before("objectDao()")
	public void checkDao(JoinPoint point){ //
		log.info("Execution started at dao "+point.getSignature().toString());
		log.info("Execution started at dao");
	}
	
	@After("objectDao()")
	public void afterDao(JoinPoint point){ 
		log.info("Execution completed at dao "+point.getSignature().toString());
	}
	
	// ------------------------------------------------
	// For all service functions
	
	@Pointcut("within(org.nammabank.service..*)") 
	public void atService(){}
	
	@Before("atService()")
	public void getServiceLog(JoinPoint point){ 
		log.info("Executing at service"+point.getSignature().toString());
	}
	
	//----------------------------------
	// For controller - at restservice call point
	

	@Pointcut("execution(* org.nammabank.controller.*.*(..))") 
	public void atController(){}
	
	@Before("atController()")
	public void getControlFlow(JoinPoint point){ 
		log.info("Executing controller "+point.getSignature().toString());
	}
	
	
	
	
	
	
	
	
	
	//------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	@After("atService()")
	public void checkControllerDao(){
		System.out.println("On executing service");
	}
	
	
	//@Before("objectArgMethod() && objectDao() && SavePoint()")
	/*@Before("onePoint()")
	public void SaveInsideDao(JoinPoint join)
	{
		System.out.println("Object save operation invoked for"+join.getSignature().toString());
	}*/
	
	@Before("execution(* save*(..))")
	public void checkPoint(){
		System.out.println("check point save");
	}
	
	@Before("execution(* addNewAccount(..))")
	public void onePoint(){
		System.out.println("onemore point save");
	}
	
	
	
	
	@Before("SavePoint()")
	public void getLogger(){
		System.out.println("Hey from Logging all savers advice");
	}
	
	/*
	 
	@After() //executes after method 
	
	 
	 @AfterReturning() // execute if success return
	 
	 
	 @AfterThrowing() // execute on throwing error 
	 */
	
	/*@Before("execution(* org.nammabank.hibernatedao.*(..))")
	public void daoSavers(){
		System.out.println("now from before");
	}*/
	
	
	
	/*@Before("objectDao()")
	public void forAllDao(){
		System.out.println("DAO Function calls");
	}*/
	
	
	
	/*
	@Pointcut("args(Object)") // applies to all methods that take string args
	public void objectArgMethod(){}
	
	@Pointcut("execution(* org.nammabank.hibernatedao.*.save*())")
	public void daoSavers(){}
	
	@Pointcut("execution(* save*(..))")
	public void allSavers(){}
	
	//Method for all save ops in the dao classes - hibernate and transaction dao
	
	@Before("objectArgMethod() && objectDao() && SavePoint()")
	public void SaveInsideDao(JoinPoint join)
	{
		System.out.println("Object save operation invoked for"+join.toString());
	}
	
	@Before("args(String)") // applies to all methods that take string args
	public void stringArgMethod(){
		System.out.println("method s wil string args");
	}
	@Before("args(user)") // applies to all methods that take string args
	public void ArgMethod(UserInfo user){
		System.out.println("method s wil string args"+ user.getClass());
	}
	
	
	@Before("allSavers()")
	public void getLogger(){
		System.out.println("Hey from Logging all savers advice");
	}
	

	
	@Before("execution(* getUser*(..))")//exec takes method name as args
	public void getData(){
		System.out.println("from getUser logs");
	}
	
	@Before("within(org.nammabank.controller*)")
	public void LoggingControllerMethods(JoinPoint join){
		System.out.println(join.getTarget());
		System.out.println(join.toString());
	}*/
	
	
	
	/*
	// 
	//@Pointcut(withArgs())
	public void withArgs(){
		
	}
	
	@Pointcut(args()) //point for class as param - like userinfo is a arg for a method
	public void withArgs(){
		
	}
	
	
	// all getter methods only inside that package of allmethods - dummy
	@Pointcut("allMethods && allGetters()") // all logic operations work
	public void combineMethods(){
		
	}
	*/
	// best practice - combine pointcut expression
	//JoinPoints and Advice Arguments - can specify arg to mention the 
	
	// other point cuts are target and this
}
