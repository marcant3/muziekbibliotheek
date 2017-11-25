package studiomarcant.be;

import static org.junit.Assert.*;

import org.junit.Test;

import studiomarcant.be.model.Member;

public class MemberTest {

	private Member member = new Member();
	
	
	@Test
	public void getUserIdOnNewInstanceReturnsAZeroValueTest (){
		int userId=member.getUserID();
		assertEquals("Int equals 0",0, userId);
	}
	
	@Test
	public void getUserIdReturnsCorrectValueTest (){
		Member dummyMember=createDummyMemberToTest();
		int expectedId=128;
		int actualId=dummyMember.getUserID();
		assertEquals(expectedId,actualId);
	}
	
	@Test
	public void setUserIdAndGetUserIdWorkCorrectlyTest(){
		Member dummyMember=createDummyMemberToTest();
		int expectedMemberId = 146;
		dummyMember.setUserID(expectedMemberId);
		int actualMemberId=dummyMember.getUserID();
		assertEquals(expectedMemberId, actualMemberId);
	}

	@Test
	public void getUserNameOnNewInstanceReturnsAnEmptyStringTest (){
		String username=member.getUserName();
		assertEquals("String equals null", null, username);
	}

	@Test
	public void getUserNameReturnsCorrectValueTest (){
		Member dummyMember=createDummyMemberToTest();
		String expectedUserName="Javanees";
		String actualUserName=dummyMember.getUserName();
		assertEquals(expectedUserName,actualUserName);
		
	}
	
	@Test
	public void setUserNameAndGetUserNameWorkCorrectlyTest(){
		Member dummyMember=createDummyMemberToTest();
		String expectedMemberUserName = "Fortrange";
		dummyMember.setUserName(expectedMemberUserName);
		String actualUserName=dummyMember.getUserName();
		assertEquals(expectedMemberUserName, actualUserName);
	}
	
	@Test
	public void getPasswordOnNewInstanceReturnsAnEmptyStringTest (){
		String password=member.getPassword();
		assertEquals("String equals null", null, password);
	}

	@Test
	public void getPasswordReturnsCorrectValueTest(){
		Member dummyMember=createDummyMemberToTest();
		String expectedPassword = "$2a$10$Zeefmm34wm2IiY.xGKC9xuVER0Gg6lPDyWHCvb.GaBZM09JmWO1GW";
		String actualPassword=dummyMember.getPassword();
		assertEquals(expectedPassword,actualPassword);
	}
	
	@Test
	public void setPasswordAndGetPasswordWorkCorrectlyTest(){
		 Member dummyMember=createDummyMemberToTest();
		 String expectedMemberPassword = "$2a$10$U/jrV50t6Ci8GaPRt6rRMeCfY5.ZxD45qdiJYHoXYXf8IKWWziAhK";
		 dummyMember.setPassword(expectedMemberPassword);
		 String actualPassword=dummyMember.getPassword();
		 assertEquals(expectedMemberPassword, actualPassword);
	}

		 
    // Repeated calls to hashCode should consistently return the same integer.
    @Test
    public void HashcodeIsConsistentTest() {
    	Member dummyMember=createDummyMemberToTest();
        int initial_hashcode = dummyMember.hashCode();
        assertEquals("Consistent hashcode test succeeds", initial_hashcode, dummyMember.hashCode());
        assertEquals("Consistent hashcode test succeeds", initial_hashcode, dummyMember.hashCode());
        assertEquals("Consistent hashcode test succeeds", initial_hashcode, dummyMember.hashCode());
    }
    
    
    // Objects that are equal using the equals method should return the same integer.
    @Test
    public void HashcodeOfTwoEqualObjectsReturnSameHashCodeValueTest() {
    	Member firstDummyMember=createDummyMemberToTest();
    	Member secondDummyMember=createDummyMemberToTest();
        int xhashcode = firstDummyMember.hashCode();
        int yhashcode = secondDummyMember.hashCode();
        assertEquals("Equal object, returns equal hashcode test succeeds", xhashcode, yhashcode);
    }

    
    //Test as if the objects are unequal, different integers are returned by HashCode.
    @Test
    public void HashcodeOfTwoUnEqualObjectsReturnDifferentHashCodeValueTest() {
    	Member firstDummyMember=createDummyMemberToTest();
    	Member secondDummyMember=createDummyMemberToTest();
    	secondDummyMember.setUserID(256);
    	secondDummyMember.setUserName("Axel F");
    	secondDummyMember.setPassword("$2a$10$vEdkOChO3ANzJl8RRkVk0uuRzufiWWAUvY4I/Hk83qeg8XMlCT4PK");
        int firstHashCode = firstDummyMember.hashCode();
        int secondHashCode = secondDummyMember.hashCode();
        assertTrue("Unequal objects, return unequal hashcode test succeeds", !(firstHashCode == secondHashCode));
    }
    
 


    
    // Tests if as the password is null and username is null the hashcode equals 961.
    @Test
    public void HashcodeObjectsPasswordEqualsNullAndUserNameEqualsNullTest() {
    	member.setPassword(null);
    	member.setUserName(null);
    	String password=member.getPassword();
    	String username=member.getUserName();
    	int expectedHashcode = 961; //31 * 31 =961;
    	int actualHashcode=member.hashCode();
        assertEquals("Hashcode Objects'password test succeeds", null, password);
        assertEquals("Hashcode Objects'username test succeeds", null, username);
        assertEquals("Hashcode equals 961 test succeeds",expectedHashcode,actualHashcode);
    }
    
    
    
