package rico.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import rico.demo.domain.Book;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Rico.Chen on 2017/3/2.
 */
@Controller
@Slf4j
public class HomeController {

    /**
     * http://localhost:8080 get
     * @return
     */
    @GetMapping("/")
    public String toIndex(Book book) {
        return "index";
    }

//    @PostMapping("/")
//    public String addNewBook(@Valid  Book book, BindingResult result) {
//        /**
//         * 验证有错
//         */
//        if(result.hasErrors()) {
//            List<ObjectError> errors = result.getAllErrors();
//            for (ObjectError error : errors) {
//                log.info(error.getDefaultMessage());
//            }
//            return "index";
//        }
//        return "result";
//    }

    @PostMapping("/")
    @ResponseBody
    public String createBook(@Valid  @RequestBody Book book, BindingResult result) {
        /**
         * 验证有错
         */
        String errorsMsg = "";
        if(result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                log.info(error.getDefaultMessage());
                errorsMsg += error.getDefaultMessage();
            }
            return errorsMsg;
        }
        return "Create success.";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public String updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
            log.info(id.toString());
            log.info(book.toString());
        return "success";
    }


    /**
     * restFull
     *
     *  /book    get   主页 url  显示所有数据列表
     *  /book/new  get 进入新增页 url
     *  /book post  提交新增数据 action
     *  /book/1/update  get 进入id=1的修改页 url
     *  /book/1  put  提交修改数据 action
     *  /book/1  delete 提交删除数据 action
     *  /book/1 get 进入id=1的详情页 显示一个数据信息 url
     *
     *
     *
     *
     *
     */

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        log.info(id.toString());
        return "success";
    }
}
