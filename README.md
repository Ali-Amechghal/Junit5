# Junit5
Notes in Junit 5

# Architecture


# New In Junit5
	- with junit 5 you dont need the public no args constructor	
	- you can pass parameters to the constructor and test methods using Parameter resolver (ex : TestInfoDislayResolver)
	- new annotation @DisplayName("the name that will be displayed in test report") it can be used for class or method test
	- the test method can be protected or default (in junit4 it can be only public)

#Assertions
	all provided assertions are static methods in the class org.junit.jupiter.api.Assertions

	each assertion has a at least three variant methods
		Ex :
```java 
			assertNull(value)
			assertNull(value, message)
			assertNull(str, () -> complexMessageBuilder)
```

	B.P : always use the assert the lambda expression in case you seek a lazy execution (ex: creating a complex string)

	All asserts will throw AssertionFailedError when it fail

## Some must used assertions
	assertTrue(vaue)
	assertFalse(value)
	assertEquals(expected , value)
	assertNotEquals(expected , value)
	assertArrayEquals(expected, value)
	assertSame(instanceone , instancetwo) // the same instance
	assertNotSame(instanceone , instancetwo) 

	B.P : Avoid using more than one assert in the same test method unless you ckeck the same behavior,
	cause if the test fails you cannot know which assert failed

	B.P : use assertAll to regroupe asserts in the same method
		assertAll(() -> assertTrue(xx),
				  () -> assertEquals(expected, value))

				  in this case the test will fail if one or more of asserts failed , and we get all fails in the same report

# Life Cycle

	. Setup (class level) @BeforeAll public static setUpAll (ex : database connection)

		... Setup (method level) @BeforeEach : you can have multiple but the order not garanted in the same class , but the super will run first

			... Test (@Test)

		... Cleanup (Method level) @AfterEach 

	. Clean Up (class level) @AfterAll

## Test Instance

Test engine will build instance for class for each test method , if you prefere to use a single class instance for all test methods
```java
	@TestInstance(LifeCycle.PER_CLASS)
	class CustomerSpec..
```
## Assumptions
condition to execute assertion , it not fail the test but stop the test it just abord the test
     assumeTrue, assumeFalse , AssumingThat
     
     Ex : the test will not fail, but it will be abored , cause the assert is not executed , the assume is false
```java
	assumeTrue(1 == 2);
	assertEquals(10, 1);
	
	assumingThat(boolean , () -> { assertEquals(,)}
	
```

you can put assumption in the beforeEach methods to control all method execution

## Interface & Default Method     



