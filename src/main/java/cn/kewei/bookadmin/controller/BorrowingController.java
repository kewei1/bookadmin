package cn.kewei.bookadmin.controller;

import cn.kewei.bookadmin.service.IBorrowingService;
import cn.kewei.bookadmin.pojo.Borrowing;
import cn.kewei.bookadmin.util.AdminException;
import cn.kewei.bookadmin.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/borrowing")
public class BorrowingController {

    @Autowired
    private IBorrowingService borrowingService;

    @GetMapping("/list")
    public Result list() {
        try {
            List<Borrowing> list = borrowingService.findAll();
            return new Result("查询成功", list);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }

    @GetMapping("/findByStatus")
    public Result findByStatus(@RequestParam Integer status) {
        try {
            List<Borrowing> list = borrowingService.findByStatus(status);
            return new Result("查询成功", list);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }

    @GetMapping("/lostBook")
    public Result findByStatus(@RequestParam Long id) {
        try {
            borrowingService.lostBook(id);
            return new Result("上报丢失/损坏成功", null);
        } catch (AdminException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("系统错误");
        }
    }
}
