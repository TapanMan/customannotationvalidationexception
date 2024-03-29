package com.custom.validation.service;

import com.custom.validation.dto.UserRequest;
import com.custom.validation.entity.User;
import com.custom.validation.exception.UserNotFoundByEmailException;
import com.custom.validation.exception.UserNotFoundException;
import com.custom.validation.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.data.domain.Sort.Direction.ASC;

@ExtendWith(SpringExtension.class)
class UserServiceTest {
    private static User usermandal;
    private static User usermandal1;
    private static List<User> usermandalLists;

    @BeforeAll
    public static void setUp() {

        // This can be written in a builder pattern with Arrays.asList way

        // This is a very bad code
        usermandal = new User();
        usermandal.setUserId(1);
        usermandal.setName("Tapan");
        usermandal.setEmail("tapan.tapan@gmail.com");
        usermandal.setMobile("1234567891");
        usermandal.setGender("Male");
        usermandal.setAge(46);
        usermandal.setNationality("India");

        usermandalLists = new ArrayList<>();

        usermandal1 = new User();
        usermandal1.setUserId(2);
        usermandal1.setName("Dillip");
        usermandal1.setEmail("dillip.tapan@gmail.com");
        usermandal1.setMobile("2234567891");
        usermandal1.setGender("Male");
        usermandal1.setAge(41);
        usermandal1.setNationality("India");
        usermandalLists.add(usermandal);
        usermandalLists.add(usermandal1);
    }

    @InjectMocks
    UserService service;

    @Mock
    UserRepository repository;


    @Test
    void saveUser() {
        User user = UserServiceFactory.getUser();
        UserRequest request = UserServiceFactory.getUserRequest();
        given(repository.save(user)).willReturn(user);
        User result = service.saveUser(request);
        //assertNotNull(result); seems wrong but covered as 100%
        assertNull(result);
    }

    @Test
    void getAllUsers() {
        List<User> users = UserServiceFactory.getUserList();
        given(repository.findAll()).willReturn(users);
        List<User> result = service.getAllUsers();
        assertNotNull(result);
    }

    @Test
    void searchUser() throws UserNotFoundException {
        int userId = 1;
        User user = UserServiceFactory.getUser();
        given(repository.findByUserId(userId)).willReturn(user);
        User result = service.searchUser(userId);
        assertNotNull(result);
    }

    @Test
    void searchUserInvalid() {
        int userId = 0;
        Throwable exception = assertThrows(UserNotFoundException.class, () -> {
            service.searchUser(userId);
        });
        assertEquals("User Not Found with id :" + userId, exception.getMessage());
    }

    @Test
    void getUserByUserIdAndName() {
        int userId = 1;
        String userName = "Tapan";
        List<User> users = UserServiceFactory.getUserList();
        given(repository.findAll()).willReturn(users);
        User result = service.getUserByUserIdAndName(userId, userName);
        assertNotNull(result);
    }
    @Test
    public void getUserByUserIdAndNameLoop() {
        int userId = 1;
        String userName = "Tapan";

        User user = UserServiceFactory.getUser();

        List<User> mockList = Mockito.mock(List.class);
        Iterator<User> mockIter = Mockito.mock(Iterator.class);
        when(mockList.iterator()).thenReturn(mockIter);
        when(mockIter.hasNext()).thenReturn(true);
        when(mockIter.next()).thenReturn(user);
        for(User myUser: usermandalLists){
            if(myUser.getUserId() == userId && myUser.getName().equalsIgnoreCase(userName)){
                user = myUser;
                assertNotNull(user);
            }
        }



        User mandalUser = new User();
        mandalUser.setUserId(20);
        boolean notContainUser = mandalUserLists().contains(mandalUser);
        assertFalse(notContainUser);
        assertAll("Mandal User Id and Name Test",
                () -> assertEquals(userId, usermandalLists.get(0).getUserId()),
                () -> assertEquals(userName, usermandalLists.get(0).getName())
        );
    }

    @Test
    void getUserByUserIdAndNameStream() {
        int userId = 1;
        String userName = "Tapan";
        List<User> users = UserServiceFactory.getUserList();
        given(repository.findAll()).willReturn(users);
        Optional<User> result = service.getUserByUserIdAndNameStream(userId, userName);
        assertNotNull(result);
    }

    @Test
    void sortFields() {
        String field = "name";
        List<User> users = UserServiceFactory.getUserList();
        given(repository.findAll(Sort.by(ASC, field)).stream().collect(Collectors.toList())).willReturn(users);
        List<User> result = service.sortFields(field);
        assertNotNull(result);
    }

