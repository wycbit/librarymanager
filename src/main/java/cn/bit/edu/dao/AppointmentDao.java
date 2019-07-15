package cn.bit.edu.dao;

import cn.bit.edu.entity.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentDao {
    public int insertAppointment(Long bookId,Long studentId);
    public Appointment queryAppointment(@Param("bookId") Long bookId , @Param("studentId") Long studentId);
}