    // Tests if as the username is null, but the password is not null the hashcode equals 1037041828.
    @Test
    public void HashcodeObjectsUsernameEqualsNullButPasswordNotEqualsNullTest() {
    	member.setPassword("bongobos");
    	member.setUserName(null);
    	String username=member.getUserName();
    	String password = member.getPassword();
    	int expectedHashcode = 1037041828;
    	int actualHashcode=member.hashCode();
        assertEquals("Hashcode Objects'username test succeeds", null, username);
        assertNotEquals("Hashcode Objects'password test succeeds", null, password);
        assertEquals("Hashcode Objects'password test succeeds", "bongobos", password);
        assertEquals("Hashcode equals 1037041828 test succeeds",expectedHashcode,actualHashcode);
    }
    
 // Tests if as the password is null, but the username is not null the hashcode equals 2131295.
    @Test
    public void HashcodeObjectsUsernameNotEqualsNullAndPasswordEqualsNullTest() {
    	member.setPassword(null);
    	member.setUserName("Dirk");
    	String username=member.getUserName();
    	String password = member.getPassword();
    	int expectedHashcode = 2131295;
    	int actualHashcode=member.hashCode();
    	assertNotEquals("Hashcode Objects'useename test succeeds", null, username);
        assertEquals("Hashcode Objects'username test succeeds", "Dirk", username);
        assertEquals("Hashcode Objects'password test succeeds", null, password);
        assertEquals("Hashcode equals 2131295 test succeeds",expectedHashcode,actualHashcode);
    }
    
    //Tests if both are not equal to null, the Hashcode equals 1039172162.
    @Test
    public void HashcodeObjectsUsernameAndPasswordBothNotEqualNullTest() {
    	member.setPassword("bongobos");
    	member.setUserName("Dirk");
    	String username=member.getUserName();
    	String password=member.getPassword();
    	int expectedHashcode = 1039172162;
    	int actualHashcode=member.hashCode();
    	assertNotEquals("Hashcode Objects'username test succeeds", null, username);
        assertNotEquals("Hashcode Objects'password test succeeds", null, password);
        assertEquals("Hashcode Objects'username test succeeds", "Dirk", username);
        assertEquals("Hashcode Objects'password test succeeds", "bongobos", password);
        assertEquals("Hashcode equals 1039172162 test succeeds",expectedHashcode,actualHashcode);
    }
  
   
    // Test that the instance is equal to itself (as should be). == Reflexive
    @Test
    public void testEqualClassToItSelf() {
    	Member dummyMember=createDummyMemberToTest();

        assertTrue("Class equal to itself.", dummyMember.equals(dummyMember));
    }

