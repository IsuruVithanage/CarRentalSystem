package lk.carrental.spring.repo;

import lk.carrental.spring.entity.Driver;
import lk.carrental.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {
    Vehicle findTopByOrderByVehicleIDDesc();

    @Query(value = "FROM Vehicle WHERE availability=:status")
    List<Vehicle> getSelectedVehicles(@Param("status")String status);

    @Modifying
    @Query(value = "UPDATE Vehicle SET availability=:status WHERE vehicleID=:id")
    void changeVehicleAvailability(@Param("status")String status,@Param("id")String id);

    @Modifying
    @Query(value = "UPDATE Vehicle SET imgOne=:path1,imgTwo=:path2,imgThree=:path3,imgFour=:path4,imgFive=:path5 WHERE vehicleID=:id")
    void saveImgOne(@Param("path1")String path1,@Param("path2")String path2,@Param("path3")String path3,@Param("path4")String path4,@Param("path5")String path5,@Param("id")String id);
}