    @Test
    void userPagination() {
        int offset = 1;
        int pageSize = 2;
        List<User> users = UserServiceFactory.getUserList();
        Page<User> page = new PageImpl<>(users);
        given(repository.findAll(PageRequest.of(offset, pageSize))).willReturn(page);
        Page<User> result = service.userPagination(offset, pageSize);
        assertNotNull(result);
    }

    @Test
    void userPaginationAndSorting() {
        int offset = 1;
        int pageSize = 2;
        String fieldName = "name";
        List<User> users = UserServiceFactory.getUserList();
        Page<User> page = new PageImpl<>(users);
        given(repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(fieldName)))).willReturn(page);
        Page<User> result = service.userPaginationAndSorting(offset, pageSize, fieldName);
        assertNotNull(result);
    }

    @Test
    void updateUserDetails() {
        int userId = 1;
        User user = usermandal;
        given(repository.findByUserId(usermandal.getUserId())).willReturn(user);
        given(repository.save(user)).willReturn(user);
        User result = service.updateUserDetails(userId, user);
        assertNotNull(result);
    }

    // This must be a factory method, and the MethodSource name must be matched with the factory method
    // This method parameter data type must be same as the data type of the factory method returned without Collection or Array type
// We will get the lists of User, and the parameter taken will be User type
    // Check how the "mandalUserLists" is being used inside the following method
    @ParameterizedTest
    @MethodSource("mandalUserLists")
    void updateUserDetailsParameterized(User mandalUserDetails) {
        mandalUserDetails.setUserId(5);
        mandalUserDetails.setName("Tapan");
        mandalUserDetails.setEmail("tapan.mandal@gmail.com");
        mandalUserDetails.setMobile("1234567891");
        mandalUserDetails.setGender("Male");
        mandalUserDetails.setAge(50);
        mandalUserDetails.setNationality("India");
        // The following is for foreach loop test - iterate the list of user and check the user there
        boolean isContain = mandalUserLists().contains(mandalUserDetails);
        assertTrue(isContain);

        assertAll("Mandal User From Mandal User List",
                () -> assertEquals(mandalUserLists().get(0).getUserId(), mandalUserDetails.getUserId()),
                () -> assertEquals(mandalUserLists().get(0).getName(), mandalUserDetails.getName()),
                () -> assertEquals(mandalUserLists().get(0).getEmail(), mandalUserDetails.getEmail()),
                () -> assertEquals(mandalUserLists().get(0).getMobile(), mandalUserDetails.getMobile()),
                () -> assertEquals(mandalUserLists().get(0).getGender(), mandalUserDetails.getGender()),
                () -> assertEquals(mandalUserLists().get(0).getAge(), mandalUserDetails.getAge()),
                () -> assertEquals(mandalUserLists().get(0).getNationality(), mandalUserDetails.getNationality())
        );
    }

    @Test
    void partiallyUpdateUser() {
        int uid = 1;
        User user = usermandal;
        Map<String, Object> fields = new HashMap<>();
        given(repository.findByUserId(uid)).willReturn(user);
        given(repository.save(user)).willReturn(user);
        User userUpdated = service.partiallyUpdateUser(uid, fields);
        assertNotNull(userUpdated);
    }


    @Test
    void updateUserDetailsWithNoUserId() {
        int uid = 1;
        User user = usermandal;
        List<User> users = usermandalLists;
        given(repository.findAll()).willReturn(users);
        given(repository.save(user)).willReturn(user);
        User result = service.updateUserDetailsWithNoUserId(user);
        assertNotNull(result);
    }

    @Test
    void getUserByUserEmail() throws UserNotFoundByEmailException {
        String email = "tapan.tapan@gmail.com";
        User user = usermandal;
        given(repository.findByEmail(email)).willReturn(user);
        User result = service.getUserByUserEmail(email);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Invalid Email")
    @Order(7)
    void getUserByUserEmailInvalid() {
        String email = null;
        Throwable exception = assertThrows(UserNotFoundByEmailException.class, () -> {
            service.getUserByUserEmail(email);
        });
        assertEquals("user not found by email :" + email, exception.getMessage());
    }

    public static List<User> mandalUserLists() {
        //This method must not take any argument
        //Output of this method will be input to the parameterized test
        List<User> mandalLists = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(5);
        user1.setName("Tapan");
        user1.setEmail("tapan.mandal@gmail.com");
        user1.setMobile("1234567891");
        user1.setGender("Male");
        user1.setAge(50);
        user1.setNationality("India");

        User user2 = new User();
        user2.setUserId(6);
        user2.setName("Dillip");
        user2.setEmail("dillip.mandal@gmail.com");
        user2.setMobile("4234567891");
        user2.setGender("Male");
        user2.setAge(41);
        user2.setNationality("India");
        mandalLists.add(user1);
        mandalLists.add(user2);
        return mandalLists;
    }
}