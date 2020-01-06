package abc.rpc.dubbo.service;

import abc.rpc.dubbo.R;
import abc.rpc.dubbo.model.Computer;

public interface ComputerService {


    R<Computer> getComputerById(Long id);


}
