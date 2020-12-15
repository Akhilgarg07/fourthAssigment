//package com.nagarro.assignmentFour;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import com.nagarro.assignmentFour.entity.Flight;
//import com.nagarro.assignmentFour.entity.User;
//import com.nagarro.assignmentFour.repository.FlightDTO;
//import com.nagarro.assignmentFour.repository.UserRepository;
// 
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
//public class FlightRepositoryTest {
//	public static final SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
//    @Autowired
//    private TestEntityManager entityManager;
//     
//    @Autowired
//    private FlightDTO repo;
//    
//    @Test
//    public void testCreateUser() throws ParseException {
//    	Flight flight = new Flight();
//    	flight.setFlight_no("a");
//    	flight.setDep_loc("DEL");
//    	flight.setArr_loc("MUM");
//    	flight.setValid_till(dateformat.parse("12-11-2012"));
//    	flight.setFlight_time(30);
//    	flight.setFlight_dur(4.5);
//    	flight.setFare(200);
//    	flight.setSeat_availability("Y");
//    	flight.setFlight_class("EB");
//         
//        Flight savedUser = repo.save(flight);
//         
//        Flight existFlight = entityManager.find(Flight.class, savedUser.getId());
//         
//        assertThat(flight.getArr_loc()).isEqualTo(existFlight.getArr_loc());
//         
//    }
//
//    
//}