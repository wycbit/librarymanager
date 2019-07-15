package cn.bit.edu.web;

import cn.bit.edu.dto.AppointmentExecution;
import cn.bit.edu.dto.Result;
import cn.bit.edu.entity.Appointment;
import cn.bit.edu.entity.Book;
import cn.bit.edu.enums.AppointmentEnum;
import cn.bit.edu.exception.NoNumberException;
import cn.bit.edu.exception.RepeatAppointException;
import cn.bit.edu.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    private String list(Model model){
        List<Book> books = bookService.getList();
        model.addAttribute("list",books);
        return "list";
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    private String detail( Long bookId, Model model){
        if(bookId == null){
            return "redirect:/book/list";
        }
        Book book = bookService.getBook(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book",book);
        return "detail";
    }

    @RequestMapping(value = "/appoint",method = RequestMethod.POST,produces = {"application/json; charset=utf-8"})
    @ResponseBody
    private Result<AppointmentExecution> appoint(Long bookId,Long studentId){
        if(studentId == null || "".equals(studentId)){
            return new Result<AppointmentExecution>(false,"学号不能为空");
        }
        AppointmentExecution appointment = null;
        try {
            appointment = bookService.appoint(bookId,studentId);
        }catch (NoNumberException e) {
            appointment = new AppointmentExecution(bookId, AppointmentEnum.NO_NUMBER);
        }catch (RepeatAppointException e) {
            appointment = new AppointmentExecution(bookId,AppointmentEnum.REPEAT_APPOINT);
        }catch (Exception e) {
            appointment = new AppointmentExecution(bookId,AppointmentEnum.INNER_NUMBER);
        }
        return new Result<AppointmentExecution>(true,appointment);
    }



}