    // Test that thisInstance.equals(WrongTypeOfComparative) returns false (as should be)
    @Test
    public void PassAnIncompatibleTypeReturnsFalseTest() {
    	Member dummyMember=createDummyMemberToTest();
        assertFalse("Passing incompatible object to equals should return false", dummyMember.equals("string"));
    }

    //Test that thisInstance.equals(null) returns false (as should be).
    @Test
    public void PassNullToEqualsReturnsFalseTest() {
    	Member dummyMember=createDummyMemberToTest();
        assertFalse("Passing null to equals should return false", dummyMember.equals(null));
    }

    //Test that two instances that are equal have the same values.
    @Test
    public void equalsOfTwoInstancesThatAreEqualHaveTheSameFieldValuesTest(){
    Member firstDummyMember=createDummyMemberToTest();
	Member secondDummyMember=createDummyMemberToTest();
	int firstDummyMemberUserIdValue = firstDummyMember.getUserID();
	int secondDummyMemberUserIdValue = secondDummyMember.getUserID();
	String firstDummyMemberUserName= firstDummyMember.getUserName();
	String secondDummyMemberUserName= secondDummyMember.getUserName();
	String firstDummyMemberPassword=firstDummyMember.getPassword();
	String secondDummyMemberPassword=secondDummyMember.getPassword();
		assertTrue("Equals comparison of two equal instances succeeds",firstDummyMember.equals(secondDummyMember));
		assertEquals(firstDummyMemberUserIdValue,secondDummyMemberUserIdValue);
		assertEquals(firstDummyMemberUserName,secondDummyMemberUserName);
		assertEquals(firstDummyMemberPassword,secondDummyMemberPassword);
    }
     
    //Test thisInstance and anotherInstance, thisInstance.equals(anotherInstance) must return true if and only if anotherInstance.equals(thisInstance) returns true.
    @Test
    public void EqualsIsSymmetric() {
    	Member firstDummyMember=createDummyMemberToTest();
    	Member secondDummyMember=createDummyMemberToTest();
    	secondDummyMember.setUserID(512);
    	secondDummyMember.setUserName("Bananarama");
    	secondDummyMember.setPassword("$2a$10$vEdkOChO3ANzJl8RRkVk0uuRzufiWWAUvY4I/Hk83qeg894525ls2");
    	assertFalse("Symmetric test fails if the two Instances are different",secondDummyMember.equals(firstDummyMember));
        assertFalse("Symmetric test fails if the two Instances are different", firstDummyMember.equals(secondDummyMember));
        secondDummyMember.setUserID(128);
        secondDummyMember.setUserName("Javanees");
        secondDummyMember.setPassword("$2a$10$Zeefmm34wm2IiY.xGKC9xuVER0Gg6lPDyWHCvb.GaBZM09JmWO1GW");
        assertTrue("Symmetric test succeeds thisInstance if they are equal",firstDummyMember.equals(secondDummyMember));
        assertTrue("Symmetric test succeeds anotherInstance if they are equal", secondDummyMember.equals(firstDummyMember));

    }

    
    //Test that 	1A : Two Instances A and B will be compared, result will be that they are different. A!=B
    //			 	1B : Two Instances B and C will be compared, result will be that they are equal. B==C
    //		     	1C : Logically A can't be equal to C  A!=B & B==C --> A!=C
     			 
    @Test
    public void testEqualsIsTransitive() {
    	Member firstDummyMember=createDummyMemberToTest();
    	Member secondDummyMember=createDummyMemberToTest();
    	Member thirdDummyMember=createDummyMemberToTest();
    	firstDummyMember.setUserID(364);
    	firstDummyMember.setUserName("Pinokkio");
    	firstDummyMember.setPassword("$2a$10$vEdkOChOpllme685kjkVk0uuRzufiWWAUvY4I/Hk83qeg894525ls2");	
    	// 1A
    	assertFalse("Transitive test fails thisInstance,anotherInstance", firstDummyMember.equals(secondDummyMember));
    	// 1B
    	assertTrue("Transitive test succeeds anotherInstance,thirdInstance", secondDummyMember.equals(thirdDummyMember));
    	// 1C
    	assertFalse("Transitive test fails thisinstance, thirdInstance", firstDummyMember.equals(thirdDummyMember));
    }

