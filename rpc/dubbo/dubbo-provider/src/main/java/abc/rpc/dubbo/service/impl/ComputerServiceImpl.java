package abc.rpc.dubbo.service.impl;

import abc.rpc.dubbo.R;
import abc.rpc.dubbo.model.Computer;
import abc.rpc.dubbo.service.ComputerService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(interfaceClass = ComputerService.class, timeout = 5000)
@Component
public class ComputerServiceImpl implements ComputerService {
    @Override
    public R<Computer> getComputerById(Long id) {
        Computer computer = new Computer(1L, "WC", 11, "BLUE");
        return R.<Computer>ok(computer);
    }
}
