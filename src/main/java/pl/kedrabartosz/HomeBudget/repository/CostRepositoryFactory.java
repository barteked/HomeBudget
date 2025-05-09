package pl.kedrabartosz.HomeBudget.repository;

import java.util.ArrayList;

public class CostRepositoryFactory {

  private CostRepositoryFactory() {
  }

  public static CostRepository createCostRepository(){
    return new ListBasedRepository(new ArrayList<>());
  }
}
