package in.pwskills.nitin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.bean.StockApi;

public interface IStockRepository extends JpaRepository<StockApi, Integer>{

}
