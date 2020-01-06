package abc.rpc.dubbo.controller;

import abc.rpc.dubbo.R;
import abc.rpc.dubbo.model.Computer;
import abc.rpc.dubbo.service.ComputerService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("computer")
public class TestController {

    @Reference(interfaceClass = ComputerService.class)
    ComputerService computerService;

    @GetMapping("detail/{id}")
    public R getComputerById(@PathVariable Long id){
        return computerService.getComputerById(id);
    }


}