    // Tests if password==null and otherPassword !=null, equals returns false
    @Test
    public void passwordIsNullOtherPasswordNotNullEqualsReturnsFalseTest() {
    	Member firstDummyMember=createDummyMemberToTest();
    	firstDummyMember.setPassword(null);
    	Member secondDummyMember=createDummyMemberToTest();
    	String password=firstDummyMember.getPassword();
    	String expectedPassword="$2a$10$Zeefmm34wm2IiY.xGKC9xuVER0Gg6lPDyWHCvb.GaBZM09JmWO1GW";
    	String otherPassword=secondDummyMember.getPassword();
    	assertEquals("Password equals null test succeeds",null,password);
    	assertNotEquals("OtherPassword does'nt equal null test succeeds",null,otherPassword);
    	assertEquals("OtherPassword equals '$2a$10$Zeefmm34wm2IiY.xGKC9xuVER0Gg6lPDyWHCvb.GaBZM09JmWO1GW' test succeeds",expectedPassword,otherPassword);
    	assertFalse("secondDummyMember equals firstDummyMember",firstDummyMember.equals(secondDummyMember));
    }
    
 // Tests if password==null and otherPassword ==null, equals returns false
    @Test
    public void passwordIsNullOtherPasswordNullEqualsReturnsFalseTest() {
    	Member firstDummyMember=createDummyMemberToTest();
    	firstDummyMember.setPassword(null);
    	Member secondDummyMember=createDummyMemberToTest();
    	secondDummyMember.setPassword(null);
    	String password=firstDummyMember.getPassword();
    	String otherPassword=secondDummyMember.getPassword();
    	assertEquals("Password equals null test succeeds",null,password);
    	assertEquals("OtherPassword equals null test succeeds",null,otherPassword);
    	assertTrue("Password equals OtherPassword",password==otherPassword);
    	assertTrue("secondDummyMember equals firstDummyMember",firstDummyMember.equals(secondDummyMember));
    }
    
    
  
 // Tests if password==null and password doesn't equal otherPassword, equals returns false
    @Test
    public void passwordIsNullPasswordNotEqualsotherPasswordThenEqualsReturnsFalseTest() {
    	Member firstDummyMember=createDummyMemberToTest();
    	firstDummyMember.setPassword(null);
    	Member secondDummyMember=createDummyMemberToTest();
    	String password=firstDummyMember.getPassword();
    	String expectedPassword="$2a$10$Zeefmm34wm2IiY.xGKC9xuVER0Gg6lPDyWHCvb.GaBZM09JmWO1GW";
    	String otherPassword=secondDummyMember.getPassword();
    	assertEquals("Password equals null test succeeds",null,password);
    	assertNotEquals("OtherPassword does'nt equal null test succeeds",null,otherPassword);
    	assertEquals("OtherPassword equals '$2a$10$Zeefmm34wm2IiY.xGKC9xuVER0Gg6lPDyWHCvb.GaBZM09JmWO1GW' test succeeds",expectedPassword,otherPassword);
    	assertNotEquals("password unequals otherPassword",password,otherPassword);
    	assertFalse("secondDummyMember equals firstDummyMember",firstDummyMember.equals(secondDummyMember));
    }
    
