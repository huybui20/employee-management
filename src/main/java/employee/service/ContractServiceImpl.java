package employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.model.Contract;
import employee.repository.ContractRepository;


@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractRepository contractRepository;
	@Override
	public void saveContract(Contract contract) {
		this.contractRepository.save(contract);
	}

	@Override
	public void deleteContractById(Long id) {
		this.contractRepository.deleteById(id);
	}

	@Override
	public List<Contract> getAllContracts() {
		return contractRepository.findAll();
	}

	@Override
	public Contract getContractById(long id) {
		Optional<Contract> optional = contractRepository.findById(id);
		Contract contract = null;
		if (optional.isPresent()) {
			contract = optional.get();
		} else {
			return null;
		}
		return contract;
	}
	@Override
	public Employee getEmployee(long id) {
		return employeeService.getEmployeeById(id);
	}
}