 // Tests if username==null and otherUserName !=null, equals returns false
    @Test
    public void usernameIsNullOtherUsernameNotNullEqualsReturnsFalseTest() {
    	Member firstDummyMember=createDummyMemberToTest();
    	firstDummyMember.setUserName(null);
    	Member secondDummyMember=createDummyMemberToTest();
    	String username=firstDummyMember.getUserName();
    	String expectedUsername="Javanees";
    	String otherUsername=secondDummyMember.getUserName();
    	assertEquals("Username equals null test succeeds",null,username);
    	assertNotEquals("OtherUsername does'nt equal null test succeeds",null,otherUsername);
    	assertEquals("OtherUsername equals 'Javanees' test succeeds",expectedUsername,otherUsername);
    	assertFalse("secondDummyMember equals firstDummyMember",firstDummyMember.equals(secondDummyMember));
    }
    
 // Tests if username==null and otherUserName==null, equals returns false
 
    @Test
    public void usernameIsNullOtherUsernameIsNullEqualsReturnsFalseTest() {
    	Member firstDummyMember=createDummyMemberToTest();
    	firstDummyMember.setUserName(null);
    	Member secondDummyMember=createDummyMemberToTest();
    	secondDummyMember.setUserName(null);
    	String username=firstDummyMember.getUserName();
    	String otherUsername=secondDummyMember.getUserName();
    	assertEquals("Username equals null test succeeds",null,username);
    	assertEquals("OtherUsername equals null test succeeds",null,otherUsername);
    	assertTrue("username equals OtherUsername",username==otherUsername);
    	assertTrue("secondDummyMember equals firstDummyMember",firstDummyMember.equals(secondDummyMember));
    }
    
 // Tests if username==null and Username doesn't equal otherUsername, equals returns false
    @Test
    public void UsernameIsNullUsernameNotEqualsotherUsernameThenEqualsReturnsFalseTest() {
    	Member firstDummyMember=createDummyMemberToTest();
    	firstDummyMember.setUserName(null);
    	Member secondDummyMember=createDummyMemberToTest();
    	String username=firstDummyMember.getUserName();
    	String expectedUsername="Javanees";
    	String otherUsername=secondDummyMember.getUserName();
    	assertEquals("Username equals null test succeeds",null,username);
    	assertNotEquals("OtherUsername does'nt equal null test succeeds",null,otherUsername);
    	assertEquals("OtherUsername equals 'Javanees' test succeeds",expectedUsername,otherUsername);
    	assertNotEquals("username equals otherUsername",username,otherUsername);
    	assertTrue("username equals otherUserName", username!=otherUsername);
    	assertFalse("secondDummyMember equals firstDummyMember",firstDummyMember.equals(secondDummyMember));
    }
 
    
  //Test if username != null and username != otherUsername, equals returns false
    @Test
    public void UsernameNotNullUsernameNotEqualsotherUsernameThenEqualsReturnsFalseTest() {
    	Member firstDummyMember=createDummyMemberToTest();
    	firstDummyMember.setUserName("Marc");
    	Member secondDummyMember=createDummyMemberToTest();
    	secondDummyMember.setUserName("Gunther");
    	String username=firstDummyMember.getUserName();
    	String expectedUsernameFirst="Marc";
    	String expectedUsernameSecond="Gunther";
    	String otherUsername=secondDummyMember.getUserName();
    	assertNotEquals("Username equals null test succeeds",null,username);
    	assertNotEquals("OtherUsername does'nt equal null test succeeds",null,otherUsername);
    	assertEquals("Username equals 'Marc' test succeeds",expectedUsernameFirst,username);
    	assertEquals("OtherUsername equals 'Gunther' test succeeds",expectedUsernameSecond,otherUsername);
    	assertNotEquals("username equals otherUsername",username,otherUsername);
    	assertFalse("username equals otherUserName", username==otherUsername);
    	assertFalse("secondDummyMember equals firstDummyMember",firstDummyMember.equals(secondDummyMember));
    }
    
    
    	public static Member createDummyMemberToTest(){
		
		// Create a member to test different methods from above
				
				Member dummyMember = new Member();
				dummyMember.setUserID(128);
				dummyMember.setUserName("Javanees");
				dummyMember.setPassword("$2a$10$Zeefmm34wm2IiY.xGKC9xuVER0Gg6lPDyWHCvb.GaBZM09JmWO1GW");
				
		return dummyMember;
	}	


	
	
	
	
}